class Customer(
    private var cash:CashPayment,
    private var card:CardPayment,
) {
    public fun pay(Fee:Double, Method:Int):Boolean {
        return when (Method) {
            0 -> {
                cash.pay(Fee)
            }

            1 -> {
                card.pay(Fee)
            }

            else -> {
                println("Invalid Method!")
                false
            }
        }
    }
}