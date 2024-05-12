package DesignPatterns

class FoodOrder private constructor(
    val bread:      String?,
    val condiments: String?,
    val meat:       String?,
    val fish:       String? ) {

    data class Builder(
        var bread: String?      = null,
        var condiments: String? = null,
        var meat: String?       = null,
        var fish: String?       = null) {

        fun bread(bread: String) = apply { this.bread = bread ; println("${this.bread}") }
        fun condiments(condiments: String) = apply { this.condiments = condiments  ; println("${this.condiments}")}
        fun meat(meat: String) = apply { this.meat = meat  ; println("${this.meat}")}
        fun fish(fish: String) = apply { this.fish = fish ; println("${this.fish}") }
        fun build() = FoodOrder(bread, condiments, meat, fish)
    }
}

fun main(){

    val foodOrder = FoodOrder.Builder()
        .bread("white bread")
        .meat("bacon")
        .condiments("olive oil")
        .fish ("Tuna")
        .build()
}