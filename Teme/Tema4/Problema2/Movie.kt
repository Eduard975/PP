class Movie(
    private var Title:String,
    private var Price:Double
) {
    public fun payTicket(person:Customer, payMethod:Int):Boolean {
        return person.pay(Price, payMethod)
    }
}