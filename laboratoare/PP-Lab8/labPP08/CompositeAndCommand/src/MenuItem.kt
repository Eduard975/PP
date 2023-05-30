open class MenuItem(val command: Command) {
    open fun clicked() {
        command.execute()
    }
    open fun add(component: MenuItem) {}
    open fun remove(component: MenuItem) {}
    open fun getComponents(): List<MenuItem> = TODO()
}