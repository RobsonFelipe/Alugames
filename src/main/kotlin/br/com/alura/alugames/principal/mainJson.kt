package br.com.alura.alugames.principal

import br.com.alura.alugames.model.Periodo
import br.com.alura.alugames.service.ApiConsumer
import java.time.LocalDate
import java.time.Period


fun main(){
        val consumer = ApiConsumer()
        val listaJogo = consumer.buscaJogosJson()
        val listaUsuarios = consumer.searchGamer()

        //        println(listGamer)

        val CurrentGamer = listaUsuarios.get(3)
        val SelectedGame  = listaJogo.get(4)

        val CurrentGamer2 = listaUsuarios.get(3)
        val SelectedGame2  = listaJogo.get(2)

        val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
        val aluguel = CurrentGamer.alugarJogo(SelectedGame, periodo)
        val aluguel2 = CurrentGamer.alugarJogo(SelectedGame2, periodo)

        println(aluguel)
        println(CurrentGamer.jogosAlugados)

    }
