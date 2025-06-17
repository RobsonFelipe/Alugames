package br.com.alura.alugames.model

import org.api.test.br.com.alura.alugames.model.Jogo

data class Aluguel(val gamer:Usuario,
                   val jogo: Jogo,
                   val periodo:Periodo){
    val valorAluguel = gamer.plano.obterValorAluguel(this)


    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor de R$ $valorAluguel ."
    }
}
