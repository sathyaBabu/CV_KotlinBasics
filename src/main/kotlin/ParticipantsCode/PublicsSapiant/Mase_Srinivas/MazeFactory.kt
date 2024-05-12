


class Maze : MapSite()
{
    override fun enter() {
        println()
    }
}



class MazeFactoryimpl() : MazeFactory() {
    override var roomList: MutableList<RoomFactory> = ArrayList()
        get() = field
        set(value) {
            field=value
        }


    override fun addRoom(room: RoomFactory) {
        roomList.add(room)
    }

    override fun enterTheRoom(roomNumber: Int) {
        val room = roomNo(roomNumber)
        room?.enter()
    }

    override fun roomNo(roomNumber: Int): RoomFactory? {
        for (room in roomList) {
            if (room.roomNumber == roomNumber) {
                return room
            }
        }
        return null
    }

}


// Abstraction layer
// he is the provider of CITI_BANK and HDFC_BANK idf thats the case CITIBankFactory()
// has to be a dependency ( has to injected )
abstract class MazeFactory {



    abstract var roomList: MutableList<RoomFactory>

    abstract fun addRoom(room: RoomFactory)

    abstract fun enterTheRoom(roomNumber: Int)

    abstract fun roomNo(roomNumber: Int): RoomFactory?


    //  abstract  fun createBankLoan() : BANK_RBI_LOAN
    //  make the abstract class RBIbank_factory  as a SingleTon
    companion object {
        // T has a problem? it cannot reinterpret the cast
        //                                  queryFactory()
        inline fun < reified T : MapSite>createFactory() : MazeFactory =
            when( T::class) {

                Maze::class  -> MazeFactoryimpl()

                else -> throw IllegalArgumentException()
            }
    }

}