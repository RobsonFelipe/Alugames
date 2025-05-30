package br.com.alura.alugames.model

class PlanoAssinatura( tipo:String,
                       val mensalidade:Double,
                       val jogosInclusos: Int): Plano(tipo){
    override fun obterValorAluguel(aluguel: Aluguel): Double {
        val jogosMensais = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1

        return if (jogosMensais <= jogosInclusos){
            0.0
        }else{
            super.obterValorAluguel(aluguel)
        }
    }
}
