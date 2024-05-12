package day5

enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

interface MapSite {
    fun enter()
}

class Maze {
    var roomList: ArrayList<Room> = mutableListOf<Room>() as ArrayList<Room>
    fun addRoom(room: Room) {
        roomList.add(room)
    }
}

open class Room(roomNo: Int): MapSite {
    var roomNumber: Int
    var sides: ArrayList<MapSite?>

    init {
        this.roomNumber = roomNo
        this.sides = arrayListOf<MapSite?>(null, null, null, null)
    }

    override fun enter() {
        println("Enter room $roomNumber")
    }

    fun setSide(dir: Direction, side: MapSite) {
        when(dir) {
            Direction.NORTH -> sides.set(0, side)
            Direction.SOUTH -> sides.set(1, side)
            Direction.EAST -> sides.set(2, side)
            Direction.WEST -> sides.set(3, side)
            else -> {}
        }
    }

    fun getSide(dir: Direction): MapSite? {
        return when(dir) {
            Direction.NORTH -> sides.get(0)
            Direction.SOUTH -> sides.get(1)
            Direction.EAST -> sides.get(2)
            Direction.WEST -> sides.get(3)
            else -> {return null}
        }
    }
}

// Special type of Room
class EnchantedRoom(roomNo: Int) : Room(roomNo) {
    override fun enter() {
        println("Enter enchanted room $roomNumber")
    }
}

open class Wall: MapSite {
    override fun enter() {
        println("Hit Wall")
    }
}

// Special type of Wall
class BombedWall: Wall() {
    override fun enter() {
        println("Hit Bombed Wall")
    }
}

open class Door(room1: Room, room2: Room): MapSite {
    var isOpen: Boolean
    var room1: Room
    var room2: Room

    init {
        this.isOpen = false
        this.room1 = room1
        this.room2 = room2
    }
    override fun enter() {
        println("Enter room")
    }
}

// Maze Factory interface that implements default versions in case implementations dont override the function with specialized implementations
interface MazeFactory {
    fun MakeMaze(): Maze {
        return Maze()
    }
    fun MakeWall(): Wall {
        return Wall()
    }
    fun MakeDoor(room1: Room, room2: Room): Door {
        return Door(room1, room2)
    }
    fun MakeRoom(n: Int): Room {
        return Room(n)
    }
}

// EnchantedMazeFactory overrides MakeRoom to return EnchantedRoom instead of default Room
class EnchantedMazeFactory: MazeFactory {
    override fun MakeRoom(n: Int): Room {
        return EnchantedRoom(n)
    }
}

// BombedMazeFactory overrides MakeWall to return BombedWall instead of default Wall
class BombedMazeFactory: MazeFactory {
    override fun MakeWall(): Wall {
        return BombedWall()
    }
}

// Creates maze based on factory passed
// hiding implementation by its interface ( mazeFactory: MazeFactory ) : EnchantedMazeFactory: MazeFactory
fun createMaze(mazeFactory: MazeFactory) {
    val maze = mazeFactory.MakeMaze()
    val room1 = mazeFactory.MakeRoom(1)
    val room2 = mazeFactory.MakeRoom(2)
    maze.addRoom(room1)
    maze.addRoom(room2)
    val door = mazeFactory.MakeDoor(room1, room2)
    room1.setSide(Direction.NORTH, mazeFactory.MakeWall())
    room1.setSide(Direction.SOUTH, mazeFactory.MakeWall())
    room1.setSide(Direction.EAST, door)
    room1.setSide(Direction.WEST, mazeFactory.MakeWall())
    room2.setSide(Direction.NORTH, mazeFactory.MakeWall())
    room2.setSide(Direction.SOUTH, mazeFactory.MakeWall())
    room2.setSide(Direction.EAST, mazeFactory.MakeWall())
    room2.setSide(Direction.WEST, door)
    room1.enter()
    room1.getSide(Direction.NORTH)?.enter()
}

fun main() {
    createMaze(EnchantedMazeFactory())
    createMaze(BombedMazeFactory())
}