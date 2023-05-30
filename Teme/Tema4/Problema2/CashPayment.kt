class CashPayment (
    private var availableAmmount: Double
):PaymentMethod {
    public override fun pay(fee:Double) : Boolean {
        if(availableAmmount - fee < 0) {
            println("Fonduri insuficiente")
            return false
        } else {
            println("Plata: Cash")
            println("Inainte de Plata: $availableAmmount")
            availableAmmount -= fee
            println("Dupa Plata: $availableAmmount")
            return true
        }
    }
}