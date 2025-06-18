package br.com.alura.alugames.Data

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name="jogo")
class GameEntity (

    val titulo: String = "Titulo do jogo",
    val capa: String = "Capa do jogo",
    val preco: BigDecimal = BigDecimal(0),
    val descricao: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int = 0
    ){


}