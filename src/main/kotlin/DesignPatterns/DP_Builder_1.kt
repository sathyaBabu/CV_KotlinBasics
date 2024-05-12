package DesignPatterns
// Builder design pattern HTC / Samsung S10
// Step I
class  CoreMedia{

    private var codec: String?          = null
    private var streamerVLC: String?    = null
    private var surfaceFlinger: String? = null
    private var defaultSource: String?  = null
    private var plugins: String?        = null
    private var Skins: String?          = null


    var codecCost            = 0.0
    var streamerVLCCost      = 0.0
    var surfaceFlingerCost   = 0.0
    var defaultSourceCost    = 0.0
    var pluginCost           = 0.0
    var skinCost             = 0.0



    fun getCodec() {
        println("Cost : $codecCost Codec Used = $codec")
        //return codec;
    }

    fun setCodec(codec: String?) {
        codecCost = 2000.0
        this.codec = codec
    }

    fun getStreamerVLC() {
        println("Cost : $streamerVLCCost Streamer  Used = $streamerVLC")

        //return streamerVLC;
    }

    fun setStreamerVLC(streamerVLC: String?) {
        streamerVLCCost     = 1100.0
        this.streamerVLC    = streamerVLC
    }

    fun getSurfaceFlinger() {
        println("Cost : $surfaceFlingerCost  Flinger Used =  $surfaceFlinger ")

        //return ;
    }

    fun setSurfaceFlinger(surfaceFlinger: String?) {
        surfaceFlingerCost = 900.0
        this.surfaceFlinger = surfaceFlinger
    }

    fun getDefaultSource() {
        println("Cost : $defaultSourceCost Source Used Used = $defaultSource")
    }

    fun setDefaultSource(defaultSource: String?) {
        defaultSourceCost = 600.0
        this.defaultSource = defaultSource
    }

    fun getPlugins() {
        println("Cost : $pluginCost Streamer  Used = $plugins")

        //return plugins;
    }

    fun setPlugins(plugins: String?) {
        this.plugins = plugins
        pluginCost = 1200.0
    }

    fun getSkins(): String? {
        println("Cost : $skinCost Pixer Skin  Used = $Skins")
        return Skins
    }

    fun setSkins(skins: String?) {
        Skins = skins
        skinCost = 1100.0
    }


}


// builder and the concrete builder


// Media builder happens to be the abstraction layer..
// Step II
abstract class MediaBuilder {

    var coreMedia: CoreMedia? = null //  mediaHandle
        protected set

    open fun getMediaHandle(): CoreMedia? {
        return coreMedia
    }

    open fun createNewMediaPlayer() {
        coreMedia = CoreMedia()
    }

    // Above ABS layer can be used by all phones... s1.. s10 HTC

        abstract fun setMediaCodecFormat()
        abstract fun setMediaStreamer()
        abstract fun setMediaSurfaceFlinger()
        abstract fun setMediaConnectivity()
        abstract fun setStreamerPlugin()
        abstract fun setSkinUI()

    // Above ABS layer can be used by all phones... s1.. s10 HTC

//    companion object {
//        fun createNewMediaPlayer(mediaBuilder: MediaBuilder) {
//            mediaBuilder.coreMedia  = CoreMedia()   //  mediaHandle = CoreMedia()
//        }
//    }
}

// Samsung
// Step III
class SamsungMediaBuilder : MediaBuilder() {
    override fun setMediaCodecFormat() {
        // TODO Auto-generated method stub
        coreMedia!!.setCodec("AVI")
    }

    override fun setMediaStreamer() {
        // TODO Auto-generated method stub
        coreMedia!!.setStreamerVLC("Intel duel Core")
    }

    override fun setMediaSurfaceFlinger() {
        // TODO Auto-generated method stub
        coreMedia!!.setSurfaceFlinger("XDom ")
    }

    override fun setMediaConnectivity() {
        // TODO Auto-generated method stub
        coreMedia!!.setDefaultSource("Network - Wifi")
    }

    override fun setStreamerPlugin() {
        // TODO Auto-generated method stub
        coreMedia!!.setPlugins("Sony Plugin ")
    }

    override fun setSkinUI() {
        // TODO Auto-generated method stub
        coreMedia!!.setSkins("pIXER sTUDIO..")
    }
}


// Step III
// HTC
class HTC : MediaBuilder(){
    override fun setMediaCodecFormat() {
        // TODO Auto-generated method stub
        coreMedia!!.setCodec("AVI")
    }

    override fun setMediaStreamer() {
        // TODO Auto-generated method stub
        coreMedia!!.setStreamerVLC("Intel")
    }

