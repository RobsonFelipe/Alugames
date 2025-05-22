package br.com.alura.alugames.model

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

data class InfoUsuarioJson(val nome:String,
                           val email:String,
                           val dataNascimento:String,
                           val usuario:String){


}
