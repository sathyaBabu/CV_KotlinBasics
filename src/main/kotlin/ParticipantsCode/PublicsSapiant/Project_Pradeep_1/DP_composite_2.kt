package Design_Pattern
//Idea is to create a meal plan
//which consists of burger,wings,coke
//composition node happens to be burger wings and coke
//Leaf happens Ingredients of the burger
interface Component{
    fun display_Node_Leaf()
    fun getIngredients():MutableList<Ingredients>
}
//This has to be something generic i'm not getting it
//class Leaf(var ingredients: Ingredients) : Component {
//    override fun display_Node_Leaf() {
//        println(" ${ingredients.cal()} -->>> ${ingredients.cost()} ")
//    }
//
//}
//
//}
//vistor will visit the Composite node(eg burger)
//gets the interator of the burger iterates throught the ingredients by calculating the cost of the burger
// this can create a node as well as a leaf..
class Composite : Component {
//initialize the iterator but where ?
    // components can take a Leaf or a Node in a uniform way..
     var components = ArrayList<Component>()
    var node = 0
    // watch on this  -> Debug this and get the hang of it..
      override fun display_Node_Leaf() {
        for( component in components){ //iterates through the nodes burger,wings,
            println("Node : ${node++}")
            //  Leaf.display_Node_Leaf() displays all the ingredients
            component  // display leaf name

            component.display_Node_Leaf()
            if( getComponents().size > 0 )  print(" \t")
        }
    }

//    override fun createIterator(): Iterator2 {
////        var itr=components[0].createIterator()
//        return when(components[0]){
//            Burger::class->IngredientInterator(this)
//            else -> {}
//        }
//
//    }

    override fun getIngredients(): MutableList<Ingredients> {
        return components[0].getIngredients()
    }
//how can burger be added in Component if burger is not implementing Component ??

    fun add( component: Component){
        components.add( component)
    }
    fun remove( component: Component){
        components.remove(component)
    }


    fun getComponents() : List< Component >{
        return  components
    }

    fun getComponent(index:Int) : Component{
        return components[ index ]
    }


}

fun main(){
    var burger=IngredientsFactory
    var chicken=burger.createIngredients("chicken",1,10,40)
    var cheese=burger.createIngredients("tomato",1,10,40)
    var lettuce=burger.createIngredients("cheese",1,30,35)
    var bun=burger.createIngredients("bun",1,15,20)
    var burgerbuilder=Burger.BurgerBuilder()
    val Burger=burgerbuilder
        .addIngredients(cheese!!)
        .addIngredients(chicken!!)
        .addIngredients(bun!!)
        .addIngredients(lettuce!!)
        .buildBurger()

    var chicken1= burger.createIngredients("chicken",1,10,40)
    var cheese1= burger.createIngredients("tomato",1,6,30)
    var lettuce1= burger.createIngredients("cheese",1,14,45)
    var Wing=Wings.WingsBuilder()
        .addIngredients(cheese1!!)
        .addIngredients(chicken1!!)
        .addIngredients(lettuce1!!)
        .buildWing()
    Wing.getTotalCost()
    Wing.getAllIngredients()
    var composite=Composite()
    composite.add(Burger)
    composite.add(Wing)
    composite.getComponents()
//
}