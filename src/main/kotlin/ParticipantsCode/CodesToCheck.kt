package ParticipantsCode
import java.lang.IllegalArgumentException
import java.util.*
fun main()
{
   Anannya()
    //Sruthi()
   // Sandeep()
}

fun Sandeep() {

}

fun Sruthi() {





        val person = when_user_entered_credentials {
            email = "sandeep@gmail.com"
            password = "cool@123"
            and_clicked_on_login {
                check_value = 'y'
                and_credentials_were_valid{
                    password = "sruti@1345"
                    {

                    }
                }
            }
        }


}

fun Anannya() {





        val Credentials = Credentials {
            name = "Anannya"
            pw   = "An@1234"
            if(this.name!!.length > 6  &&  this.pw!!.length > 6){
                println("Valid Credentials")
                login {
                    click = "yes"
                    if(this.click == "yes"){
                        this.activity()
                    }
                    else{
                        println("Click on login!")
                    }
                }
            }else{
                println("Invalid")
            }

        }

    }
//////

data class Credentials(
    var name: String? = null,
    var pw: String? = null,
    var login: Login? = null)


data class Login(
    var click: String? = null){
    fun activity(){
        println("Logged in!")
    }
}


fun Credentials(block: Credentials.() -> Unit): Credentials = Credentials().apply(block)
infix fun Credentials.login(block: Login.() -> Unit) {
    val login = Login().apply(block)
}


//////////////  sruthi - Sandeep




data class User_Class(val email: String,
                      val password: String,
                      var login: login_Class?) // changed

data class login_Class(val check_value: Char,
                       var valid : validity_Class? )

data class validity_Class(var password: String,
                          val valid : Boolean)
fun when_user_entered_credentials(block: UserBuilder.() -> Unit): User_Class = UserBuilder().apply(block).build()

class UserBuilder {

    var email: String = ""

    var password: String = ""

    var login: login_Class? = null  // changed


    fun and_clicked_on_login(block: LoginBuilder.() -> Unit) {
        login = LoginBuilder().apply(block).build()
    }
    fun build(): User_Class = User_Class(email, password, login)

}
// Sruti Panigrahi to Everyone (9:17 AM)
class LoginBuilder {

    var check_value: Char ='y'
        set(value){
            field = if( value == 'y')  value else throw IllegalArgumentException("You need to login to access..")
        }

    var valid: validity_Class? = null

    fun build():login_Class=login_Class(check_value,valid)

    fun and_credentials_were_valid(block: ValidityBuilder.() -> Unit) {
        valid = ValidityBuilder().apply(block).build()
    }
}

class ValidityBuilder {

    var password: String = ""
        set( value ) {
            field = if( value.length > 6 )  value else throw IllegalArgumentException("Pass word is toooo small.")

        }

    var valid : Boolean = true
    fun build() :validity_Class = validity_Class(password,valid = true)
    fun should(function: () -> String) {

    }
}
///////////     sandeep



/////////////////////////




