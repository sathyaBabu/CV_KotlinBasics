data class User_Class(val email: String,
                      val password: String,
                      var login: login_Class?)

data class login_Class(val check_value: String)

fun Userfun(block: UserBuilder2.() -> Unit): User_Class =
                                             UserBuilder2().apply(block).build()

class UserBuilder2 {

    var email: String = ""

    var password: String = ""

    var login: login_Class? = null  // changed


    fun login(block: LoginBuilder2.() -> Unit) {
        login = LoginBuilder2().apply(block).build()
    }
    fun build(): User_Class = User_Class(email, password, login)

}

class LoginBuilder2 {

    var check_value:String=""

    fun build() :login_Class = login_Class(check_value )

}

fun main() {

    val person = Userfun {
        email = "suraj@gmail.com"
        password = "suraj@123"
        login {
            check_value = "yes"
        }
    }
    println( person )

    println( person.email )
    println( person.password )
    println(person.login?.check_value)
}