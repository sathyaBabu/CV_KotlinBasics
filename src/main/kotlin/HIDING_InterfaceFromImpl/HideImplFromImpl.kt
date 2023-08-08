///*
//package HIDING_InterfaceFromImpl
//
//class Door
//
//abstract class Mazefactory{
//
//    abstract  fun  MakeDoor() : Door
//}
//
//abstract class SpellDoor : Mazefactory() {
//    override fun MakeDoor(): Door {
//        return  Door()
//    }
//}
//
//
//class SpellDoorImpl : SpellDoor() {
//    override fun MakeDoor(): Door {
//        println("Spell a word!")
//        //return   SpellDoorImpl
//    }// A 'return' expression required in a function with a block body ('{...}')
//
//}
//fun main(){
//
//    val call = SpellDoorImpl()
//    call.MakeDoor()
//
//}*/


