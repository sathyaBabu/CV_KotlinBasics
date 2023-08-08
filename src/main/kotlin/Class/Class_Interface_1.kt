package Class

interface  Clickable {
    fun click()
}
class  MacButton : Clickable {
    override fun click() = println(" You clicked on MAc Button")
}

class  WinButton : Clickable {
    override fun click() = println(" You clicked on Win Button")
}


fun main(){


    var mac = MacButton()
    mac.click()
}