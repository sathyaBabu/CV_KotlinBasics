package Class

// Inheritance
//          When we want to connect two diffrent( Obj ) components together

//      A      B    // interfece..
// when obj a wants to obj B CallBack ( Interfce )


interface Clickable {
    fun click()
}
class MacButton : Clickable {
    override fun click() = println("You clicked the Mac Button")
}

class WinButton : Clickable {
    override fun click() = println("You clicked the Win Button")
}

fun main(args: Array<String>) {
    MacButton().click()

    // phase II down
    CellPhoneInterface()   // lot of pheri.. components.. Battery Wifi network nfc
}


////// call multiple interface

//class BatteryHugeClass  - Battery Interface in it   user too can access battery interface // API...
// abstraction... is used only at the development time
// Interface is used by the applications..
/*

 Class :{
    PranavHouse
        BedRoomStudy
        Dad'sWork Rook
        Kitchen

        interface iPranavsHouse
          fun BedRoomStudy()   // Dummy

  }
 */



interface Battery {
    fun displayBatteryStatus() {
        println(" Battery Interface..")
    }
    fun ChargeBattery(){
        println(" Battery Interface..ChargeBattery ")
    }
    fun ChargeByUSB(){
        println(" Battery Interface.. ChargeByUSB")
    }
    fun ChargeByPower(){
        println(" Battery Interface.. ChargeByPower")
    }
}

interface Network  {
    fun displayNetworkStetus() {
        println("Network interface ")
    }
}

// implements two interfaces A and B

class CellPhone : Network,Battery

fun CellPhoneInterface() {

    val cell = CellPhone()
    cell.displayBatteryStatus()
    cell.displayNetworkStetus()
    cell.ChargeBattery()
}
/*
You clicked the Button
 Battery Interface..
Network interface B

Process finished with exit code 0

 */