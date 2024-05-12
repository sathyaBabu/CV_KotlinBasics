package ParticipantsCode

enum class Direction11 { North, South, East, West }


interface MapSite11 {
    public fun Enter()
}

class Room11(roomNo:Int):MapSite11{
    var roomNo:Int = 0
    //    protected var _sides= hashMapOf<Direction, MapSite1>()
    init{
        this.roomNo=roomNo
    }

    protected var map= hashMapOf< Direction11, MapSite11? >()

    fun SetSide(dir:Direction11, site: MapSite11 ) {
        when (dir) {
            Direction11.North -> map[Direction11.North] = site
            Direction11.South -> map[Direction11.South] = site
            Direction11.East  -> map[Direction11.East] = site
            Direction11.West  -> map[Direction11.West] = site
        }
    }

    fun GetSide(dir:Direction11): MapSite11? {

        when (dir) {

            Direction11.North -> return map[Direction11.North]
            Direction11.South -> return map[Direction11.South]
            Direction11.East -> return map[Direction11.East]
            Direction11.West -> return map[Direction11.West]

        }
    }

    override fun Enter() {
        println("You are standing in room $roomNo now")
    }

}



class Door11(_room1:Room11?, _room2: Room11?): MapSite11 {
    init {
        println("Door")
    }

    protected var _room1:Room11?
    protected var _room2:Room11?
    init{
        this._room1=_room1
        this._room2=_room2
    }
    fun OtherSideFrom() {
        println("successfully reached to the other side of the door ")
    }

    override fun Enter() {
        //nothing to do
    }
}



class Wall11:MapSite11{
    init {
        println("Wall")
    }
    override fun Enter() {
        println("oops !! you bang your head")
    }
}





class Maze11{
    init {
        println("The maze")
    }
    private val _rooms: MutableSet<Room11> = HashSet()
    fun AddRoom(r: Room11) {
        if (!_rooms.contains(r)) {
            _rooms.add(r)
        }
    }
    fun GetRoom(rol:Int):Room11{
        return _rooms.elementAt(rol-1)
    }


}


class MazeGame11{
    fun createMaze(): Maze11 {
        var amaze = Maze11()

        var r1 = Room11(1)
        var r2 = Room11(2)

        var door = Door11(r1,r2)

        amaze.AddRoom(r1)
        amaze.AddRoom(r2)

        r1.SetSide(Direction11.North , Wall11())
        r1.SetSide(Direction11.East , door)
        r1.SetSide(Direction11.South , Wall11())
        r1.SetSide(Direction11.West, Wall11())



        r2.SetSide(Direction11.North , Wall11())
        r2.SetSide(Direction11.East , Wall11())
        r2.SetSide(Direction11.South , Wall11())
        r2.SetSide(Direction11.West, door)

        return amaze
    }
}


fun main(){
    var roomno = 1;
    var mapsiteObj: MapSite11
    var aMazeGAme = MazeGame11()
    var maze:Maze11 = aMazeGAme.createMaze()
    var room:Room11 = maze.GetRoom(roomno)
    println("-*-".repeat(50))
    room.Enter()

    var front:String = " "
    var door:String = " "
    var flag = true
    while (flag){
        println("Which side do you want to move now? Please enter :- 0.North  1.South 2.East 3.West")
        var input = readLine()
        when (input) {
            "0" -> {
                mapsiteObj = room?.GetSide(Direction11.North)!!
                front = mapsiteObj::class.simpleName.toString()
            }
            "1" -> {
                mapsiteObj = room?.GetSide(Direction11.South)!!
                front = mapsiteObj::class.simpleName.toString()
            }
            "2" -> {
                mapsiteObj = room?.GetSide(Direction11.East)!!
                front = mapsiteObj::class.simpleName.toString()
            }
            "3" -> {
                mapsiteObj = room?.GetSide(Direction11.West)!!
                front = mapsiteObj::class.simpleName.toString()
            }
            else -> {
                println("You are still in the maze, please say which side you want to enter")
            }

        }
//      println(front)
        door = Door11::class.simpleName.toString()
        if(front == door){
            println("greate match")
            var r1 = Room11(1)
            var r2 = Room11(2)

            var door = Door11(r1,r2)
            door.OtherSideFrom()
            flag = false
        }
        else{
            var wall = Wall11()
            wall.Enter()
        }

    }

}