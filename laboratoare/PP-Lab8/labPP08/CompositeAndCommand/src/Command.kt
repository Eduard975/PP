class Command(private val command: ()->Unit) {
    fun execute() {
        command()
    }
}