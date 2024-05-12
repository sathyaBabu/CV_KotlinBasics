import kotlin.properties.Delegates

class ResourceLoader {
    fun loadResource(): String {
        println("Loading resource...")
        return "Resource content"
    }
}

class Example(private val loader: ResourceLoader) {
    val resource: String by lazy { loader.loadResource() }
}

fun main() {
    val loader = ResourceLoader()
    val example = Example(loader)

    // The resource is not loaded yet
    println("Resource is not loaded yet")

    // Accessing the resource triggers lazy initialization
    println("Accessing the resource: ${example.resource}")  // loading ResourceLoader  at this point

    // Since lazy initialization has been triggered, the resource is now loaded
    println("Resource is now loaded")
}
/*
Resource is not loaded yet
Loading resource...
Accessing the resource: Resource content
Resource is now loaded
 */