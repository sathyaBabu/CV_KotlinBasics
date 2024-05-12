package DesignPatterns

import kotlin.concurrent.thread


/*

        Media Player
            Mp3

            Adapter..

                Mp4 ????
                VLC ????

      CD Player
           Cd
           VCD - Buy a Box Convertor( Adapter ) -> cd player
           MP3 Mp4 AVI ( Adapter ) intrepret the new format to our player..

     House Builder...
         Interior guy( Adapter ) drape, carpet, closet..


 */
// Phase I
// Play Pause Start stop rev ff
// Player can Cd Played DVD VCD Record Player Casset Player Spool tape player..

interface MediaPlayer22{

    fun play(audioType : String? , fileName : String?)
}

// Phase II

// we are breaking SOLID principle I Interface segrigation


// Adaptee....   Driver Maid Servent / cook

open class AVI11: MediaPlayer22{

    override fun play(audioType : String? , fileName : String?) {
        println(" Playing AVI format File name : $fileName")
    }
}
open class Mp4Player22: MediaPlayer22{

    override fun play(audioType : String? , fileName : String?) {
        println(" Playing $audioType format File name : $fileName")
    }

}

open  class VlcPlayer22 : MediaPlayer22{

    override fun play(audioType : String? , fileName : String?) {
        println(" Playing $audioType format File name : $fileName")
    }

}



// Phase II
// This adapter in turn can get connected to Adaptee...
class MediaAdapter2( audioType: String) : MediaPlayer2{

    //    var advancedMediaPlayer: AdvancedMediaPlayer? = null ;
    var play:MediaPlayer2?=null

    init {
        // init the adaptee...  THINK?? am"i Right doing so?????? did I break any basic.. principle
        if( audioType.equals("Vlc", ignoreCase = true)){
            play = VlcPlayer2()   // adaptee
        }
        if( audioType.equals("Mp4", ignoreCase = true)){
            play= Mp4Player2() //  // adaptee
        }

    }

    // Let me initiate this block latter!!!!!!!

    override fun play(audioType: String?, fileName: String?) {

        if( audioType.equals("Vlc", ignoreCase = true)){
            play !!.play(audioType,fileName)
        }
        if( audioType.equals("Mp4", ignoreCase = true)){
            play!!.play(audioType,fileName)
        }


    }

}

//////////
// Phase I  Base Class : AudioPlayer

class AudioPlayer2 : MediaPlayer22 {

    // Phase II
    // We have to play other formats too

    // We are breaking the O principle.. by modifying the class...

    var mediaAdapter2: MediaAdapter2? = null ;


    override fun play(audioType: String?, fileName: String?) {
        if( audioType.equals("Mp3", ignoreCase =  true)){
            println(" Playing $audioType Now $fileName")
        }else if ( audioType.equals("Vlc", ignoreCase = true) ||
            audioType.equals("Mp4", ignoreCase =  true) )
        {

            // Constructed the MediaAdapter object..
            mediaAdapter2 = audioType?.let { MediaAdapter2(it) }

            // add the play line latter..


            mediaAdapter2!!.play(audioType, fileName)  // Vlc or Mp4



        } else {
            println("  $audioType : Unknown format : cant play $fileName SONG!!")
        }

    }


}

fun main(){

    var audipPlayer2 = AudioPlayer2()
    audipPlayer2.play("Mp3","Tamasha")  // P
    audipPlayer2.play("Mp4","Dil se rey. ") // p
    audipPlayer2.play("Vlc","Thue heeee")  // P
    audipPlayer2.play("Avi","Thum hooo") //  Avi : Unknown format : cant play Thum hooo SONG!!
    audipPlayer2.play("Mp3","Titanic")   // P



}
/*
 Playing Mp3 Now Tamasha
 Playing MP4 format File name : Dil se rey.
 Playing VLC format File name : Thue heeee
  Avi : Unknown format : cant play Thum hooo SONG!!
 Playing Mp3 Now Titanic
 */