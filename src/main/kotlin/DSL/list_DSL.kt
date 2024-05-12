/*
The FruitsDSL class is the central class that defines the DSL
 (Domain-Specific Language) for manipulating a list of fruits. It takes a List<String>
  as input, which represents the list of fruits to be processed.

  The FruitsDSL class contains three functions that define the DSL operations:

filter: This function takes a predicate as an argument and filters the original list of fruits
 based on the predicate. The filtered fruits are stored in the filteredFruits list.
sortedBy: This function takes a selector as an argument and sorts the filtered fruits based
 on the provided selector. The in variance modifier allows the selector to accept a supertype
 of String.
map: This function takes a transform function as an argument and applies the transformation
 to each element of the filtered fruits, replacing them with the transformed values.
The filteredFruits list is used to store the intermediate results of the filtering and
 sorting operations before applying the final transformation.

 The FruitsDSLBuilder class is responsible for building and executing the DSL operations
  defined in the FruitsDSL class. It takes a block as an argument, which represents a
  lambda that contains the DSL operations. Inside the build function, a new FruitsDSL
   instance is created with the original list of fruits. The lambda block is then applied
   to this instance, which allows chaining and executing the DSL operations.

   In the main function, a list of fruits is defined. Then, the FruitsDSLBuilder is used
    to build the DSL using a lambda block. Inside the lambda block, we chain the DSL operations:
     first, we filter the fruits that start with "A" or "a" (ignoring case), then we sort the
     filtered fruits in alphabetical order, and finally, we transform each fruit to uppercase.

When the execute function is called, the filtered, sorted, and transformed fruits are printed
 to the console.

The final output of the program will be:



Main function:

Define the FruitsDSLBuilder class:

Define the FruitsDSL functions:

 */


class FruitsDSL(private val fruits: List<String>) {

    private val filteredFruits = mutableListOf<String>()

    fun filter(predicate: (String) -> Boolean) {
        filteredFruits.addAll(fruits.filter(predicate))
    }

//    fun sortedBy(selector: (String) -> Comparable<in String>?) {
//        filteredFruits.sortBy(selector)
//    }

    fun map(transform: (String) -> String) {
        filteredFruits.replaceAll(transform)
    }

    fun execute() {
        filteredFruits.forEach { println(it) }
    }
}

class FruitsDSLBuilder(private val fruits: List<String>) {
    fun build(block: FruitsDSL.() -> Unit) {
        val fruitsDSL = FruitsDSL(fruits)
        fruitsDSL.block()
          fruitsDSL.execute()
    }
}

fun main() {
    val fruits = listOf("Banana", "Grape", "Avocado", "Apple", "Kiwi fruit")

    FruitsDSLBuilder( fruits ).build {
        filter { it.startsWith("A", ignoreCase = true) }
      //  sortedBy { it }
        map { it.uppercase() }
    }
}
/*

AVOCADO
APPLE
 */