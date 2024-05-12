package DesignPatterns

interface ITask2 {
    fun displayComponentName()
}

class DelegateComponents2(private val delegate: ITask) : ITask by delegate

class Window2 : ITask {
    override fun displayComponentName() {
        println("Door has been delegated using by . We are at Door")
    }
}

class Door2 : ITask {
    override fun displayComponentName() {
        println("Window has been delegated using by . We are at Window")
    }
}

fun main() {
    val window = Window2()
    val door = Door2()

    // This is where delegation is kicking in
    val delegateComponents = DelegateComponents(door)
    delegateComponents.displayComponentName()
}
// Window has been delegated using by . We are at Window

/*
The DelegateComponents class is declared as implementing the
 ITask interface by the delegate object using the by keyword.
  This simplifies the implementation, removing the need to explicitly
  define the displayComponentName() function.
 */