package org.api.test.br.com.alura.alugames.model


data class Jogo( val titulo: String, var capa: String) {
    var descricao: String? = null
    var preco = 0.0

    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: $preco"
    }

}