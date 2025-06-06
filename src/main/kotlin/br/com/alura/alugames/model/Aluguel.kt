package br.com.alura.alugames.model

import org.api.test.br.com.alura.alugames.model.Jogo
import java.time.LocalDate
import java.time.Period

data class Aluguel(val gamer:Usuario,
                   val jogo: Jogo,
                   val periodo:Periodo){
    val aluguel :Double = jogo.preco * periodo.emDias


    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor de R$ $aluguel ."
    }
}
