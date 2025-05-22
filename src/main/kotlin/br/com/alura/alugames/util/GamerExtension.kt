package br.com.alura.alugames.util

import br.com.alura.alugames.model.InfoUsuarioJson
import br.com.alura.alugames.model.Usuario

fun InfoUsuarioJson.mapperUsuario(): Usuario{
   return Usuario(this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}