


enum class  Direction{ North, South, East, West }



//CAR Parts
abstract class MapSite {

    abstract fun enter()
}

class MazeGame
{
   //if you create a Ten rooms need to load in for loop
    fun createMaze(roomFactory: RoomFactory,wallFactory: WallFactory,
                   factory: MazeFactory,doorFactory: DoorFactory): MazeFactory? {
        val maze = factory;
        val r1 = roomFactory
        roomFactory.roomNumber=2    // ********* room Number hARD CODED
        val door = doorFactory
        maze.addRoom(r1)
        r1.setSide(Direction.North, wallFactory)
        r1.setSide(Direction.South, wallFactory)
        r1.setSide(Direction.East, door)
        r1.setSide(Direction.West, wallFactory)
        return maze
    }

}

fun main() {

    val roomFactory = RoomFactory.createFactory<Room>()
    val wallFactory = WallFactory.createFactory<Wall>()
    val mazeFactory = MazeFactory.createFactory<Maze>()
    val doorFactory = DoorFactory.createFactory<Room>()

    val mazeGame = MazeGame()

    var maze = mazeGame.createMaze(roomFactory!!,wallFactory,mazeFactory,doorFactory)
    maze!!.enterTheRoom(2)
    maze.let {

        print(it)
    }


}







