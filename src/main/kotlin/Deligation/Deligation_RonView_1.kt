package Deligation

// https://www.youtube.com/watch?v=JWVjmyo6e5Y
// refer delegation with c++ and android

/*

RoomView delegation is from iPhone Api
Room has Door window, couch each component has many smaller elements
treat element and the component as equal -> Composite design pattern

Factory gets the repeat component's like door instead of creating door many times
use prototype to return a copy of it saves time

Command can store and reproduce as the room gets scanned


wiki
In software engineering, the delegation pattern is an object-oriented
design pattern that allows object composition to achieve the same code reuse as inheritance.

In delegation, an object handles a request by delegating to a second object
(the delegate). The delegate is a helper object, but with the original context. With
language-level support for delegation, this is done implicitly by having self in the
delegate refer to the original (sending) object, not the delegate (receiving object).
 In the delegate pattern, this is instead accomplished by explicitly passing the
 original object to the delegate, as an argument to a method.[1] Note that "delegation"
 is often used loosely to refer to the distinct concept of forwarding, where the sending
  object simply uses the corresponding member on the receiving object, evaluated in the
  context of the receiving object, not the original object.

Note that this article uses "sending object/receiving object" for the two objects, rather
than "receiving object/delegate", emphasizing which objects send and receive the delegation
call, not the original call.

In the Introduction to Gamma et al. 1994, Grady Booch defined delegation as:

Delegation is a way to make composition as powerful for reuse as inheritance [Lie86, JZ91].
 In delegation, two objects are involved in handling a request: a receiving object delegates
 operations to its delegate. This is analogous to subclasses deferring requests to parent classes.
  But with inheritance, an inherited operation can always refer to the receiving object through the
  this member variable in C++ and self in Smalltalk. To achieve the same effect with delegation,
  the receiver passes itself to the delegate to let the delegated operation refer to the receiver.[2]
 */

internal interface iTask {
    fun DisplayComponentName()
}

internal class DeligateComponents(var DeligateComponents: iTask) : iTask {

    override fun DisplayComponentName() {
        DeligateComponents.DisplayComponentName()
    }

}

internal class Window : iTask {
    override fun DisplayComponentName() {
        println("Window  has been delegated  We are at Window ")
    }
}

internal class Door : iTask {
    override fun DisplayComponentName() {
        println(" Door has been delegated We are at Door ")
    }
}

fun main(){
    val Window = Window()
    val Door = Door()
    // This is where delegation is kicking in

    val DeligateComponents = DeligateComponents( Door )
    DeligateComponents.DisplayComponentName()
}

//  Door has been delegated We are at Door