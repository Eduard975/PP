fun main(args: Array<String>) {
    var editMenu = EditMenu()
    var copy = Copy()
    var paste = Paste()

    var lineMenu = LineMenu()
    var indent = Indent()
    var unindent = Unindent()

    lineMenu.add(indent)
    lineMenu.add((unindent))

    editMenu.add(copy)
    editMenu.add(paste)
    editMenu.add(lineMenu)

    editMenu.clicked()
    editMenu.getComponents().forEach{ it.clicked() }
    lineMenu.getComponents().forEach{ it.clicked() }
}