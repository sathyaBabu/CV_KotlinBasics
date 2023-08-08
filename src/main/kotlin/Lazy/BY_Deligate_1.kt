package Lazy
import kotlin.reflect.KProperty

class DelegateByGetSet {
    // for get() method, ref - a reference to the object from
    // which property is read. prop - property
    operator fun getValue(ref: Any?, prop: KProperty<*>) = "textA"
    // for set() method, 'v' stores the assigned value
    operator fun setValue(ref: Any?, prop: KProperty<*>, v: String) {
        println("value = $v")
    }
}

object SampleBy {
    var s: String by DelegateByGetSet() // delegation for property
    @JvmStatic fun main(args: Array<String>) {
        println(s)
        s = "textB"
        s = "sathya"
    }
}