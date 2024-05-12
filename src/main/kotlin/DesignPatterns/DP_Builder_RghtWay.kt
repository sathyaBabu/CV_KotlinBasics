package day6

enum class DataTypeCustom {
    StreamerVLC, Codec, SurfaceFlinger, DefaultSource, Plugins, Skins
}

// why not a data class  here..
interface DataStructure {
    fun getData()
    fun setData(name: String)
}

class CodecData() : DataStructure {
    var codec: String? = null
    var codecCost: Double = 0.0

    override fun getData() {
        println("Cost : $codecCost Codec Used = $codec")
    }

    override fun setData(name: String) {
        codecCost = 2000.0
        codec = name
    }
}


class StreamerVLCData() : DataStructure {
    var streamerVLCCost: Double = 2000.0
    var streamerVLC: String?     = null

    override fun getData() {
        println("Cost : $streamerVLCCost Codec Used = $streamerVLC")
    }

    override fun setData(name: String) {
        streamerVLCCost = 2000.0
        streamerVLC = name
    }
}

class SurfaceFlingerData() : DataStructure {
    var surfaceFlinger: String? = null
    var surfaceFlingerCost: Double = 0.0

    override fun getData() {
        println("Cost : $surfaceFlingerCost Codec Used = $surfaceFlinger")
    }

    override fun setData(name: String) {
        surfaceFlingerCost = 2000.0
        surfaceFlinger = name
    }
}


class PluginsData() : DataStructure {
    var plugins: String? = null
    var pluginCost: Double = 0.0

    override fun getData() {
        println("Cost : $pluginCost Codec Used = $plugins")
    }

    override fun setData(name: String) {
        pluginCost = 2000.0
        plugins = name
    }
}


class DefaultSourceData() : DataStructure {
    var defaultSource: String? = null
    var defaultSourceCost: Double = 0.0

    override fun getData() {
        println("Cost : $defaultSourceCost Codec Used = $defaultSource")
    }

    override fun setData(name: String) {
        defaultSourceCost = 2000.0
        defaultSource = name
    }
}

class SkinsData() : DataStructure {
    var skinsCost: Double = 0.0
    var skins: String? = null

    override fun getData() {
        println("Cost : $skinsCost Codec Used = $skins")
    }

    override fun setData(name: String) {
        skinsCost = 2000.0
        skins = name
    }
}


class CoreMedia {
    var streamerVLCData      : StreamerVLCData       = StreamerVLCData()
    var codecData            : CodecData             = CodecData()
    var skinData             : SkinsData             = SkinsData()
    var defaultSourceData    : DefaultSourceData     = DefaultSourceData()
    var surfaceFlingerData   : SurfaceFlingerData    = SurfaceFlingerData()
    var pluginsData          : PluginsData           = PluginsData()

    fun getCoreMediaData(data: DataTypeCustom) {
        when (data) {
            DataTypeCustom.Codec -> codecData.getData()
            DataTypeCustom.StreamerVLC -> streamerVLCData.getData()
            DataTypeCustom.DefaultSource -> defaultSourceData.getData()
            DataTypeCustom.Plugins -> pluginsData.getData()
            DataTypeCustom.Skins -> skinData.getData()
            DataTypeCustom.SurfaceFlinger -> surfaceFlingerData.getData()
        }

    }

    fun setCoreMediaData(data: DataTypeCustom, name: String) {
        when (data) {
            DataTypeCustom.Codec -> codecData.setData(name)
            DataTypeCustom.StreamerVLC -> streamerVLCData.setData(name)
            DataTypeCustom.DefaultSource -> defaultSourceData.setData(name)
            DataTypeCustom.Plugins -> pluginsData.setData(name)
            DataTypeCustom.Skins -> skinData.setData(name)
            DataTypeCustom.SurfaceFlinger -> surfaceFlingerData.setData(name)
        }
    }
}


// Phase II
abstract class MediaBuilder {

    // it's a cluster of small entities.. or class..
    // instead of one big complex rep lets have many simple rep..( Class )
    var coreMedia: CoreMedia? = null
        protected set

