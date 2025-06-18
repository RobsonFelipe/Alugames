package br.com.alura.alugames.model

import org.api.test.br.com.alura.alugames.model.Game

data class Aluguel(val gamer:Usuario,
                   val game: Game,
                   val periodo:Periodo){
    val valorAluguel = gamer.plano.obterValorAluguel(this)


    override fun toString(): String {
        return "Aluguel do ${game.titulo} por ${gamer.nome} pelo valor de R$ $valorAluguel ."
    }
}
