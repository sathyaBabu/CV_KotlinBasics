package ParticipantsCode
// Ayush..

//import DesignPatterns.AVI1
//import DesignPatterns.Avi

interface _MediaPlayer{

    fun Playit( fileName : String?)
}


open class _AVI :  _MediaPlayer{

    override fun Playit(fileName: String?) {
        println(" Playing AVI format File name : $fileName")
    }
}
open class _Mp4Player : _MediaPlayer{
    override fun Playit(fileName: String?) {
        println(" Playing Mp4 format File name : $fileName")
    }
}

open  class _VlcPlayer : _MediaPlayer{
    override fun Playit(fileName: String?) {
        println(" Playing VLC format File name : $fileName")
    }
}
open  class WindowsPlayer : _MediaPlayer{
    override fun Playit(fileName: String?) {
        println(" Playing Windows format File name : $fileName")
    }
}



// Phase II
// This adapter in turn can get connected to Adaptee...
interface PLayer{
    val mediaPlayer:_MediaPlayer
    fun show(audioType: String?, fileName: String?)
}

// Phase I  Base Class : AudioPlayer

class AudioPlayer(override val mediaPlayer: _MediaPlayer) : PLayer {

    // Phase II
    // We have to play other formats too

    // We are breaking the O principle.. by modifying the class...
    override fun show(audioType: String?, fileName: String?) {

        mediaPlayer.Playit(fileName)


    }

}

fun main(){

/*

      cd Player     :     media cd
      dvd           :     dvd
                    :     BR DVD

*/


    var audipPlayer = AudioPlayer( _AVI() )
    audipPlayer.show("Mp3","Tamasha")
    var audipPlayer4 = AudioPlayer(_VlcPlayer())
    audipPlayer4.show("Vlc","Thue heeee")
    var audipPlayer2 = AudioPlayer( WindowsPlayer() )
    audipPlayer2.show("windows","areee ")

}