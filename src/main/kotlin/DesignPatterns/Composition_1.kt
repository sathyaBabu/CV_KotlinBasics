package DesignPatterns


/*

install java 1.8 > 11 +  oracle for MAC  : https://www.oracle.com/java/technologies/downloads/#jdk17-mac
https://developer.android.com/studio
// installation of SDK

// Lolipup onwards



// down load m1 emulator
// https://github.com/google/android-emulator-m1-preview/releases/tag/0.2
// > Build, Execution, Deployment > Build Tools > Gradle > Gradle JDK

keeping the Blue tooth on android studio
// Error due to thread.. Should be in a service
https://stackoverflow.com/questions/49729452/how-to-keep-bluetooth-connection-background


 */


interface  Component{

    fun DisplayNodeLeaf()
    fun close()

}


class  Leaf( var name:String) : Component{
    override fun DisplayNodeLeaf() {
        println(" Leaf $name")
    }

    override fun close() {
        println(" $name Destruction")
    }

}

class Composite : Component {

    private  var components : MutableList< Component > = ArrayList()
    var node = 0 ;
    override fun DisplayNodeLeaf() {

        for( component in components){

            print("Node : ${node++}")
            component.DisplayNodeLeaf()  // composite  Leaf..
            if( getComponents().size > 0 ) print("--> \t")
        }
    }

    override fun close() {
        for( component in components){
            component.close()
        }
    }

    // Leaf or Component
    fun add( component: Component){
        components.add(component)
    }
    fun remove(component: Component){
        components.remove(component)
    }

    fun getComponents() : List<Component>{
        return components
    }

    fun getComponent(index:Int): Component{
        return  components[ index ]
    }


}

fun main(){

    val leaf1 = Leaf("File")    // 11c  // composition -> or by factory
    val leaf2 = Leaf("New")     // 11a
    val leaf3 = Leaf("Edit")     // 21c
    val leaf4 = Leaf("Copy")    // 21a
    val leaf5 = Leaf("Sourse")   // 51c


    // Composite creation under the various composites as well as the nodes can be a meal plan..
    val composite1 = Composite()   // node  100 -> 11c / ->11a
    composite1.add( leaf1 )         // 100 -> 11c
    composite1.add( leaf2 )         // 100 -> 11a

    val composite2 = Composite()  // 200
    composite2.add( leaf3 )        // 200 -> 21c
    composite2.add( leaf4 )         // 200 -> 21a

    val composite3 = Composite()   // 300
    composite3.add( composite1 )     // 300 -> 100 -> 11c : 11a
    composite3.add( composite2 )     // 300 -> 200 -> 21c 21a


    composite3.add(leaf5)    // 300 -> 51c

    val mealPlan = Composite() // 300 -> 100

    /*

         300
           --------> 51c
           100
             ------> 11c
             ------> 11a
           200
              -----> 21c
              -----> 21a

     */

    mealPlan.add(composite3)
    mealPlan.add(leaf5)

    println("Display Leaf")
    leaf1.DisplayNodeLeaf()   //

    println("Display the leaf on Node 1 on composite")
    composite1.DisplayNodeLeaf()

    println("Display the leaf on Node 2 on composite")
    composite2.DisplayNodeLeaf()

    println("Display the leaf on Node 3 on composite")
    composite3.add( composite1)
    composite3.add(composite2)


    composite3.DisplayNodeLeaf()


    mealPlan.DisplayNodeLeaf()


    val component2 = composite3.getComponent( 1 )

    println("Number of exixting child ${composite2.getComponents().size}")


    component2.DisplayNodeLeaf()

    // close all the nodes on composite 3


    composite3.close()


}
/*
Display Leaf
 Leaf File
Display the leaf on Node 1 on composite
Node : 0 Leaf File
	Node : 1 Leaf New
	Display the leaf on Node 2 on composite
Node : 0 Leaf Edit
	Node : 1 Leaf Copy
	Display the leaf on Node 3 on composite
Node : 0Node : 2 Leaf File
	Node : 3 Leaf New
		Node : 1Node : 2 Leaf Edit
	Node : 3 Leaf Copy
		Node : 2 Leaf Sourse
	Node : 3Node : 4 Leaf File
	Node : 5 Leaf New
		Node : 4Node : 4 Leaf Edit
	Node : 5 Leaf Copy
		Node : 0Node : 5Node : 6 Leaf File
	Node : 7 Leaf New
		Node : 6Node : 6 Leaf Edit
	Node : 7 Leaf Copy
		Node : 7 Leaf Sourse
	Node : 8Node : 8 Leaf File
	Node : 9 Leaf New
		Node : 9Node : 8 Leaf Edit
	Node : 9 Leaf Copy
			Node : 1 Leaf Sourse
	Number of exixting child 2
Node : 10 Leaf Edit
	Node : 11 Leaf Copy
	 File Destruction
 New Destruction
 Edit Destruction
 Copy Destruction
 Sourse Destruction
 File Destruction
 New Destruction
 Edit Destruction
 Copy Destruction

Process finished with exit code 0

 */