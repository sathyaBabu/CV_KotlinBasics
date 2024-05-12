package DesignPatterns
/*
   Fly weight  gaming apps...

   ADD
   Mul


   Factory to store Add, Mul
   query the Obj Pool for Add Mul ( hash table -> Key value pairs )

   user query the obj pool for Add mul. if existing it returns the Add obj else it creates Add and stores
   it in factory




 */

interface  FlyWeight {
    fun compute(a:Int, b:Int)
}

class FlyWeightAdder : FlyWeight {
    var operation: String? = null
    fun FlyWeightAdder() {
        operation = "adding"
    }

    override fun compute(a: Int, b: Int) {
       println("Adding a $a + $b ${a+b}")
    }

}

class FlyWeightMultiplier : FlyWeight {
    var operation: String? = null
    fun FlyWeightMultiplier() {
        operation = "multiplier"
    }

    override fun compute(a: Int, b: Int) {
        println("Multiplier :  a $a + $b ${a*b}")
    }

}
// obj pool
// This is what Shiva was pointing at  private constructor()
class FlyWeightFactory private constructor(){

    private val flyWeightPool : MutableMap<String, FlyWeight>

    init {
        flyWeightPool = HashMap()
    }

    fun getFlyWeight( key: String ) : FlyWeight? {
        return if ( flyWeightPool.containsKey(key)){
            return  flyWeightPool[key]
        }else {
            val flyWeight: FlyWeight
            if( "add".equals(key) ){
                flyWeight = FlyWeightAdder()
                println("Fly weight adder is created...")
            }else {
                flyWeight = FlyWeightMultiplier()
                println("Fly weight Multiplier  is created...")
            }
            flyWeightPool[ key ] = flyWeight ;
            flyWeight
        }
    }

    // fly wi\eight factory  Single Object

    companion object{
        private  var flyWeightfactory : FlyWeightFactory? = null
        val instance:FlyWeightFactory?
        get(){
            if( flyWeightfactory == null){
                flyWeightfactory = FlyWeightFactory()
            }
            return flyWeightfactory
        }


    }

}

// factory



fun main(){

//    val flyWeightAdder = FlyWeightAdder() //  both took : 76  milli Seconds
//    val flyWeightMultiplier =FlyWeightMultiplier()

    val flyWeightFactory: FlyWeightFactory? = FlyWeightFactory.instance

    val startTime = System.currentTimeMillis()

              for( i in 0 .. 4999){
                  val flyWeightAdder = flyWeightFactory?.getFlyWeight("Add")
                  flyWeightAdder!!.compute(i,i)
                  val flyWeightMultiplier = flyWeightFactory?.getFlyWeight("multiply")
                  flyWeightMultiplier!!.compute(i,i)
              }

    val endTime = System.currentTimeMillis()
    println(" That took : ${endTime - startTime}  milli Seconds")

}
//  That took : 73  milli Seconds