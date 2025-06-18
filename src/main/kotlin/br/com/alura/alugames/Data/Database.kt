package br.com.alura.alugames.Data

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Database {
//
    fun getEntityManager(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager();
    }

}