package br.com.alura.alugames.principal

import br.com.alura.alugames.Data.Database
import br.com.alura.alugames.Data.GamesDAO
import org.api.test.br.com.alura.alugames.model.Jogo
import java.math.BigDecimal
import java.util.Optional

fun main(){
    val theLastOfUs = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", BigDecimal(5.99),"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")

     GamesDAO.saveNewGame(theLastOfUs)

    val listOfAllGames: Optional<List<Jogo>> = GamesDAO.getAllJogos()
    if (listOfAllGames.isPresent){
        println(listOfAllGames.get())
    }



}