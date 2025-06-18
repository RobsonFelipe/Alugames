package br.com.alura.alugames.principal

import br.com.alura.alugames.Data.Database
import br.com.alura.alugames.Data.GameDAO
import org.api.test.br.com.alura.alugames.model.Game
import java.math.BigDecimal

fun main(){
    val theLastOfUs = Game("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", BigDecimal(5.99),"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val dandara = Game("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", BigDecimal(9.99),"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    val manager = Database.getEntityManager()
    val gameDao = GameDAO(manager)

    gameDao.addGame(theLastOfUs)
    gameDao.addGame(dandara)

    val listOfAllGames: List<Game> = gameDao.getGames()
    println(listOfAllGames)






}