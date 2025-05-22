package br.com.alura.alugames.principal

import br.com.alura.alugames.service.ApiConsumer


    fun main(){
        val consumer = ApiConsumer()
        val listGamer = consumer.searchGame()

        println(listGamer)
    }
