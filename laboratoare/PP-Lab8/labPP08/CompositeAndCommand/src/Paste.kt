class Paste: MenuItem(Command{println("Sunt in clasa Paste")}) {
    override fun clicked() {
        this.command.execute()
        println("Paste: clicked()")
    }
}