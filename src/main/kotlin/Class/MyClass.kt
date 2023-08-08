package Class
/*
     Class...
     init
     constructors  PRi, sec...
     deriving order

     Usecase...
     interface ? When and wheer it can be used...

     Abstraction ?
     Data  class   -> POJO  Model..  get set
     data copy ->  proxy ( we should not return this -> a var )
     get() set() - value field

     Companion Object - > static.. SingleTon

     Sealed classes


     Lambdas... infix  Higer order functions functional compositions...
     DSL   - gradle  ->  Expressive way of coding..


 */


class LibMember(val _name : String, val _age : Int = 20 ){

    var name : String
    var age :Int

    // Initializer block
    init {

         this.name = _name ;
         this.age = _age ;
    }
    fun DisplayData() {
        println(" Name $name Age $age")
    }

}






fun main(){
    println("HI")
    val user1 = LibMember("aameer")
    val user2 = LibMember("mayank",19)
    user1.DisplayData()
    user2.DisplayData();
}