package chain
import kotlinx.coroutines.*;
interface Handler {
    suspend fun handleRequest(forwardDirection: String, messageToBeProcessed: String)
    fun setNext(next1: Handler?, next2: Handler?)
}