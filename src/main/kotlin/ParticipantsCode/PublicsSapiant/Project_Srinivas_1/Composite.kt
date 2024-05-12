package task.Day6.burgermain






/*
 Assignment I
   Create Burger  Nugget Wings Rice
   create a meal plan..
   display the output
   Assignment II
   bring in DSL here..
   NOTE : Its a dummy code for your understanding....
        prepareMeal = mealMaker.addToMeal( Burger())
                 .add ( Nugget() )
                 .add ( Wings() )
                 .build();
                 mealMaker.comand( prepareMeal() )
                 mealMaker.( compose() )
        storeMeal.flyweightPool( mealMaker() )
        bill(factory.query( burger ) , PayByCard() )
       //   DSL Kotlin
        Burger {    { Bun      1  Calories  21  Cost  20  } ,
                    { Lettuce  1  Calories  0   Cost  10  } ,
                    { Chicken  1  Calories  210 Cost  80  } ,
                    { Cheese   1  Calories  60  Cost  15  } ,
                    { Cucumber 1  Calories  10  Cost  05  } ,
                    { Tomato   1  Calories  01  Cost  02  }   }.apply(::buildBurger)
                    //  Build Nugget, Wings, Rice .......
   mealPlanOne      {   { Burger , Nugget , Wings   }  }.apply(::makeMeal )
   mealPlanTwo      {   { Burger , Coke             }  }.apply(::makeMeal2)
   mealPlanThree    {   { Wings , Rice , Coke       }  }.apply(::makeMeal3 )
   userRequest      {   { MealPlanTwo   }              }.apply(::getCost)
   billMeal         {   { MealPlanTwo , PayByCard }    }.apply(::generateBill)
 */
interface ComponentMeal{
    fun display_Node_Leaf():MutableList<Ingredients>
    fun close()
}





// this can create a node as well as a leaf..
class CompositeMeal() : ComponentMeal {

    // ComponentMeals can take a Leaf or a Node in a uniform way..
    private  var ComponentMeals : MutableList< ComponentMeal > = ArrayList()
    var node = 0
    // watch on this  -> Debug this and get the hang of it..
    override fun display_Node_Leaf() : MutableList<Ingredients>{

        var mutableList= mutableListOf<Ingredients>()
        for( ComponentMeal in ComponentMeals){


            ComponentMeal.display_Node_Leaf()

                for(displaymeal in ComponentMeal.display_Node_Leaf())
                {
                    mutableList.add(displaymeal)
                }

            //  Leaf.display_Node_Leaf()
            ComponentMeal.display_Node_Leaf()  // display leaf name
            if( getComponentMeals().size > 0 )  print(" \t")
        }
        return mutableList
    }

    override fun close() {
        for( ComponentMeal in ComponentMeals){
            ComponentMeal.close()
        }
    }

    fun add( ComponentMeal: ComponentMeal){
        ComponentMeals.add( ComponentMeal)
    }

    fun getComponentMeals() : List< ComponentMeal >{
        return  ComponentMeals
    }



}




