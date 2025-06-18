package br.com.alura.alugames.util

import br.com.alura.alugames.model.InfoJogoJson
import org.api.test.br.com.alura.alugames.model.Game

fun InfoJogoJson.criaJogo(): Game {
    return Game(this.titulo, this.capa, this.preco, this.descricao)
}


