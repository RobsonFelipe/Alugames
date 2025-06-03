package br.com.alura.alugames.principal

import br.com.alura.alugames.model.Periodo
import br.com.alura.alugames.model.PlanoAssinatura
import br.com.alura.alugames.service.ApiConsumer
import java.time.LocalDate
import java.time.Period


fun main(){
        val consumer = ApiConsumer()
        val listaJogo = consumer.buscaJogosJson()
        val listaUsuarios = consumer.searchGamer()


        val currentGamer = listaUsuarios.get(3)
        val selectedGame  = listaJogo.get(4)

        val currentGamer2 = listaUsuarios.get(3)
        val selectedGame2  = listaJogo.get(2)

        val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
        val aluguel = currentGamer.alugarJogo(selectedGame, periodo)
        val aluguel2 = currentGamer.alugarJogo(selectedGame2, periodo)

        println(aluguel)
        println(currentGamer.jogosAlugados)

        val currentGamer3 = listaUsuarios.get(5)
        val selectedGame3  = listaJogo.get(6)
        val selectedGame4  = listaJogo.get(7)
        currentGamer3.plano = PlanoAssinatura("PRATA",9.90,3,0.15)
        currentGamer3.alugarJogo(selectedGame3,periodo)
        currentGamer3.alugarJogo(selectedGame2,periodo)
        currentGamer3.alugarJogo(selectedGame,periodo)
        currentGamer3.alugarJogo(selectedGame4,periodo)
        println(currentGamer3.jogosAlugados)

        currentGamer3.recomendar(10)
        currentGamer3.recomendar(10)
        currentGamer3.recomendar(10)
        println(currentGamer3.toString())

        currentGamer3.alugarJogo(selectedGame3,periodo)
        println(currentGamer3.jogosAlugados)



    }
