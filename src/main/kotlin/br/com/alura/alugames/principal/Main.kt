package org.api.test.br.com.alura.alugames.principal

import br.com.alura.alugames.model.Usuario
import br.com.alura.alugames.service.ApiConsumer
import org.api.test.br.com.alura.alugames.model.Jogo
import transformarEmIdade
import java.util.*

/**
 * API de consulta de jogos https://www.cheapshark.com
 */
fun main() {
    val leitura = Scanner(System.`in`)
    var usuario = Usuario.criarGamer(leitura)
    println("Cadastro realizado com sucesso.")
    if (!usuario.dataNascimento.isNullOrBlank()) {
        println("Idade do usuario: " + usuario.dataNascimento?.transformarEmIdade())
    }
    do {
        println("Digite o codigo do jogo para buscar: ")
        val busca = leitura.nextLine()

        val search = ApiConsumer()
        var informacaoJogo = search.searchGame(busca)

        var meuJogo: Jogo? = null

        val result = runCatching {
            if (informacaoJogo != null) {
                meuJogo = Jogo(informacaoJogo.info.title, informacaoJogo.info.thumb)
            }

        }
        //Erro ao nao encontrar o jogo
        result.onFailure {
            println("Retorno vazio. Tente outro id.")
        }

        //Inserir um descrição para o jogo e nao incluir jogo null
        result.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s",true)){
                println("Insira a sua descrição personalizada.")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao  = descricaoPersonalizada
                println(meuJogo)

            } else {
                println("Descrição vai ser definida como o nome do jogo")
                meuJogo?.descricao  = meuJogo?.titulo
                println(meuJogo)
            }

            if (meuJogo != null) {
                usuario.jogosBuscados.add(meuJogo)
            }


        }
        println("Deseja consultar um novo jogo? S/N")
        val novaConsulta = leitura.nextLine()
    }while(novaConsulta.equals("s",true))

    println("Jogos buscados:")
    println(usuario.jogosBuscados)

    //Ordenação dos jogos por titulo
    println("Jogos ordenados por nome")
    usuario.jogosBuscados.sortBy {
        it?.titulo
    }
    usuario.jogosBuscados.forEach {
        println("Titulo:" + it?.titulo)
    }

    //Inclusao do filtro Hard Coded
    val filtro = usuario.jogosBuscados.filter {
        it?.titulo?.contains("Batman", true) ?: false
    }
    println("\n Jogos com filtro")
    println(filtro)

    //Exclusao do jogo da lista
    println("\n Deseja excluir algum jogo? S/N")
    val exclusao = leitura.nextLine()

    if (exclusao.equals("S",true)){
        println(usuario.jogosBuscados)
        println("\n Qual jogo deseja excluir? ")
        val jogo = leitura.nextInt()
        usuario.jogosBuscados.removeAt(jogo)
    }

    //Lista atualizada
    println("\n Lista atualizada")
    println(usuario.jogosBuscados)


    println("Busca foi finalizada com sucesso.")

}