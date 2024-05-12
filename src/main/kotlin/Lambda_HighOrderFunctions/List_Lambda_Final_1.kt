package Lambda_HighOrderFunctions



class List(_a:Int,_b:Int){
    var a:Int
    var b:Int
    var result=0;


    //initalization
    init{
        a=_a
        b=_b
    }

    fun calculate(operation : List.(Int,Int) -> Int) : List {//operation lambda function to perform operation on two number
        result=this.operation(a,b)
        // Phase III store result in a mutableListOf array and send it to display let it iterate the data and display the same

        return  this
    }

//    fun display():Unit{//function to display last result
//
//        println("The final result is $result ")
//    }
//
    fun display(function: (Int) -> Unit){
               function( result)
    }

    // For phase II
    /*
    fun display(function: (Int) -> Unit): List {
        function( result)
        return this
    }*/


}


fun Summ(x:Int,y:Int)= x + y
fun Prod(x:Int,y:Int)= x * y
fun Div(x:Int,y:Int)= x /  y


fun main(){

    List(30,10)
        .calculate{ it1,it2-> it1+it2 }  // 40
        .calculate{ it1,it2-> result*it2 } // 40 * 10 = 400
        .calculate{ it1,it2-> result/it2 }  // 400/10 = 40
//        .calculate{ it1,it2 ->  ::Summ }
//        .calculate{ it1,it2-> ::Prod }
//        .calculate{ it1,it2-> result/it2 }
        .display {
            println("The final result is $it ")  // The final result is 40
        }

    // Phase II - Errors
/*

    List(30,10)
        .calculate{ it1,it2-> it1+it2 }
        .display {
            println("The Sum is $it ")
        }
        .calculate{ it1,it2-> result*it2 }
        .display {
            println("The product is $it ")
        }
        .calculate{ it1,it2-> result/it2 }
//        .calculate{ it1,it2 ->  ::Summ }
//        .calculate{ it1,it2-> ::Prod }
//        .calculate{ it1,it2-> result/it2 }
        .display {
            println("The Div  is $it ")
        }*/
}