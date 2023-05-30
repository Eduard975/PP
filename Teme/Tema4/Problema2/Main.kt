import java.util.*

fun main() {
    val customer = Customer(CashPayment(234.2),
        CardPayment(BankAccount(553.2,"256 424 334 222", Date(2023, 11, 19), 388, "MIhai Alex")))

    val movie = Movie("Motanul Incaltat 2", 23.0)
    val movie2 = Movie("Jhon Wick 4", 31.5)
    // 0 - cash 1 - card

    println("Customer 1 ")
    movie.payTicket(customer, 0)
    println()
    movie2.payTicket(customer, 1)
}