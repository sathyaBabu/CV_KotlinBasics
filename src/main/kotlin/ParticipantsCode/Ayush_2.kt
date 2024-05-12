//package ParticipantsCode
//
//
//
//
//data class User_Class1(val email: String,
//                       val password: String,
//                       var login: login_Class1?)
//
//data class login_Class1(val check_value: String,
//                        var vaild:valid1?)
//
//data class valid1(
//    var should:should?)
//
//class should()
//
//fun Userfun(block: UserBuilder.() -> Unit): User_Class1 = UserBuilder().apply(block).build()
//
//class Usershould()
//{
//    fun build() :should = should()
//}
//
//class UserValidBuilder{
//    var should:should?= null
//
//    fun should(block: Usershould.() -> Unit) {
//        should =  Usershould().apply(block).build()
//    }
//    fun build() :valid1 = valid1(should)
//
//
//
//}
//class UserBuilder1 {
//
//    var email: String = ""
//    var password: String = ""
//    var login: login_Class1? = null
//    fun and_clicked_on_login(block: LoginBuilder1.() -> Unit) {
//        login = LoginBuilder1().apply(block).build()
//    }
//    fun build(): User_Class1 = User_Class1(email, password, login)
//}
//
//class LoginBuilder1 {
//
//    var check_value:String=""
//    var valid:valid1?=null
//
//    fun and_credentials_were_valid(block:  UserValidBuilder.() -> Unit) {
//        valid =  UserValidBuilder().apply(block).build()
//    }
//
//    fun build() :login_Class1 = login_Class1(check_value,valid)
//
//}
//
//
//
//fun main() {
//    val user = Userfun {
//        email= "ayushkumar@gmail.com"
//        password = "ayu123"
//        and_clicked_on_login {
//            println("Do you want to logIn:")
//            when(readln().toLowerCase().also { check_value = it }){
//                "y"-> {
//                    and_credentials_were_valid{ val id:String=email
//                        val pwd:String=password
//                        if (id.length>6 && pwd.length>6)  should { println("inside main function")
//                            println("write your code here!!!! ")
//                        }
//                        else{
//                            Userfun{
//                                println("try to give user info again!!")
//                            }}}}
//                "n"-> {Userfun {
//                    println("please try once again")
//                }}}
//        }}}
//
//
////   println(user)
