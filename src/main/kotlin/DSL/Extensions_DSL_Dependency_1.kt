
class DependencyHandler {
    fun compile(coordinate: String) {
        println("Added dependency on $coordinate")
    }

//    operator fun invoke(  // Just returning a this pointer to tmain function
//        body: DependencyHandler.() -> Unit) {
//        body()
//    }

    operator fun invoke(  // Just returning a it pointer to tmain function
        body: DependencyHandler.(DependencyHandler) -> Unit) {
        val dh = DependencyHandler()
        dh.body(dh)
    }
}

fun main(args: Array<String>) {
    val dependencies = DependencyHandler()
    dependencies.compile("org.jetbrains.kotlin:kotlin-stdlib:1.0.0")
    //  operator fun invoke(  executes
    dependencies {
        compile("org.jetbrains.kotlin:kotlin-reflect:1.0.0")
    }
}
/*
Added dependency on org.jetbrains.kotlin:kotlin-stdlib:1.0.0
Added dependency on org.jetbrains.kotlin:kotlin-reflect:1.0.0
 */