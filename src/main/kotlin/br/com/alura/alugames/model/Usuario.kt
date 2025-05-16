package br.com.alura.alugames.model

import br.com.alura.alugames.util.Util
import kotlin.random.Random

data class Usuario(var nome:String,var email:String){
    val util = Util()

    init{
        if (nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome invalido ou em branco")
        }
        util.validateEmail(this.email)
    }

    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (id.isNullOrBlank()){
                createId()
            }
        }
    var id: String? = null
        private set

    constructor( nome:String,
                 email:String,
                 dataNascimento: String,
                 usuario: String) :
            this(nome,email) {
               this.dataNascimento = dataNascimento
               this.usuario = usuario
               createId()
            }

    override fun toString(): String {
        return "Usuario(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, id=$id)"
    }

    fun createId(){
        val num = Random.nextInt(1000)
        val tag = String.format("%04d", num)
        this.id = "$usuario#$tag"
    }


}
