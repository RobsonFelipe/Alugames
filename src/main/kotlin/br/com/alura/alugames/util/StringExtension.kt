import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEmIdade():Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0
    val dataNascimento = LocalDate.parse(this,formatter)
    val currentDate = LocalDate.now()
    idade = Period.between(dataNascimento, currentDate).years

    return idade
}
