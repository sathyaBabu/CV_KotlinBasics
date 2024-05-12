package ParticipantsCode



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

interface MediaPlayer1{

    fun play(audioType : String? , fileName : String?)
}

// Phase II

// we are breaking SOLID principle I Interface segrigation

//interface AdvancedMediaPlayer{
//
//    fun PlayVLC( fileName : String?)
////    fun PlayMP4( fileName : String?)
////    fun PlayAVI( fileName : String?)
//
//}
interface PlayVlc1{
    fun PlayVLC1( fileName : String?)
}
interface PlayMp41{
    fun PlayMP41( fileName : String?)

}
interface PlayAVI1{
    fun PlayAVI1( fileName : String?)
}

// Adaptee....   Driver Maid Servent / cook

open class AVI : PlayAVI1 {


    override fun PlayAVI1(fileName: String?) {
        println(" Playing AVI format File name : $fileName")
    }
}
open class Mp4Player : PlayMp41{


    override fun PlayMP41(fileName: String?) {
        println(" Playing MP4 format File name : $fileName")
    }


}

open  class VlcPlayer : PlayVlc1{

    override fun PlayVLC1(fileName: String?) {
        println(" Playing VLC format File name : $fileName")
    }


}



// Phase II
// This adapter in turn can get connected to Adaptee...
class MediaAdapter1( audioType: String) : MediaPlayer1{

    //    var advancedMediaPlayer: AdvancedMediaPlayer? = null ;
    var playMp4:PlayMp41?=null
    var playAvi:PlayAVI1?=null
    var playVlc:PlayVlc1?=null

    init {
        // init the adaptee...  THINK?? am"i Right doing so?????? did I break any basic.. principle
        if( audioType.equals("Vlc", ignoreCase = true)){
            playVlc = VlcPlayer()   // adaptee
        }
        if( audioType.equals("Mp4", ignoreCase = true)){
            playMp4= Mp4Player() //  // adaptee
        }

    }

    // Let me initiate this block latter!!!!!!!

    override fun play(audioType: String?, fileName: String?) {

        if( audioType.equals("Vlc", ignoreCase = true)){
            playVlc !!.PlayVLC1(fileName)
        }
        if( audioType.equals("Mp4", ignoreCase = true)){
            playMp4!!.PlayMP41(fileName)
        }


    }

}

//////////
// Phase I  Base Class : AudioPlayer

class AudioPlayer1 : MediaPlayer1 {

    // Phase II
    // We have to play other formats too

    // We are breaking the O principle.. by modifying the class...

    var mediaAdapter1: MediaAdapter1? = null ;


    override fun play(audioType: String?, fileName: String?) {
        if( audioType.equals("Mp3", ignoreCase =  true)){
            println(" Playing $audioType Now $fileName")
        }else if ( audioType.equals("Vlc", ignoreCase = true) ||
            audioType.equals("Mp4", ignoreCase =  true) )
        {

            // Constructed the MediaAdapter object..
            mediaAdapter1 = audioType?.let { MediaAdapter1(it) }

            // add the play line latter..


            mediaAdapter1!!.play(audioType, fileName)  // Vlc or Mp4



        } else {
            println("  $audioType : Unknown format : cant play $fileName SONG!!")
        }

    }


}

fun main(){

    var audipPlayer1 = AudioPlayer1()
    audipPlayer1.play("Mp3","Tamasha")  // P
    audipPlayer1.play("Mp4","Dil se rey. ") // p
    audipPlayer1.play("Vlc","Thue heeee")  // P
    audipPlayer1.play("Avi","Thum hooo") //  Avi : Unknown format : cant play Thum hooo SONG!!
    audipPlayer1.play("Mp3","Titanic")   // P



}
/*
 Playing Mp3 Now Tamasha
 Playing MP4 format File name : Dil se rey.
 Playing VLC format File name : Thue heeee
  Avi : Unknown format : cant play Thum hooo SONG!!
 Playing Mp3 Now Titanic
 */