    override fun setMediaSurfaceFlinger() {
        // TODO Auto-generated method stub
        coreMedia!!.setSurfaceFlinger("XDom")
    }

    override fun setMediaConnectivity() {
        // TODO Auto-generated method stub
        coreMedia!!.setDefaultSource("Network")
    }

    override fun setStreamerPlugin() {
        // TODO Auto-generated method stub
    }

    override fun setSkinUI() {
        // TODO Auto-generated method stub
    }
}


// Step IV
class Director {
    private  var mediaBuilder: MediaBuilder? = null ;


    // User is passing the phone which they want to create S10 / HTC
    fun setMediaBuilder( mb : MediaBuilder){
        mediaBuilder = mb
    }
    val media : CoreMedia
    get() = mediaBuilder!!.getMediaHandle()!!   // we are getting the CoreMedia handle which
                                                // points to the various elements of the phone

    fun constructMediaPlayer() {

        mediaBuilder!!.createNewMediaPlayer()  //  coreMedia = CoreMedia()

        mediaBuilder!!.setMediaCodecFormat()
        mediaBuilder!!.setMediaStreamer()
        mediaBuilder!!.setMediaSurfaceFlinger()
        mediaBuilder!!.setStreamerPlugin()
        mediaBuilder!!.setSkinUI()
        mediaBuilder!!.setMediaConnectivity()


    }
}


//////////// This is where all the changes will go



//////////////////////////////////////////////////
// Step V main program..
fun main()
{

    val directorSM = Director()
    val s10: MediaBuilder = SamsungMediaBuilder()

   // composition
    directorSM.setMediaBuilder( s10 ) // Tell the director to construct S10 phone
    directorSM.constructMediaPlayer()


    // Similar in case of HTC..

    val htc: MediaBuilder = HTC()
    val directorHTC = Director()
    directorHTC.setMediaBuilder(htc)
    directorHTC.constructMediaPlayer()


    ////////////////  Done constructing the cell phone...

    val coreMedia = directorSM.media

    coreMedia.getCodec()
    coreMedia.getStreamerVLC()
    coreMedia.getSurfaceFlinger()
    coreMedia.getPlugins()
    coreMedia.getSkins()
    coreMedia.getDefaultSource()

    println("~*~".repeat(50))


    val coreMediaHTC = directorHTC.media

    coreMediaHTC.getCodec()
    coreMediaHTC.getStreamerVLC()
    coreMediaHTC.getSurfaceFlinger()
    coreMediaHTC.getPlugins()
    coreMediaHTC.getSkins()
    coreMediaHTC.getDefaultSource()

    println("~*~".repeat(50))


/*
Cost : 2000.0 Codec Used = AVI
Cost : 1100.0 Streamer  Used = Intel duel Core
Cost : 900.0 Flinger Used = XDom
Cost : 1200.0 Streamer  Used = Sony Plugin
Cost : 1100.0 Pixer Skin  Used = pIXER sTUDIO..
Cost : 600.0 Source Used Used = Network - Wifi
~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~
Cost : 2000.0 Codec Used = AVI
Cost : 1100.0 Streamer  Used = Intel
Cost : 900.0 Flinger Used = XDom
Cost : 0.0 Streamer  Used = null
Cost : 0.0 Pixer Skin  Used = null
Cost : 600.0 Source Used Used = Network
~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~

 */







//                    val str1 = " Hello "
//                    val str2 = " World. "
//
//                    val sb = StringBuilder()
//                        .append(str1)
//                        .append(str2)
//                        .reverse()
//                        .trim()
//
//                    println(sb)  // .dlroW  olleH
    // Lame design..

    // almost like your Dialog Builder..

    // RX Java..



//    int i = 10;
//
//    i.myInt()
//    i.MyLong()
//    i.char()
//    i.calc()
//    i.iterate()
//    i.abc()


    // State design pattern..  Director... Organize the flow
    // template DP
    // Builder

    // Builder design npattern is not an extension functions.....
    // Network Guys : Network certification CISCO ...
    // Director in turn will hide all the construction details...

    // Regular rxJava Director will put all the pices together..
//
//            val rxJava = letsPutOurWorktogether()
//                .useUI( str1 )
//                .useBAckGroundThread( 10 + 20 ) // director to deal with UI/UX
//                .getNetworkOn() // SSL/TLS certificates  HTTP Volley  RETROFIT( Network Director )
//                .PushThedateToServer( "url://101.123.147.107// Post/'sdsdss'")
//                .getACKfromServer()
//                .useUI( " I'm Done porting the data..")

    // Kotlin too dos the same job in a different order...

    // Burger..



}