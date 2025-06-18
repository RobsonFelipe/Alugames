package org.api.test.br.com.alura.alugames.model

import br.com.alura.alugames.model.Recomendavel
import com.google.gson.annotations.Expose
import java.math.BigDecimal
import java.math.RoundingMode


data class Game(@Expose val titulo: String,
                @Expose var capa: String ):Recomendavel {

    var id = 0
    var descricao: String? = null
    var preco : BigDecimal = BigDecimal(0)
    private val avaliacoes:MutableList<Int> = mutableListOf<Int>()
    override val media: Double
        get() = avaliacoes.average()

    override fun recomendar(nota: Int) {
        avaliacoes.add(nota)
    }

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String, id:Int = 0):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }

    override fun toString(): String {
        val formatPrice = preco.setScale(2, RoundingMode.DOWN)
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: $formatPrice \n" +
                "Reputação: $media"
    }

}