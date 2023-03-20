import java.util.Date

class BankAccount (
    private var availableAmmount:Double,
    private var CardNumber:String,
    private var expirationDate:Date,
    private var cvvCode:Int,
    private var userName:String
){
    public fun updateAmmount(value:Double): Boolean{
        if(availableAmmount + value < 0) {
            println("Fonduri insuficiente")
            return false
        } else {
            println("Plata: Card")
            println("Inainte de Plata: $availableAmmount")
            availableAmmount += value
            println("Dupa Plata: $availableAmmount")
            return true
        }
    }

}