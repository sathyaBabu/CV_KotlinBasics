package DesignPatterns


/*
     Road Map  for today and Tomorrow

     Builder
         ------> Visitor
     Command
     Composite
     Iterator

     and its dependency


      {
        Iterator...    He gets the cot of the ordered prod. like meal plan....
          {
             Menu -> factory to get the product
           Composite -> He will create a tree of the product.. Meal plan, combo
             {
              Command -> Do / Undo / redo
                     {


                         Visitor -> calculate the cost of the product / Gst / profitmade
                                 {
                                       Builder-> KFC products  ( Creational pattren -> breaking the classs.. )
                                  }
                      }
            }

// A
//                       B                                   B
var button = Button( some object )   -> onClickListener

maze Game...

 */


// Builder design pattern HTC / Samsung S10   / S3
// Step I

// This way of coding isnot appropriate..

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
        println("Cost : " + surfaceFlingerCost + " Flinger Used = " + surfaceFlinger)

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

    // BUT is from Command DP
//
//    fun execute() {
//
//    }


}


// Phase II

abstract class MediaBuilder {

    // it's a cluster of small entities.. or class..
    // instead of one big complex rep lets have many simple rep..( Class )

    var coreMedia : CoreMedia? = null
    protected set

    open fun getMediaHandler() : CoreMedia? {
        return  coreMedia
    }

    open fun createNewMediaPlayer() {
        coreMedia = CoreMedia()   // simple rep..( Class )
    }


    abstract fun setMediaCodecFormat()
    abstract fun setMediaStreamer()
    abstract fun setMediaSurfaceFlinger()
    abstract fun setMediaConnectivity()
    abstract fun setStreamerPlugin()
    abstract fun setSkinUI()

}

// Phase III

class SamsungMediaBuilder : MediaBuilder()  {
    override fun setMediaCodecFormat() {
        coreMedia!!.setCodec("AVI")
    }

    override fun setMediaStreamer() {
       coreMedia!!.setStreamerVLC("Intel duel core..")
    }

    override fun setMediaSurfaceFlinger() {
       coreMedia!!.setSurfaceFlinger("XDom")
    }

    override fun setMediaConnectivity() {
        coreMedia!!.setDefaultSource("Network - WIFI")
    }

    override fun setStreamerPlugin() {
        coreMedia!!.setPlugins("Sony Plugin")
    }

    override fun setSkinUI() {
       coreMedia!!.setSkins("pIXER sTudio")
    }

}

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

// Phase IV

class  Director {

    private  var mediaBuilder : MediaBuilder? = null

    fun setMediaBuilder( mb:  MediaBuilder){
        mediaBuilder = mb ;
    }

    val media : CoreMedia
    get() = mediaBuilder!!. getMediaHandler()!!

   // template
    fun constructMediaPlayer(){

        // the order of the creation is been chizled by the director/.

        mediaBuilder!!.createNewMediaPlayer()  // simple rep..( Class )
        mediaBuilder!!.setMediaConnectivity()
        mediaBuilder!!.setMediaStreamer()
        mediaBuilder!!.setMediaSurfaceFlinger()
        mediaBuilder!!.setStreamerPlugin()
        mediaBuilder!!.setSkinUI()


    }



}




fun main(){


    // Use case diagram

    val directorSm         = Director()
    val s10 : MediaBuilder = SamsungMediaBuilder()

    // composition

    directorSm.setMediaBuilder( s10 )
    directorSm.constructMediaPlayer()

    // simal for HTC

    val htc: MediaBuilder = HTC()
    val directorHTC = Director()
    directorHTC.setMediaBuilder( htc )
    directorHTC.constructMediaPlayer()





    val coreMedia = directorSm.media   // pointing to CoreMedia

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


}


/*


Cost : 0.0 Codec Used = null
Cost : 1100.0 Streamer  Used = Intel duel core..
Cost : 900.0 Flinger Used = XDom
Cost : 1200.0 Streamer  Used = Sony Plugin
Cost : 1100.0 Pixer Skin  Used = pIXER sTudio
Cost : 600.0 Source Used Used = Network - WIFI
~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~
Cost : 0.0 Codec Used = null
Cost : 1100.0 Streamer  Used = Intel
Cost : 900.0 Flinger Used = XDom
Cost : 0.0 Streamer  Used = null
Cost : 0.0 Pixer Skin  Used = null
Cost : 600.0 Source Used Used = Network
~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~~*~

Process finished with exit code 0

 */