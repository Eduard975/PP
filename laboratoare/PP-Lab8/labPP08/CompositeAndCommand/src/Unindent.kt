class Unindent: MenuItem(Command{println("Sunt in clasa Unindent")}) {
    override fun clicked() {
        this.command.execute()
        println("Unindent: clicked()")
    }
}