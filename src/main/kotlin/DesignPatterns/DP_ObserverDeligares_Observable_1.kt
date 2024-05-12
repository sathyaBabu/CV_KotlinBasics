package DesignPatterns
// https://medium.com/@ahmedrizwan/kotlin-design-patterns-the-observer-fc8e5a702b4c
// https://github.com/dbacinski/Design-Patterns-In-Kotlin

import com.sun.jdi.Value
import kotlin.properties.Delegates
//
//interface ValueChangeListener {
//    fun onValueChanged( newStringValue : String )
//}
//class TextChangedListener : ValueChangeListener {
//    override fun onValueChanged(newStringValue: String) =
//        println("Text changed to : $newStringValue")
//
//
//}
//class ObservableObject(listener : ValueChangeListener) {
//    var text : String By Delegates.observable(
//            initialValue = "",
//            onChange  = {
//                prop,old,new ->
//        listener.onValueChanged( new )
//
//            })
//
//}
//
//fun main(){
//
//    val observableObject = ObservableObject( TextChangedListener())
//    observableObject.text = "Hello"
//    observableObject.text = "there.."
//
//}
