package org.api.test

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*
import java.util.logging.Logger

/**
 * API de consulta de jogos https://www.cheapshark.com
 */
fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite o codigo do jogo para buscar: ")
    val busca = leitura.nextLine()
    val url = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    val gson = Gson()
    var meuJogo: Jogo? = null

    val result = runCatching {
        val meuInfoJogo = gson.fromJson(json,InfoJogo::class.java)
        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)

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