package org.api.test.br.com.alura.alugames.model


data class Jogo( val titulo: String, var capa: String) {
    var descricao: String? = null

    override fun toString(): String {
        return "Meu Jogo { \n" +
                "Título: $titulo \n"+
                "capa: $capa \n"+
                "descricao: $descricao \n"+
                "}"
    }
}