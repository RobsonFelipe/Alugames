package br.com.alura.alugames.model

import java.math.BigDecimal

class PlanoAvulso(tipo:String): Plano(tipo){

    private final val DESCONTO_AVULSO = BigDecimal(0.1)

    override fun obterValorAluguel(aluguel: Aluguel): BigDecimal {
        var valorPadrao = super.obterValorAluguel(aluguel)
        if (aluguel.gamer.media > 8){
            valorPadrao -= valorPadrao * DESCONTO_AVULSO
        }
        return valorPadrao

    }
}
