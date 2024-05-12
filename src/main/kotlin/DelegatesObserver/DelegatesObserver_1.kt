package DelegatesObserver

import kotlin.properties.Delegates
/*
listeners property is now declared as mutableListOf<_TextChangedListener>()
 to hold multiple _TextChangedListener objects.
In the main() function, _PrintingTextChangedListener() is added to the
listeners list using the add() function. This allows multiple listeners to
 be registered with the _TextView1 instance.
_PrintingTextChangedListener now prints the changed text directly within
 the onTextChanged() function for demonstration purposes. You can adjust
  this behavior as needed.
 */
interface _TextChangedListener {
    fun onTextChanged(oldText: String, newText: String)
}

class _PrintingTextChangedListener : _TextChangedListener {
    private var text = ""

    override fun onTextChanged(oldText: String, newText: String) {
        text = "Text is changed: $oldText -> $newText"
        println(text)
    }
}

class _TextView1 {
    var listeners = mutableListOf<_TextChangedListener>() // Use MutableList to hold multiple listeners

    var text: String by Delegates.observable("<empty>") { _, old, new ->
        listeners.forEach { it.onTextChanged(old,new) }
    }
}

fun main() {

    val textView1 = _TextView1()
    textView1.
    listeners.
    add(_PrintingTextChangedListener()) // Add a _PrintingTextChangedListener to the listeners list

    with(textView1) {
        text = "My first string 1"
        text = "My next string 2"
    }
// A better cleaner approach
    val textView = _TextView1().apply {
        listeners.add(_PrintingTextChangedListener()) // Add a _PrintingTextChangedListener to the listeners list
    }

    with(textView) {
        text = "My first string"
        text = "My next string"
    }
}
