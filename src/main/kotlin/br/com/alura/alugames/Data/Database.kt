package br.com.alura.alugames.Data

import org.api.test.br.com.alura.alugames.model.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

object Database {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "mysecretpassword")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }


}