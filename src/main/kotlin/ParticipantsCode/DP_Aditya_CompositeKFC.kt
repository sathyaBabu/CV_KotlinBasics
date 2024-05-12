package ParticipantsCode


// works good

interface  KFC{

    fun DisplayNodeLeaf()
    fun close()

}


class  Leaf( var name:String) : KFC{

    override fun DisplayNodeLeaf() {
        println(" Order $name")
    }

    override fun close() {
        println(" $name Ordered")
    }

}

class Composite1 : KFC {

    private  var components : MutableList<KFC> = ArrayList()
    var node = 0 ;
    override fun DisplayNodeLeaf() {

        for( component in components){

            print("Node : ${node++}")
            component.DisplayNodeLeaf()  // composite  Leaf..
            if( getComponents().size > 0 ) print("\t")
        }
    }

    override fun close() {
        for( component in components){
            component.close()
        }
    }

    // Leaf or Component
    fun add( component: KFC){
        components.add(component)
    }
    fun remove(component: KFC){
        components.remove(component)
    }

    fun getComponents() : MutableList<KFC> {
        return components
    }

    fun getComponent(index:Int): KFC{
        return  components[ index ]
    }


}

fun main(){

    val leaf1 = Leaf("Burger")    // 11c
    val leaf2 = Leaf("Pizza")     // 11a
    val leaf3= Leaf("French_Fries")     // 21c
    val leaf4 = Leaf("Cold_Drink")    // 21a
    val leaf5 = Leaf("Chicken_Lollipop")   // 51c

    val composite1 = Composite1()   // node  100 -> 11c / ->11a
    composite1.add(leaf1)         // 100 -> 11c
    composite1.add(leaf2)         // 100 -> 11a

    val composite2 = Composite1()  // 200
    composite2.add( leaf3)        // 200 -> 21c
    composite2.add(leaf4)         // 200 -> 21a

    val composite3 = Composite1()   // 300
    composite3.add(leaf1)     // 300 -> 100 -> 11c : 11a
    composite3.add(leaf2)     // 300 -> 200 -> 21c 21a
    composite3.add(leaf4)
    composite3.add(leaf5)    // 300 -> 51c

    val mealPlan1 = Composite1()
    mealPlan1.add(composite1)

    val mealPlan2 = Composite1()
    mealPlan2.add(composite2)

    val mealPlan3 = Composite1()
    mealPlan3.add(composite3)

//    println("Display Leaf")
//    leaf1.DisplayNodeLeaf()   //

    println("Display the order on Node 1 on composite")
    composite1.DisplayNodeLeaf()

    println("Display the order on Node 2 on composite")
    composite2.DisplayNodeLeaf()

    println("Display the order on Node 3 on composite")
    composite3.DisplayNodeLeaf()

//    println("Display the leaf on Node 3 on composite")
//    composite3.add( composite1)
//    composite3.add(composite2)


    //composite3.DisplayNodeLeaf()

    println("-*-".repeat(40))
    mealPlan1.DisplayNodeLeaf()
    println("-*-".repeat(40))
    mealPlan2.DisplayNodeLeaf()
    println("-*-".repeat(40))
    mealPlan3.DisplayNodeLeaf()
    println("-*-".repeat(40))

    //val component2 = composite3.getComponent( 1 )

    //println("Number of existing child ${composite2.getComponents().size}")


    //component2.DisplayNodeLeaf()

    // close all the nodes on composite 3
    println("-*-".repeat(40))
    println("Display the order on Meal Plan 1 : ")
    composite1.close()
    println("-*-".repeat(40))
    println("Display the order on Meal Plan 2 : ")
    composite2.close()
    println("-*-".repeat(40))
    println("Display the order on Meal Plan 3 : ")
    composite3.close()


}

