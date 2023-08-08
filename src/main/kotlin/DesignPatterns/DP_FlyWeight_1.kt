package DesignPatterns


interface FlyWeight{
    fun compute( a : Int, b : Int )
}

class  Adder : FlyWeight {

    var operation: String? = null

    fun Adder() {
        operation = "Adding.."
    }

    override fun compute(a: Int, b: Int) {
        println("Adding a $a + $b ${a+b}")
    }

}

class  Multiplier : FlyWeight {

    var operation: String? = null

    fun Adder() {
        operation = "Multiplier.."
    }

    override fun compute(a: Int, b: Int) {
        println("Adding a $a + $b ${a*b}")
    }

}


class FlyWeightFactory private constructor() {

  private  val flyWeightPool : MutableMap<String,FlyWeight>

  init {
      flyWeightPool = HashMap()
  }


    fun getFlyWeight(key: String) : FlyWeight?{
        return if ( flyWeightPool.containsKey(key)) {
            return  flyWeightPool[ key ]
        } else {
            val flyWeight: FlyWeight
            // threshold  create 10 Burgers..
            if ("Add".equals(key)){
                flyWeight = Adder()
                println(" Add is called in FlyWeight...")
            }else {
                flyWeight = Multiplier()
                println(" Mull is called in FlyWeight...")
            }

            flyWeightPool[ key ] = flyWeight ;
            flyWeight
        }
    }

            /////// SingleTon..

                companion object {
                private var flyWeightFactory: FlyWeightFactory? = null

                val instance: FlyWeightFactory?

                    get() {
                        if (flyWeightFactory == null) {
                            flyWeightFactory = FlyWeightFactory()
                        }
                        return flyWeightFactory
                    }
            }

}
//
//open class stack{
//
//
//   // intArray( 10 )  // 11 Array out of bound
//
//    fun push( x: Int)
//    fun pop()
//
//}
//class BugFix : stack(){
//
//    if( x > 10) : stop
//       elkse push( i )
//
//}
// How will you post the sasme on to composition???

// add mutableList...
//  asasdas
//   asdasd


fun main(){
//
//    var stk = BugFix()
//    stk.push(1);

    val flyWeightFactory: FlyWeightFactory? = FlyWeightFactory.instance

    val startTime = System.currentTimeMillis()

    for( i in 0 .. 5000){
        val adder =  flyWeightFactory?.getFlyWeight("Add")
        adder!!.compute( i,i)
        val multiplier =  flyWeightFactory?.getFlyWeight("multiply")
               multiplier!!.compute( i,i)
    }

    val endTime = System.currentTimeMillis()
    println(" Took : ${endTime-startTime}  ms. ")

}