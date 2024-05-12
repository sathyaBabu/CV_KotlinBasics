package DesignPatterns



interface MediaPlayer2{

    fun play(audioType : String? , fileName : String?)
}


// implementor
open class AVI1: MediaPlayer2{

    override fun play(audioType : String? , fileName : String?) {
        println(" Cannot Play $audioType format File name : $fileName")
    }
}
open class Mp4Player2: MediaPlayer2{

    override fun play(audioType : String? , fileName : String?) {
        println(" Playing $audioType format File name : $fileName")
    }

}

open  class VlcPlayer2 : MediaPlayer2{

    override fun play(audioType : String? , fileName : String?) {
        println(" Playing $audioType format File name : $fileName")
    }

}



// Phase II
// This adapter in turn can get connected to Adaptee...
interface mediaBridge{
    // abstractions
    val _med:MediaPlayer2
    fun _play(audioType: String?,fileName: String?)
}
class mp4(override val _med: MediaPlayer2) :mediaBridge{
    override fun _play(audioType: String?,fileName: String?) {
        _med.play(audioType, fileName)
    }

}
class Vlc(override val _med: MediaPlayer2) :mediaBridge{
    override fun _play(audioType: String?,fileName: String?) {
        _med.play(audioType, fileName)
    }

}
class Avi(override val _med: MediaPlayer2) :mediaBridge{
    override fun _play(audioType: String?,fileName: String?) {
        _med.play(audioType, fileName)
    }

}
fun main(){


    // Bridge is used under collections..

    var audipPlayer2 =mp4( Mp4Player2() )
    var audipPlayer3 =Vlc(VlcPlayer2())
    var audipPlayer4 =Avi(AVI1())

//    audipPlayer2.play("Mp3","Tamasha")  // P
    audipPlayer2._play("Mp4","Dil se rey. ") // p
    audipPlayer3._play("Vlc","Thue heeee")  // P
    audipPlayer4._play("Avi","Thum hooo") //  Avi : Unknown format : cant play Thum hooo SONG!!
//    audipPlayer2.play("Mp3","Titanic")   // P



}
