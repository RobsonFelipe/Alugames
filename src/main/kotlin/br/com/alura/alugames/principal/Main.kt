package org.api.test.br.com.alura.alugames.principal

import br.com.alura.alugames.service.ApiConsumer
import org.api.test.br.com.alura.alugames.model.Jogo
import java.util.*

/**
 * API de consulta de jogos https://www.cheapshark.com
 */
fun main() {
    val leitura = Scanner(System.`in`)
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

    result.onFailure {
        println("Retorno vazio. Tente outro id.")
    }

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
    }
}