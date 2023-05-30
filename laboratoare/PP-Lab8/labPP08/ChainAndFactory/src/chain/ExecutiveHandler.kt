package chain

class ExecutiveHandler(var next1: Handler? = null, var next2: Handler? = null): Handler {
    override fun handleRequest(forwardDirection: String, messageToBeProcessed: String) {
        val processedMessage = messageToBeProcessed.split(":");

        when(processedMessage[0]){
            "2" -> {
                println("Mesaj procesat de Executiv: " + processedMessage[1]);
            }

            else -> {
                when(forwardDirection) {
                    "Up", "Down" -> {
                        next2?.handleRequest("Right", messageToBeProcessed);
                    }
                    else -> {
                        next1?.handleRequest("Right", messageToBeProcessed)
                    }
                }
            }
        }
    }

    override fun setNext(next1: Handler?, next2: Handler?){
        this.next1 = next1;
        this.next2 = next2;
    }
}