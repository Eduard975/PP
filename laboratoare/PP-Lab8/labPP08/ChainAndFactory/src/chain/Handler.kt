package chain

interface Handler {
    fun handleRequest(forwardDirection: String, messageToBeProcessed: String)
    fun setNext(next1: Handler?, next2: Handler?)
}