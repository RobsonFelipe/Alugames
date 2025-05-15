package br.com.alura.alugames.service

import com.google.gson.Gson
import org.api.test.br.com.alura.alugames.model.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ApiConsumer {

    fun searchGame(id: String) : InfoJogo? {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()
        val gson = Gson()
        var meuInfoJogo: InfoJogo? = null

        val result = kotlin.runCatching {
            meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        }

        result.onFailure {
            println("Jogo não encontrado. Tente outro Id.")
        }

        return meuInfoJogo

    }

}