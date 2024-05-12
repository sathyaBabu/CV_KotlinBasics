package DesignPatterns

import java.util.*


interface Image {
    fun process(): String?
}


class Jpeg : Image {
    override fun process(): String? {
        return "Jpeg"
    }
}

class Tiff : Image {
    override fun process(): String? {
        return "Tiff "
    }
}

class Chain {
    internal interface Image {
        fun process(): String?
    }
}
class Processor {
    private val id = nextID++
    fun handle(img: Image): Boolean {
        if (rn.nextInt(2) != 0) {
            println("Processor " + id + "Is Busy")
            return false
        }
        println("Processor " + id + ".  " + img.process())
        return true
    }

    companion object {
        private val rn = Random()
        private var nextID = 1
    }
}



fun main() {
    val input = arrayOf(Jpeg(), Jpeg(), Tiff(), Jpeg(), Tiff(), Jpeg())
    val proc = arrayOf(Processor(), Processor(), Processor())


    // Algorithm
    var i = 0
    var j: Int
    while (i < input.size) {
        j = 0
        while (proc[j].handle(input[i])) {
            j = (j + 1) % proc.size // Crude way of allocating the processor...
        }
        i++
    }
}
/*
Processor 1.  Jpeg
Processor 2Is Busy
Processor 1.  Jpeg
Processor 2.  Jpeg
Processor 3Is Busy
Processor 1.  Tiff
Processor 2Is Busy
Processor 1.  Jpeg
Processor 2Is Busy
Processor 1Is Busy
Processor 1Is Busy

Process finished with exit code 0

 */