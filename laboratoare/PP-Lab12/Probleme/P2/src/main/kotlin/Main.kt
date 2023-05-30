import java.time.LocalDate

fun String.toDate(): LocalDate {
    val temp = this.split("/")
    return LocalDate.of(temp[2].toInt(), temp[1].toInt(), temp[0].toInt());
}

fun main(args: Array<String>) {
    println("Program arguments: " + "22/04/2002".toDate())
}