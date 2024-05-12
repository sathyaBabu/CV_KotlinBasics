package List_Impl_1

val systemUsers : MutableList<Int> = mutableListOf(1,2,3)  // we added 4

//   proxy..
val sudoUSers : List<Int> = systemUsers

fun addSystemUser( newUser:Int ){
    systemUsers.add(newUser)
}

fun getSysSudoUsers() : List<Int> {

    return  sudoUSers ;   // let's treat this as proxy..

}

fun main(){

    addSystemUser(4)
    println("Total number of users : ${getSysSudoUsers().size}")
    getSysSudoUsers().forEach{
        systemUsers -> println("Some info about the users   $systemUsers")
    }


}