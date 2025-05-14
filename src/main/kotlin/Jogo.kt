package org.api.test


data class Jogo( val titulo: String, var capa: String) {
    val descricao = ""

    override fun toString(): String {
        return "Meu Jogo { \n" +
                "Título: $titulo \n"+
                "capa: $capa \n"+
                "descricao: $descricao \n"+
                "}"
    }
}