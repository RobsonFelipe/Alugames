package org.api.test.br.com.alura.alugames.model

import br.com.alura.alugames.model.Recomendavel
import com.google.gson.annotations.Expose
import java.math.BigDecimal


data class Jogo(@Expose val titulo: String,@Expose var capa: String ):Recomendavel {
    var descricao: String? = null
    var preco : BigDecimal = BigDecimal(0)
    private val avaliacoes:MutableList<Int> = mutableListOf<Int>()
    override val media: Double
        get() = avaliacoes.average()

    override fun recomendar(nota: Int) {
        avaliacoes.add(nota)
    }

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: $preco \n" +
                "Reputação: $media"
    }

}