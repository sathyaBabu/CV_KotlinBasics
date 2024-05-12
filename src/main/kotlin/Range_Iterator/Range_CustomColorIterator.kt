package Range_Iterator


import java.lang.IllegalStateException


// Implement the same concept to iterate on the date range... LocalDate() from .. LocalDate()To

class CustomColor(val rgb: Int): Comparable<CustomColor> {

    override fun compareTo(other: CustomColor): Int {
        return this.rgb.compareTo(other.rgb)
    }

    operator fun rangeTo(that: CustomColor) = ColorRange(this, that) // this will iterate through colors below

    operator fun inc(): CustomColor {
        return CustomColor(rgb + 1)
    }

    init {
        if(rgb < 0x000000 || rgb > 0xFFFFFF){
            throw IllegalStateException("RGB must be between 0 and 16777215")
        }
    }

    override fun toString(): String {
        return "CustomColor(rgb=$rgb)"
    }
}
class ColorRange(override val start: CustomColor,
                 override val endInclusive: CustomColor) : ClosedRange<CustomColor>,
                                                           Iterable<CustomColor>{

    override fun iterator(): Iterator<CustomColor> {
        return ColorIterator(start, endInclusive)
    }
}

class ColorIterator(val start: CustomColor, val endInclusive: CustomColor) : Iterator<CustomColor> {

    var initValue = start

    override fun hasNext(): Boolean {
        return initValue <= endInclusive
    }

    override fun next(): CustomColor {
        return initValue++
    }
}

fun main(args: Array<String>) {
    val a = CustomColor(0x0)
    val b = CustomColor(0x5)
    val c = CustomColor(0xf)


    val colorRange = a..c
    for (cc in colorRange) {
        println(cc)
    }
//    for(color in a..c){
//        println(color)
//    }
    val range = a..c
    range.toList().size == 10

    println("range : ${range.contains(CustomColor(0x9))}")


    val cr = ColorRange(a,b)

    val ptr = cr.iterator()
    while(ptr.hasNext()){
        println(" next : ${ptr.next().toString()}")
    }
}

/*
import java.awt.Color.MAGENTA
import java.awt.Color.yellow

enum class Color99(val rgb: Int) : Comparable<Color99> {
    BLUE(0x0000FF),
    GREEN(0x008000),
    RED(0xFF0000),
    MAGENTA(0xFF00FF),
    YELLOW(0xFFFF00);

    override fun compareTo(other: Color99): Int {

    }
}

fun main(args: Array<String>) {

    var red = 0xff0000
    var yellow = 0xff00ff
    val range = red..yellow

    if (range.contains(Color99.MAGENTA)) println("true") // Print true
    if (Color.RED in Color.GREEN..Color.YELLOW) println("true") // Print true
    if (Color.RED !in Color99.MAGENTA..Color.YELLOW) println("true") // Print true



    for (c in Color.BLUE.rangeTo(Color.YELLOW)) {

        println(c) // for-loop range must have an iterator() method
    }
}*/
