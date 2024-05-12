package DesignPatterns


/*

   Android
     1.   https://developer.android.com/reference/android/widget/ArrayAdapter
        // Intresting link
     2.   https://developer.android.com/guide/topics/ui/declaring-layout#AdapterViews

     3. Adapter to the point..
     https://developer.android.com/reference/android/widget/AdapterView

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


/*


    Media player
        Play -> .mp3

        unsupported format

        .mp4
        .avi

        Adaptee which can play .mp4 and .avi

        ADAPTER connect that toADAPTEE

        plug the Adapter to the TARGET


        House

               ADAPTEE
            -> Interior soft

            -> Adapter can connect Target to ADAPTEE
 */

interface  MediaPlayer {
    fun Play( audioType : String? , fileName : String?)
}


// shall be used by the  Adaptee....
// Watch the way we are heading toward the interface..


// we are going wrong with our interface segrigation principal..



// Convert the interface of a class into another interface clients expect. Adapter lets classes work together
// that couldn't otherwise because of incompatible interfaces.

// interface is also a dependency... for our Adaptee

interface  AdvancedMediaPlayer{

    fun PlayVLC( fileName : String?)
    fun PlayMp4( fileName : String?)
    fun PlayAVI( fileName : String?)
}

// who will be using the interface

// Adaptee
open class AVI : AdvancedMediaPlayer{

    override fun PlayVLC(fileName: String?) {
        TODO("Not yet implemented")
    }

    override fun PlayMp4(fileName: String?) {
        TODO("Not yet implemented")
    }

    override fun PlayAVI(fileName: String?) {
        println("Playing AVI format now fileName : $fileName")
    }

}

// Adaptee
open class VLCplayer : AdvancedMediaPlayer{
    override fun PlayVLC(fileName: String?) {
        println("Playing VLC format now fileName : $fileName")
    }

    override fun PlayMp4(fileName: String?) {
        TODO("Not yet implemented")
    }

    override fun PlayAVI(fileName: String?) {
        TODO("Not yet implemented")
    }

}
// Adaptee
open class MP4player : AdvancedMediaPlayer {
    override fun PlayVLC(fileName: String?) {
        TODO("Not yet implemented")
    }

    override fun PlayMp4(fileName: String?) {
        println("Playing MP4 format now fileName : $fileName")
    }

    override fun PlayAVI(fileName: String?) {
        TODO("Not yet implemented")
    }

}


// Phase II
// Adapter( MediaAdapter ) in turn gets connected to Adaptee....

class MediaAdapter( audioType: String?) : MediaPlayer{

    // interface is also a dependency...   HIT Dagger2..
    // folllowing interface dependency will connect Adaptee to Adapter..
    // Phase A
    var advancedMediaPlayer : AdvancedMediaPlayer? = null


    // Phase  B
    init {
        if( audioType.equals("VLC",ignoreCase = true)){
            // when the user request for VLC or MP4 provide the same to the interface as a dependency.
            // We are injecting( providing  HILT Dagger2 ) VLCPlayer() to our interface..
            advancedMediaPlayer = VLCplayer()  // adaptee provider to our interface dependency..
        }
        if( audioType.equals("MP4",ignoreCase = true)){
            advancedMediaPlayer = MP4player()  // adaptee
        }

    }

    // Phase C
    // meant for the unknown types...
    override fun Play(audioType: String?, fileName: String?) {
        if( audioType.equals("VLC",ignoreCase = true)){
            advancedMediaPlayer!!.PlayVLC(fileName)
        }
        if( audioType.equals("MP4",ignoreCase = true)){
            advancedMediaPlayer!!.PlayMp4(fileName)
        }
    }

}

// AudioPlayer  -> Target

class AudioPlayer : MediaPlayer {


    // Adapter (  MediaAdapter ) plugs the Adapteee into the Target ( Audio Player )

    // plug the adapter to the target target gets connected to Adaptee
    var mediaAdapter : MediaAdapter? = null ;

    override fun Play(audioType: String?, fileName: String?) {

        if( audioType.equals("Mp3", ignoreCase = true)){
            println("Playing $audioType Now $fileName")
        } else if ( audioType.equals("VLC",ignoreCase = true) ||
            audioType.equals("MP4",ignoreCase = true)){

            // This is where the adapter is getting called..

            mediaAdapter = audioType?.let { MediaAdapter( it ) }

            mediaAdapter!!.Play( audioType,fileName)   //  VLC or MP4

        }

        else {
            println(" $audioType : Unknown format : Cant play $fileName Song!!!")
        }
    }

}

fun main(){
    var audioPlayer = AudioPlayer()

    audioPlayer.Play("Mp3" , "Tamasha")
    audioPlayer.Play("Mp4" , "Dil se rey.")
    audioPlayer.Play("Vlc" , "Thue heee")
    audioPlayer.Play("Avi" , "Thum ho")
    audioPlayer.Play("Mp3" , "Titanic")
    audioPlayer.Play("Mp3" , "Police")





}
