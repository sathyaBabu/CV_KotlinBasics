package DesignPatterns

interface IStrategy{
    fun download(url: String?, filename: String?, path: String?)
}

class Download private constructor() {
    class Song {

        private var isConnect:Boolean? = false
        private var url:String? = ""
        private var filename:String? = ""
        private var libName:String? = ""
        private var path:String? = ""

        fun checkNetwork(url:String)= apply {
            this.isConnect = true
            this.url = url
        }
        fun fileName(fileName:String)   = apply { this.filename = fileName}
        fun useLib(libName:String)      = apply { this.libName  = libName}
        fun store(path:String)          = apply { this.path     = path}

        fun download() {
            if(isConnect==true){  // DownLoad on???
                when(libName){
                    "Retrofit" -> DownloadWithRetrofit().download(url,filename,path)
                    "Volley"   -> DownloadWithVolley().download(url,filename,path)
                     else      -> println("wrong lib name")
                }
            }else{
                println("Out of Network")
            }
        }
    }

    //1
    class DownloadWithRetrofit : IStrategy{
        override fun download(url: String?, filename: String?, path: String?) {
            println("Url - $url , FileName - $filename , Path - $path ")
        }

    }

    //2
    class DownloadWithVolley : IStrategy{
        override fun download(url: String?, filename: String?, path: String?) {
            println("Url - $url , FileName - $filename , Path - $path ")
        }
    }

}

fun main() {

    Download.Song()  // dependency
        .checkNetwork("www.google.com")
        .fileName("song.mp3")
        .useLib("Retrofit")
        .store("/desktop/")   // ::Usb -> use interface
        .download()

    Download.Song()
        .checkNetwork("www.Yahoo.com")
        .fileName("song.mp3")
        .useLib("Volley")
        .store("/Computer/")
        .download()

}

/*
Url - www.google.com , FileName - song.mp3 , Path - /desktop/
Url - www.Yahoo.com , FileName - song.mp3 , Path - /Computer/

 */