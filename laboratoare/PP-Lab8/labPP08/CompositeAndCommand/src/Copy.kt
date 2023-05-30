class Copy: MenuItem(Command{println("Sunt in clasa Copy")}) {
    override fun clicked() {
        this.command.execute()
        println("Copy: clicked()")
    }
}