    open fun getMediaHandler(): CoreMedia? {
        return coreMedia
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
class SamsungMediaBuilder : MediaBuilder() {
    override fun setMediaCodecFormat() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.Codec, "AVI")
    }

    override fun setMediaStreamer() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.StreamerVLC, "Intel duel core..")
    }

    override fun setMediaSurfaceFlinger() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.SurfaceFlinger, "XDom")
    }

    override fun setMediaConnectivity() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.DefaultSource, "Network - WIFI")
    }

    override fun setStreamerPlugin() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.Plugins, "Sony Plugin")
    }

    override fun setSkinUI() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.Skins, "pIXER sTudio")
    }

}

// HTC
class HTC : MediaBuilder() {


    override fun setMediaCodecFormat() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.Codec, "AVI")
    }

    override fun setMediaStreamer() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.StreamerVLC, "Intel")
    }

    override fun setMediaSurfaceFlinger() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.SurfaceFlinger, "XDom")
    }

    override fun setMediaConnectivity() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.DefaultSource, "Network")
    }

    override fun setStreamerPlugin() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.Plugins, "Sony Plugin asd")
    }

    override fun setSkinUI() {
        coreMedia!!.setCoreMediaData(DataTypeCustom.Skins, "pIXER sTudiasdo")
    }


}

// command should extend the builder , should be able to add class to perform the addition
// activity to builder
// without tight copling
// sathyahelp123@gmail.com


//  return self

//abstract class ReturnBuilder {
//    fun returnBuilder(): ReturnBuilder {
//        return this
//    }
//}

// Phase IV
class Director {

    private var mediaBuilder: MediaBuilder? = null
    fun setMediaBuilder(mb: MediaBuilder) {
        mediaBuilder = mb;
    }

    val media: CoreMedia
        get() = mediaBuilder!!.getMediaHandler()!!

    // template

// This creates a complete burger but user should be able to add/pass or delete few ingredieants here..
    fun constructMediaPlayer() {
        // following has to get to command with the director
        // what ever user selects and deletes on the cart has to be reflected here.
        // Store that in a array and map it here

        mediaBuilder!!.createNewMediaPlayer()  // simple rep..( Class )
        mediaBuilder!!.setMediaConnectivity()
                    mediaBuilder!!.setMediaConnectivity()
                    mediaBuilder!!.setMediaConnectivity()
                    mediaBuilder!!.setMediaConnectivity()
        mediaBuilder!!.setMediaStreamer()
        mediaBuilder!!.setMediaSurfaceFlinger()
        mediaBuilder!!.setStreamerPlugin()
        mediaBuilder!!.setSkinUI()
    }
}


fun main() {
    val s10: MediaBuilder = SamsungMediaBuilder()
    val directorSm = Director()
    directorSm.setMediaBuilder(s10)
    directorSm.constructMediaPlayer()  // Director has to be composed into Command.

    val htc: MediaBuilder = HTC()
    val directorHTC = Director()
    directorHTC.setMediaBuilder(htc)
    directorHTC.constructMediaPlayer()

    // not right..

    val coreMedia = directorSm.media   // pointing to CoreMedia
    coreMedia.getCoreMediaData(DataTypeCustom.Codec)
    coreMedia.getCoreMediaData(DataTypeCustom.StreamerVLC)
    coreMedia.getCoreMediaData(DataTypeCustom.SurfaceFlinger)
    coreMedia.getCoreMediaData(DataTypeCustom.Plugins)
    coreMedia.getCoreMediaData(DataTypeCustom.Skins)
    coreMedia.getCoreMediaData(DataTypeCustom.DefaultSource)

    println("~*~".repeat(50))

    val coreMediaHTC = directorHTC.media
    coreMediaHTC.getCoreMediaData(DataTypeCustom.Codec)
    coreMediaHTC.getCoreMediaData(DataTypeCustom.StreamerVLC)
    coreMediaHTC.getCoreMediaData(DataTypeCustom.SurfaceFlinger)
    coreMediaHTC.getCoreMediaData(DataTypeCustom.Plugins)
    coreMediaHTC.getCoreMediaData(DataTypeCustom.Skins)
    coreMediaHTC.getCoreMediaData(DataTypeCustom.DefaultSource)

    println("~*~".repeat(50))
}