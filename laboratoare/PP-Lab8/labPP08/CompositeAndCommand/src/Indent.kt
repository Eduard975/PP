class Indent: MenuItem(Command{println("Sunt in clasa Indent")}) {
    override fun clicked() {
        this.command.execute()
        println("Indent: clicked()")
    }
}