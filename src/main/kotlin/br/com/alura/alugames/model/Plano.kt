package br.com.alura.alugames.model

sealed class Plano(val tipo:String) {
    open fun obterValorAluguel(aluguel:Aluguel):Double{
        return  aluguel.jogo.preco * aluguel.periodo.emDias
    }
}