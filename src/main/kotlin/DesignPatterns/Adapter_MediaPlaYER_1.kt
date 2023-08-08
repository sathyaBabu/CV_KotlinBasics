package DesignPatterns

import java.util.*


interface MediaPlayer{
    fun play(audioType:String? , fileName:String?)
}

// interface for the advanced media player
// interface seg is WROMG here...

interface  AdvancedMediaPlayer{

    fun playMp4(fileName: String?)

    // NO NO NO!!!
    fun palayVLC( fileName: String?)
    fun playAVI(fileName: String?)
}



open class AVI : AdvancedMediaPlayer{
    override fun playMp4(fileName: String?) {
       println(" Playing AVI format...")
    }

    override fun palayVLC(fileName: String?) {
        println(" Playing AVI format...")
    }

    override fun playAVI(fileName: String?) {
        println(" Playing AVI format...")
    }

}
open class Mp4 : AdvancedMediaPlayer{
    override fun playMp4(fileName: String?) {
        println(" Playing MP4format...")
    }

    override fun palayVLC(fileName: String?) {
        println(" Playing Mp4 format...")
    }

    override fun playAVI(fileName: String?) {
        println(" Playing Mp4 format...")
    }
}


open class VlcPlayer : AdvancedMediaPlayer{
    override fun playMp4(fileName: String?) {
        println(" Playing VLC format...")
    }

    override fun palayVLC(fileName: String?) {
        println(" Playing Vlc format...")
    }

    override fun playAVI(fileName: String?) {
        println(" Playing VLC format...")
    }
}
// adaptee

// This adapter in turn gets connected to Adaptee

class MediaAdapter( audioType: String?) : MediaPlayer{

    var advancedMediaPLayer : AdvancedMediaPlayer? = null

    // At the time of MediaAdapter construction..
    init {

        if( audioType.equals("VLC",ignoreCase = true)){
            advancedMediaPLayer = VlcPlayer() // Adaptee
        }
        if( audioType.equals("Mp4",ignoreCase = true)){
            advancedMediaPLayer = Mp4() // Adaptee
        }

    }
// Phase II
    override fun play(audioType: String?, fileName: String?) {
        if( audioType.equals("VLC",ignoreCase = true)){
            advancedMediaPLayer!!.palayVLC(fileName)
        }
        if( audioType.equals("Mp4",ignoreCase = true)){
            advancedMediaPLayer!!.playMp4(fileName)
        }

    }

}

class AudioPlayer : MediaPlayer{

    var mediaAdapter : MediaAdapter? = null

    override fun play(audioType: String?, fileName: String?) {

        if( audioType.equals("Mp3", ignoreCase = true)){
            println(" Playing the Song $fileName decoded from the codec( MP3  ) $audioType")
        }
        else if( audioType.equals("VLC",ignoreCase = true) ||
                  audioType.equals("Mp4",ignoreCase = true))
                {

                    mediaAdapter = audioType?.let { MediaAdapter( it ) }
                    mediaAdapter!!.play(audioType,fileName)
                 }
        else{
            println("Unknown Format!!!!")
        }


    }

}
fun main(){




    var audioPlayer = AudioPlayer()
    audioPlayer.play("Mp3","Tamasha")
    audioPlayer.play("Mp4","Dil sey rey.")
    audioPlayer.play("VLC","Hello - Linol R..")

}