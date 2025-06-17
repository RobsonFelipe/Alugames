package br.com.alura.alugames.util

import br.com.alura.alugames.model.InfoJogoJson
import org.api.test.br.com.alura.alugames.model.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}


