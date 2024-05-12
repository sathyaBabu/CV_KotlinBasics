package SOLID



/**
 *  Voilation
 */
interface Switches {

    fun startEngine()
    fun shutDownEngine()

    fun turnRadioOn()
    fun turnRadioOff()

    fun turnCameraOn()
    fun turnCameraOff()
}

interface DroneSwitches{

    fun startEngine()
    fun shutDownEngine()

    fun turnCameraOn()
    fun turnCameraOff()
}

interface carSwitches{

    fun startEngine()
    fun shutDownEngine()

    fun turnRadioOn()
    fun turnRadioOff()
}

/**
 *  Voilation
 */
abstract class Vehicle : Switches {
    var isEngineRunning = false
        private set

    override fun startEngine() {
        isEngineRunning = true
    }

    override fun shutDownEngine() {
        isEngineRunning = false
    }
}

class Drone : Vehicle() {
    var isCameraOn = false
        private set

    override fun turnCameraOn() {
        isCameraOn = true
    }

    override fun turnCameraOff() {
        isCameraOn = false
    }

    override fun turnRadioOn() {
        // nothing to do here
    }

    override fun turnRadioOff() {
        // nothing to do here
    }
}
/**
 *  Voilation
 */
class Car : Vehicle() {
    var isRadioOn = false
        private set

    override fun turnRadioOn() {
        isRadioOn = true
    }

    override fun turnRadioOff() {
        isRadioOn = false
    }

    override fun turnCameraOn() {
        // nothing to do here
    }

    override fun turnCameraOff() {
        // nothing to do here
    }
}
fun main(){}