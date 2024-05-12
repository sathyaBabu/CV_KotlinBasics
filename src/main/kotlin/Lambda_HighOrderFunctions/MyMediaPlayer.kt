package Lambda_HighOrderFunctions

import kotlin.concurrent.thread





fun MediaPlayer( tracks : IntRange,playTime:Int, callBackCDPlayer:( result:Int) -> Unit){
    for( i in 0 until playTime ){
        val played = tracks.random()

      //  println("Competed playiong a song : $played")

        callBackCDPlayer(played)
    }
}

// Phase II

fun MediaPlayer2( tracks : IntRange,playTime:Int, callBackCDPlayer:( result:Int) -> Unit){

        callBackCDPlayer.invoke((1..6).random())

    }

// Phas III functional composition

fun funComposition( CallBack:( result:Int ) -> Unit) : String{


            Thread.sleep(5000)
      //  println(" 101 ")
        CallBack(101)   // 101



    return  " Job completed by Demon process.."
}



fun main(){

    MediaPlayer( 1..6, 5, { playStatus -> println( "Completed Track : $playStatus" )  }     )
    MediaPlayer( 1..6, 5   )  { playStatus -> println( "Completed Track out.. : $playStatus" )  }

    MediaPlayer2( 1..6, 5, {   println( "Completed Track : $it" )  }     )

    val jobStatus = funComposition {
        println(it)   // 101
    }
    println(jobStatus)   //

}
/*
Completed Track : 2
Completed Track : 6
Completed Track : 2
Completed Track : 2
Completed Track : 4
Completed Track out.. : 1
Completed Track out.. : 4
Completed Track out.. : 1
Completed Track out.. : 2
Completed Track out.. : 1
Completed Track : 6
101
 Job completed by Demon process..

 */