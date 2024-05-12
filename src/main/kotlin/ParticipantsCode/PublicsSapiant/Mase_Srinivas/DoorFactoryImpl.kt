


//Hundred CC
class Door(room1: Room,room2: Room) : MapSite()
{
    override fun enter() {
        println("The door is Open")
    }
}


class DoorFactoryImpl : DoorFactory()
{
    override var room1: RoomFactory? = null
        get() = field
        set(value) {
            field=value
        }
    override var room2: RoomFactory? =null
        get() = field
        set(value) {
            field=value

        }
    override var open: Boolean =false
        get() = field
        set(value) {
            field=value
        }

    override fun Door(room1: RoomFactory?, room2: RoomFactory?) {
        this.room1 = room1
        this.room2 = room2

    }










    override fun enter() {
        println("The door is Open")
    }




}


abstract class DoorFactory : MapSite(){




    abstract override fun enter()

    abstract var room1: RoomFactory?
    abstract var room2: RoomFactory?
    abstract var open:Boolean

    abstract fun Door(room1: RoomFactory?, room2: RoomFactory?)





    companion object {
        // T has a problem? it cannot reinterpret the cast
        //                                  queryFactory()
        inline fun < reified T : MapSite>createFactory() : DoorFactory =
            when( T::class) {

                Room::class  -> DoorFactoryImpl()

                else -> throw IllegalArgumentException()
            }
    }

}
