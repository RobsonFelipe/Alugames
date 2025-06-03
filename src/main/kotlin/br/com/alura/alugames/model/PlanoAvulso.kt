package br.com.alura.alugames.model

class PlanoAvulso(tipo:String): Plano(tipo){

    override fun obterValorAluguel(aluguel: Aluguel): Double {
        var valorPadrao = super.obterValorAluguel(aluguel)
        if (aluguel.gamer.media > 8){
            valorPadrao -= valorPadrao * 0.1
        }
        return valorPadrao

    }
}
