/*
   word   1995   NO MOUSE..
              SB->   up dn
              1998   Mouse
              2002   touch pad
              2010   touch screen
 */
data class User_Class1(val email: String,
                       val password: String,
                       var login: login_Class1?)   // hard coupling is one of the wort ways of coding ?
//                      var vaild:valid?)

data class login_Class1(val check_value: String,
                        var vaild:valid1?)
/*
   How a user_Class is related to login class

 */
data class valid1(
    var should:should?)

class should()

fun when_user_entered_credentials(block: UserBuilder.() -> Unit): User_Class1 = UserBuilder().apply(block).build()
fun letsReWorkonUserCredentials( block: UserBuilder.() -> Unit): User_Class1 = UserBuilder().apply(block).build()

class Usershould()
{
    fun build() :should = should()
}

class UserValidBuilder{

    //    var email: String = ""
//    var password: String = ""
    var should:should?= null


    fun should(block: Usershould.() -> Unit) {
        should =  Usershould().apply(block).build()
    }

    //    fun build() :login_Class = login_Class(check_value,valid)
    fun build() :valid1 = valid1(should)



}
class UserBuilder {

    var email: String = ""
    var password: String = ""
    var login: login_Class1? = null
//    var valid:valid?=null// changed


    fun and_clicked_on_login(block: LoginBuilder.() -> Unit) {
        login = LoginBuilder().apply(block).build()
    }

    fun build(): User_Class1 = User_Class1(email, password, login)
}

class LoginBuilder {
    var check_value:String=""
    var valid:valid1?=null

    // Good JOB!!!!!!!
    fun and_credentials_were_valid(block:  UserValidBuilder.() -> Unit) {
        valid =  UserValidBuilder().apply(block).build()
    }

    fun build() :login_Class1 = login_Class1(check_value,valid)

}
/*
enter your user email_id:
sathya@gmail.com
enter your sa password:
sathya123
do you want to logIn:
n
try to give user info again!!

Process finished with exit code 0

 */


fun main() {
    //
    val user = when_user_entered_credentials {
        println("enter your user email_id:")
        email= readln()
        println("enter your sa password:")
        password = readln()
        and_clicked_on_login {
            println("do you want to logIn:")
            check_value=readln().toLowerCase()

            if(check_value == "yes" || check_value =="y")
            {
                and_credentials_were_valid{
                    val id:String=email
                    val pwd:String=password
                    if (id.length>0 && pwd.length>0)
                    {
                            should{
                                println("inside main function")
                                println("write your code here!!!! ")
                        }
                    }
                    else{
                        when_user_entered_credentials{
                            println("try to give user info again!!")
                        }
                    }
                }
            }
            else{
                when_user_entered_credentials{
                    println("try to give user info again!!")
//
//                    letsReWorkonUserCredentials{
//
//                    }

                }
            }
        }

    }
//   println(user)
}