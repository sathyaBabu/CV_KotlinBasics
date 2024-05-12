package DesignPatterns
object SharedRegistry {
    fun register(key: String, thing: String) {}
}
fun main() {
    SharedRegistry.register("a", "apple")
    SharedRegistry.register("b", "boy")
    SharedRegistry.register("c", "cat")
    SharedRegistry.register("d", "dog")
}