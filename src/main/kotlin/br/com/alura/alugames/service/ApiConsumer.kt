package br.com.alura.alugames.service

import br.com.alura.alugames.model.InfoUsuarioJson
import br.com.alura.alugames.model.Usuario
import br.com.alura.alugames.util.mapperUsuario
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.api.test.br.com.alura.alugames.model.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ApiConsumer {

    val URL_CHEAPSHARK = "https://www.cheapshark.com/api/1.0/games?id="
    val URL_JSON = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

    fun searchGame(id: String) : InfoJogo? {

        val json = createHttpRequest(URL_CHEAPSHARK +"$id")
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

    fun searchGame() : List<Usuario> {
        val json = createHttpRequest(URL_JSON)

        val gson = Gson()
        val typeGamer = object: TypeToken<List<InfoUsuarioJson>>() {}.type
        var listaGamer:List<InfoUsuarioJson> = gson.fromJson(json, typeGamer)

        val listaUsuario = listaGamer.map {
             infoUsuarioJson ->  infoUsuarioJson.mapperUsuario()
        }

        return listaUsuario

    }

    private fun createHttpRequest(endereco: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        return response.body()
    }

}