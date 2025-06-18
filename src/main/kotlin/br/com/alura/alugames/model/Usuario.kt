package br.com.alura.alugames.model

import br.com.alura.alugames.util.Util
import org.api.test.br.com.alura.alugames.model.Game
import java.util.*
import kotlin.random.Random

data class Usuario(var nome:String,var email:String) : Recomendavel{
    val util = Util()

    init{
        if (nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome invalido ou em branco")
        }
        util.validateEmail(this.email)
    }
    var plano: Plano = PlanoAvulso("BRONZE")
    val jogosAlugados: MutableList<Aluguel> = mutableListOf<Aluguel>()
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (id.isNullOrBlank()){
                createId()
            }
        }
    var id: String? = null
        private set

    var jogosBuscados = mutableListOf<Game?>()
    val jogosRecomendados = mutableListOf<Game>()
    private val listaDeNotas:MutableList<Int> = mutableListOf<Int>()

    override val media: Double
        get() = listaDeNotas.average()

    override fun recomendar(nota: Int) {
        listaDeNotas.add(nota)
    }


    constructor( nome:String,
                 email:String,
                 dataNascimento: String,
                 usuario: String) :
            this(nome,email) {
               this.dataNascimento = dataNascimento
               this.usuario = usuario
               createId()
            }

    override fun toString(): String {
        return "Usuario(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, id=$id, reputação=$media)"
    }

    fun createId(){
        val num = Random.nextInt(1000)
        val tag = String.format("%04d", num)
        this.id = "$usuario#$tag"
    }

    fun alugarJogo(game:Game, periodo:Periodo): Aluguel{
        val aluguel = Aluguel(this,game,periodo)
        jogosAlugados.add(aluguel)
        return aluguel
    }

    fun jogosDoMes(mes:Int): List<Game> {
        return jogosAlugados
            .filter { aluguel ->  aluguel.periodo.dataInicial.monthValue == mes}
            .map { aluguel ->  aluguel.game}
    }

    fun recomendarJogo(game:Game, nota:Int){
        game.recomendar(nota)
        jogosRecomendados.add(game)

    }

    companion object{
        fun criarGamer(leitura: Scanner): Usuario{
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()
            if (opcao.equals("s",true)){
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()
                return Usuario(nome,email,nascimento,usuario)
            }
            return Usuario(nome,email)
        }
    }
}
