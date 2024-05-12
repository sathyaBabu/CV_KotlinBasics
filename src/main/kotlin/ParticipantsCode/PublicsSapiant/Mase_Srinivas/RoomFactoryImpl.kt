

//thousand CC
class Room() : MapSite()
{
    override fun enter() {
        println()
    }

}

class RoomFactoryimpl() : RoomFactory() {

    override var roomNumber: Int = 0
        get() = field
        set(value) {
            field=value
        }
    override var _sides: MutableList<MapSite> = ArrayList()
        get() = field
        set(value) {

            field=value
        }



    override fun getSide(direction: Direction): MapSite
    {

        return _sides[direction.ordinal]

    }

    override fun setSide(direction: Direction, mapsite: MapSite)
    {

        _sides.add(direction.ordinal,mapsite)
       // _sides.set(direction.ordinal,mapsite)

      //  _sides[direction.ordinal] = mapsite;

    }


    override fun enter() {
//        println("Enter the room number ")
//       var roomNumber =  readln()

        println("you entered the RoomNumber $roomNumber")


        for (side in _sides) {
            side.enter()
        }

    }

}


// Abstraction layer
// he is the provider of CITI_BANK and HDFC_BANK idf thats the case CITIBankFactory()
// has to be a dependency ( has to injected )
abstract class RoomFactory {



    abstract var roomNumber:Int;
    abstract var _sides : MutableList<MapSite>;




    abstract fun getSide(direction: Direction): MapSite


    abstract fun setSide(direction: Direction, mapsite: MapSite)


    abstract fun enter()



    //  abstract  fun createBankLoan() : BANK_RBI_LOAN
    //  make the abstract class RBIbank_factory  as a SingleTon
    companion object {
        // T has a problem? it cannot reinterpret the cast
        //                                  queryFactory()
        inline fun < reified T : MapSite>createFactory() : RoomFactory =
            when( T::class) {

                Room::class  -> RoomFactoryimpl()

                else -> throw IllegalArgumentException()
            }
    }

}





