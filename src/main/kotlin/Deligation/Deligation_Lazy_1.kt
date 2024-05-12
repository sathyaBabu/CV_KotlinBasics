package Deligation

// https://www.youtube.com/watch?v=QWIXfg3Eb8M

interface Engine {
    fun runsOn();
    fun getTransmissionType()
}

class ElectricEngine: Engine{
    override fun runsOn() {
        println("Runs on electricity")
    }

    override fun getTransmissionType() {
        println("No Manual transmission")
    }
}
// phase I
//
//class TeslaEngine (val engine: Engine) {
//    fun runsOn() {
//        engine.runsOn()
//    }
//}

// phase II
class TeslaEngine (val engine: Engine) : Engine by engine

// phase III
//class TeslaEngine (val engine: Engine): Engine by engine {
//    override fun getTransmissionType() {
//        println("Not applicable")
//    }
//}

fun main(array: Array<String>) {
    val  sampleEngine = TeslaEngine(ElectricEngine())
    sampleEngine.runsOn()
    sampleEngine.getTransmissionType()

    // phase III
   // sampleEngine.getTransmissionType()
}