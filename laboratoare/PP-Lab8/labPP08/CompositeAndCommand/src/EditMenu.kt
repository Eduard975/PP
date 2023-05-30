class EditMenu: MenuItem(Command{println("Sunt in clasa EditMenu")}) {
    private var components: MutableList<MenuItem> = mutableListOf()

    override fun clicked() {
        this.command.execute()
        println("EditMenu: clicked()")
    }

    override fun add(component: MenuItem) {
        components.add(component)
    }

    override fun remove(component: MenuItem) {
        components.remove(component)
    }

    override fun getComponents(): MutableList<MenuItem> {
        return components
    }
}