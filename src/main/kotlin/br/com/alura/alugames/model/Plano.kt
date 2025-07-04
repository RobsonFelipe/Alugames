package br.com.alura.alugames.model

import java.math.BigDecimal

sealed class Plano(val tipo:String) {
    open fun obterValorAluguel(aluguel:Aluguel): BigDecimal {
        return  aluguel.game.preco * BigDecimal(aluguel.periodo.emDias)
    }
}