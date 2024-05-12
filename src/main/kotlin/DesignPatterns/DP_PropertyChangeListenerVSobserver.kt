
import java.beans.PropertyChangeSupport
import java.beans.PropertyChangeListener
/*

Observer and Listener pattern are very similar. But Observer has a weakness: all observables are the same.
You have to implement the logic that is based on instanceof and cast object to concrete type into
Observable.update() method.

Listeners are different. There are a lot of listener types. For example mouse listener,
 keyboard listener etc. Each one has several callback methods (i.e. keyPressed(), keyReleased() etc).
 So, you never have to implement the logic that should answer the question "is it my event"
 into the event handler.


*/


open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person5(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange(
                "age", oldValue, newValue)

        }

    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange(
                "salary", oldValue, newValue)
        }
}

fun main(args: Array<String>) {
    val p = Person5("Dmitry", 34, 2000)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed " +
                    "from ${event.oldValue} to ${event.newValue}")
        }
    )
    p.age = 35
    p.salary = 2100

//p.removePropertyChangeListener()

}
