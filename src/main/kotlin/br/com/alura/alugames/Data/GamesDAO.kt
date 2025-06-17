package br.com.alura.alugames.Data

import br.com.alura.alugames.Data.Database.obterConexao
import org.api.test.br.com.alura.alugames.model.Jogo
import java.util.*

object GamesDAO{

    private final val QUERY_INSERT_GAMES = "INSERT INTO jogos (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"
    private final val QUERY_SELECT_ALL_GAMES = "SELECT * FROM jogos"

    fun getAllJogos(): Optional<List<Jogo>> {
        val listOfAllGames = mutableListOf<Jogo>()
        val conexao = Database.obterConexao()
        if (conexao != null){
            try {
                val statement = conexao.createStatement()
                val resultado = statement.executeQuery(QUERY_SELECT_ALL_GAMES)

                while (resultado.next()){
                    val id = resultado.getInt("id")
                    val titulo = resultado.getString("titulo")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val preco = resultado.getBigDecimal("preco")

                    val jogo = Jogo(titulo,capa,preco, descricao)
                    listOfAllGames.add(jogo)
                }

                statement.close()
            }finally{
                conexao.close()
            }
        }

        return Optional.of(listOfAllGames)
    }

    fun saveNewGame(jogo:Jogo) {

        val conexao = Database.obterConexao()
        if (conexao != null){
            try {
                val statement = conexao.prepareStatement(QUERY_INSERT_GAMES)
                statement.setString(1,jogo.titulo)
                statement.setString(2,jogo.capa)
                statement.setDouble(3,jogo.preco.toDouble())
                statement.setString(4,jogo.descricao)

                statement.executeUpdate()
                statement.close()
            }finally{
                conexao.close()
            }

        }

    }
}