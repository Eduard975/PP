class CardPayment (
    private var BankAccount:BankAccount
):PaymentMethod {
    public override fun pay(fee:Double) : Boolean {
        return BankAccount.updateAmmount(-fee)
    }
}