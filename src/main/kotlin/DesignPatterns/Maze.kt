package clas

//sathyahelp123@gmail.com

enum class Direction { North, South, East, West };
abstract class MapSite {
    abstract fun enter(): Int
}

class Room(_roomNumber: Int) : MapSite() {

    var roomNumber: Int = 0
    init {
        roomNumber = _roomNumber
    }

    //    fun getSide(): Direction {
//        return Direction.East
//    }
//    fun getSide(direction: Direction) : MapSite{
//        return direction.name
//    }
    fun setSide(direction: Direction, site: MapSite) {}

    override fun enter(): Int {
        return 0
    }
}

class Wall() : MapSite() {
    override fun enter(): Int {
        return 0
    }
}


class Door(val room1: Room, val room2: Room) : MapSite() {

    var isOpen: Boolean = false
    override fun enter(): Int {
        return 0
    }
}

class Maze {
    fun addRoom(room: Room) {}

//    fun addRoom(roomNumber: Int): Room {
//        return Room(roomNumber)
//    }
}

abstract class MazeFactory {
//    fun makeMaze(): Maze {
//        return Maze()
//    }
    abstract fun makeMaze(room1: Room, room2: Room):Maze
    abstract fun makeRoom(roomNumber: Int):Room
    abstract fun makeDoor(room1:Room,room2:Room):Door
    abstract fun makeWall():Wall

//    fun makeWall(): Wall {
//        return Wall()
//    }

//    open fun makeRoom(roomNumber: Int): Room {
//        return Room(roomNumber)
//    }
//
//    open fun makeDoor(room1: Room, room2: Room): Door {
//        return Door(room1, room2)
//    }
}


class EnchantedMazeFactory : MazeFactory() {

    override fun makeRoom(roomNumber: Int): Room {
        return Room(roomNumber)
    }

    override fun makeDoor(room1: Room, room2: Room): Door {
        return Door(room1, room2)
    }

    override fun makeWall() :Wall{
        return Wall()
    }

    override fun makeMaze(room1: Room, room2: Room): Maze {
        return Maze()
    }
}


fun createMaze(mazeFactory: MazeFactory) : Maze{
    val room1 = mazeFactory.makeRoom(1)
    val room2 = mazeFactory.makeRoom(2)
    val door = mazeFactory.makeDoor(room1, room2)
    val myMaze = mazeFactory.makeMaze(room1,room2)


    room1.setSide(Direction.East, mazeFactory.makeWall())
    room1.setSide(Direction.West, door)
    room1.setSide(Direction.North, mazeFactory.makeWall())
    room1.setSide(Direction.South, mazeFactory.makeWall())

    room2.setSide(Direction.West, mazeFactory.makeWall())
    room2.setSide(Direction.East, door)
    room2.setSide(Direction.North, mazeFactory.makeWall())
    room2.setSide(Direction.South, mazeFactory.makeWall())

    myMaze.addRoom(room1)
    myMaze.addRoom(room2)

    return myMaze
}

fun main() {

    val maze = createMaze(EnchantedMazeFactory())
    print(maze.toString())

//    val enchantedMaze = createMaze(EnchantedMazeFactory())
//    print(enchantedMaze)

}