package br.com.alura.alugames.model

import java.math.BigDecimal

class PlanoAssinatura( tipo:String,
                       val mensalidade:Double,
                       val jogosInclusos: Int,
                       val descontoReputacao: BigDecimal): Plano(tipo){
    override fun obterValorAluguel(aluguel: Aluguel): BigDecimal {
        val jogosMensais = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1

        return if (jogosMensais <= jogosInclusos){
            BigDecimal(0.0)
        }else{
            var valorPadrao = super.obterValorAluguel(aluguel)
            if (aluguel.gamer.media >8){
                valorPadrao -= valorPadrao * descontoReputacao
            }
            valorPadrao
        }
    }
}
