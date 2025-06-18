package br.com.alura.alugames.Data

import org.api.test.br.com.alura.alugames.model.Game
import javax.persistence.EntityManager

class GameDAO(val manager: EntityManager) {

    fun getGames(): List<Game> {
        val query = manager.createQuery("FROM GameEntity", GameEntity::class.java)
        return query.resultList.map { entity ->
            Game(
                entity.titulo,
                entity.capa,
                entity.preco,
                entity.descricao.toString(),
                entity.id
            )
        }
    }

    fun addGame(game: Game){
        val entity = GameEntity(game.titulo, game.capa, game.preco, game.descricao)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }


}