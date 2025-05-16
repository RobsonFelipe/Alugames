import br.com.alura.alugames.model.Usuario


fun main(){
    var gamer = Usuario("Robson", "Robson@gmail.com")
    val gamer2 = Usuario("  ",
        "Robson@gmail.com",
        "09/07/1994",
        "For2Day")


    gamer.let {
        it.dataNascimento = "12/10/2000"
        it.usuario = "Joao123"

    }.also {
        println(gamer.id)
    }
    println(gamer)
    println(gamer2)
}