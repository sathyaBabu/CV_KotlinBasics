package main_Basics

interface IScrollbar {
    fun operation(screenHeight: Int, list: MutableList<String>)
}

class DataScrollView : IScrollbar {
    override fun operation(screenHeight: Int, list: MutableList<String>) {
        setList(screenHeight, list)
    }

    private fun setList(screenHeight: Int, list: MutableList<String>) {
        var height: Int = screenHeight
        for (index in 0 until height) {
            println(list[index])
            if (index == height - 1) {
                val input = readLine()!!
                println("Please enter scroll direction: $input")
                if (input.toInt() > list.size || input.toInt() < 0) {
                    println("Error! Please enter valid amount.")
                } else {
                    height = input.toInt()
                    setList(height, list)
                }
            }
        }
    }

}

class ManageScrollableOperation(
    val list: MutableList<String>,
) {

    fun impl() {
        val view = DataScrollView()
        view.operation(list.size, list)
    }
}


fun main() {
    val list = mutableListOf(
        "The Single responsibility Principle states that every class should have one and only one responsibility.",
        "In other words, If there is a need to change the class for more than one reason then that defies the single responsibility principle.",
        "The code below has a class named area factory which calculates the area of a shape.",
        "Having a close look at the code we see that we have an if-else statement to separate out the shapes,",
        "and as the shapes increase they will continue to grow that way Because the class is not closed for modification,",
        "and neither it is open for extension.",
        "Hence it is violating our open-closed principle.",
        "The Single responsibility Principle states that every class should have one and only one responsibility.",
        "In other words, If there is a need to change the class for more than one reason then that defies the single responsibility principle.",
        "The code below has a class named area factory which calculates the area of a shape.",
        "Having a close look at the code we see that we have an if-else statement to separate out the shapes,",
        "and as the shapes increase they will continue to grow that way Because the class is not closed for modification,",
        "and neither it is open for extension.",
        "Hence it is violating our open-closed principle.",
        "The Single responsibility Principle states that every class should have one and only one responsibility.",
        "In other words, If there is a need to change the class for more than one reason then that defies the single responsibility principle.",
        "The code below has a class named area factory which calculates the area of a shape.",
        "Having a close look at the code we see that we have an if-else statement to separate out the shapes,",
        "and as the shapes increase they will continue to grow that way Because the class is not closed for modification,",
        "and neither it is open for extension.",
        "Hence it is violating our open-closed principle.",
        "The Single responsibility Principle states that every class should have one and only one responsibility.",
        "In other words, If there is a need to change the class for more than one reason then that defies the single responsibility principle.",
        "The code below has a class named area factory which calculates the area of a shape.",
        "Having a close look at the code we see that we have an if-else statement to separate out the shapes,",
        "and as the shapes increase they will continue to grow that way Because the class is not closed for modification,",
        "and neither it is open for extension.",
        "Hence it is violating our open-closed principle.",
    )

    ManageScrollableOperation(list).impl()
}