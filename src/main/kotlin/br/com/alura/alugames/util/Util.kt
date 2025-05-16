package br.com.alura.alugames.util

class  Util {
     fun validateEmail(email:String ):Boolean {
        val regex = Regex(pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")
        if (regex.matches(email)) {
            return true
        }else {
            throw IllegalArgumentException("Email invalido")
        }
     }


}