package ParticipantsCode

import java.io.Closeable
import java.util.*
import kotlin.collections.HashMap


abstract class Character {
    abstract fun Display(pointSize: Int)

    companion object {
        var symbol_ = 0.toChar()
        var width_ = 0
        var height_ = 0
        var ascent_ = 0
        var descent_ = 0
        var pointSize_ = 0
    }
}
class CharacterA : Character() {


    init {
        symbol_ = 'A'
        width_ = 120
        height_ = 100
        ascent_ = 70
        descent_ = 0
        pointSize_ = 0 //initialise
    }

    override fun Display(pointSize: Int) {
        pointSize_ = pointSize
        print(symbol_)
        print(" (pointsize ")
        print(pointSize_)
        print(" )")
        print("\n")
    }
}
class CharacterB : Character() {
    init {
        symbol_ = 'B'
        width_ = 140
        height_ = 100
        ascent_ = 72
        descent_ = 0
        pointSize_ = 0 //initialise
    }

    override fun Display(pointSize: Int) {
        pointSize_ = pointSize
        print(symbol_)
        print(" (pointsize ")
        print(pointSize_)
        print(" )")
        print("\n")
    }
}
class CharacterZ : Character() {
    init {
        symbol_ = 'Z'
        width_ = 100
        height_ = 100
        ascent_ = 68
        descent_ = 0
        pointSize_ = 0 //initialise
    }

    override fun Display(pointSize: Int) {
        pointSize_ = pointSize
        print(symbol_)
        print(" (pointsize ")
        print(Character.pointSize_)
        print(" )")
        print("\n")
    }
}

class CharacterFactory : Closeable {
    override fun close() {
        while (!characters_.isEmpty()) {
            val it=characters_.iterator()
//            if (it.second != null) {
//                it.second.close()
//            }
//            characters_.remove(it)
        }
    }


    fun GetCharacter(key: Char): Character? {

        var character: Character? = null
        if (characters_.containsKey(key)) {
            character = characters_.get(key)
        } else {
            character = when (key) {
                'A' -> CharacterA()
                'B' -> CharacterB()
                'Z' -> CharacterZ()
                else -> {
                    print("Not Implemented")
                    print("\n")
                    throw IllegalAccessException("Not Implemented")
                }
            }
            characters_[key] = character
        }
        return character
    }

    private val characters_ = TreeMap<Char, Character?>()

}
object Globals {
    @JvmStatic
    fun main(args: Array<String>) {
        val document = "AABBBBZZZZCCZZBBZB"
        val chars: CharArray = document.toCharArray()
        val factory: CharacterFactory? = CharacterFactory()

        // extrinsic state
        var pointSize = 10

        // For each character use a flyweight object
        for (i in 0 until document.length) {
            pointSize++

            val character = factory!!.GetCharacter(chars[i])
            character!!.Display(pointSize)
        }

        //Clean memory
//        factory = null
    }
}