


open class DependencyHandler1 {

    fun compile(coordinate: String) {
        println("Added dependency on $coordinate")
    }

    operator fun invoke(body: DependencyHandler1.() -> Unit) {
        println("invoke called ")
        body()
    }
}

fun main(args: Array<String>) {


    val dependencies = DependencyHandler1()  // Invoke is fired...

    dependencies.compile("org.jetbrains.kotlin:kotlin-stdlib:1.0.0")
    // now we are calling lambda


    dependencies {

        compile("org.jetbrains.kotlin:kotlin-reflect:1.0.0")


    }
}
/*
// I created this at build.gradle.kts
tasks{
    compileKotlin{
        var allWarningsAsErrors = true
    }
}*/
