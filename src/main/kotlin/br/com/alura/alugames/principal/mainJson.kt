package br.com.alura.alugames.principal

import br.com.alura.alugames.model.Periodo
import br.com.alura.alugames.model.PlanoAssinatura
import br.com.alura.alugames.service.ApiConsumer
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate
import java.time.Period


fun main(){
        val consumer = ApiConsumer()
        val listaJogo = consumer.buscaJogosJson()
        val listaUsuarios = consumer.searchGamer()


        val gamerCaroline = listaUsuarios.get(3)
        val jogoResidentVillage = listaJogo.get(10)
        val jogoSpider = listaJogo.get(13)
        val jogoTheLastOfUs = listaJogo.get(2)
        val jogoDandara = listaJogo.get(5)
        val jogoAssassins = listaJogo.get(4)
        val jogoCyber = listaJogo.get(6)
        val jogoGod = listaJogo.get(7)
        val jogoSkyrim = listaJogo.get(18)

        gamerCaroline.recomendarJogo(jogoResidentVillage, 7)
        gamerCaroline.recomendarJogo(jogoTheLastOfUs, 10)
        gamerCaroline.recomendarJogo(jogoAssassins, 8)
        gamerCaroline.recomendarJogo(jogoCyber, 7)
        gamerCaroline.recomendarJogo(jogoGod, 10)
        gamerCaroline.recomendarJogo(jogoDandara, 8)
        gamerCaroline.recomendarJogo(jogoSkyrim, 8)
        gamerCaroline.recomendarJogo(jogoSpider, 6)

        val gsonBuilder = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
        val serializacao = gsonBuilder.toJson(gamerCaroline.jogosRecomendados)

        println(serializacao)

        val arquivo = File("JogosRecomendados_$gamerCaroline.nome.json")
        arquivo.writeText(serializacao)
        println(arquivo.absolutePath)


    }
