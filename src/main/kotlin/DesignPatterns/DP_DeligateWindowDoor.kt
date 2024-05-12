package DesignPatterns

interface ITask {
    fun displayComponentName()
}

class DelegateComponents(private val delegate: ITask) : ITask {
    override fun displayComponentName() {
        delegate.displayComponentName()
    }
}

class Window : ITask {
    override fun displayComponentName() {
        println("Door has been delegated. We are at Door")
    }
}

class Door : ITask {
    override fun displayComponentName() {
        println("Window has been delegated. We are at Window")
    }
}

fun main() {
    val window = Window()
    val door = Door()

    // This is where delegation is kicking in
    val delegateComponents = DelegateComponents(door)
    delegateComponents.displayComponentName()
}
