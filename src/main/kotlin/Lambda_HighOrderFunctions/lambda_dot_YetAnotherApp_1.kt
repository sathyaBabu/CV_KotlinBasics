package Lambda_HighOrderFunctions

class A{
    fun body() = println("We are at A's class Body")
    val someValue1 = 100
    val someValue2 = 200
}

class AHandler {
    fun handle(a: A) {
        println("AHandler Body  ${a.body()} and a Value ${a.someValue1}")
    }
}

class _Add {
    fun add(a: A) {
        println( "Adding Now  ${a.body()} and the Sum  ${a.someValue1 + a.someValue2}")
    }
}

fun useLambdaWithReceiver(lambda: A.()->Unit) {
    val a = A()
    lambda(a)
}

fun useNormalLambda(lambda: (A)->Unit) {
    useLambdaWithReceiver(lambda)
}
// Function invocation 'body()' expected
fun main() {
    val handler = AHandler()
    val add = _Add()
    useLambdaWithReceiver {
        println("useLambdaWithReceiver ${this.body()}")
    }
    useNormalLambda {
        println("useNormalLambda ${it.someValue1}")
    }

    useLambdaWithReceiver(handler::handle)
    useNormalLambda(handler::handle)


    useLambdaWithReceiver(add::add)
}