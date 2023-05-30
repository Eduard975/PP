package chain

class HappyWorkerHandler(var next1: Handler? = null, var next2: Handler? = null): Handler {
    override suspend fun handleRequest(forwardDirection: String, messageToBeProcessed: String) {
        val processedMessage = messageToBeProcessed.split(":");

        when (forwardDirection) {
            "Up", "Down" -> {
                next1?.handleRequest("None", messageToBeProcessed);
            }

            else -> {
                println("Mesaj procesat de Worker: " + processedMessage[1]);
            }
        }
    }

    override fun setNext(next1: Handler?, next2: Handler?){
        this.next1 = next1;
        this.next2 = next2;
    }
}