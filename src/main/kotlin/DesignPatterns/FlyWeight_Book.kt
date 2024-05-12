package Assignment_Application



// Flyweight
interface Glyph{

    fun create(char:Char, font : String, glyphContext: GlyphContext){}
    fun setFont(font: Font, glyphContext: GlyphContext)
    fun getFont(data: Int)
    fun insert(glyph: Glyph, glyphContext: GlyphContext)
}

open class Font(font : String){

    var font_style : String = font
    open val root : Node? = null
    open var flag : Boolean = true

    open fun getFont(data: Int){

    }

}

class GlyphContext(font: String) : Font(font) {

    val _fonts = BinaryTree()
    override val root = Node(0)
    override var flag : Boolean = true

    // insert() inserts number(length of substring) into binary tree with it's font

    fun insert( quantity : Int = 1, font : Font){

        setFont(font)
        println("Inserted $quantity..!!!" )
        _fonts.insert(this.root, quantity, font)
    }

    fun find(searchedValue: Int): Node? {
        var current: Node? = root
        while (current!!.value != searchedValue) {
            current = if (searchedValue < current.value) // Move to the left if searched value is less
                current.left else  // Move to the right if searched value is >=
                current.right
            if (current == null) {
                return null
            }
        }
        return current
    }
    // getFont fetches font from Font that stores the glyph-to-font mapping.
    override fun getFont(data: Int) {
        val node : Node? = find(data)
        println("Font style for $data is ${_fonts.map.get(data)}")
    }

    fun setFont(font: Font, span : Int = 1){
        println("Font is set to ${font.font_style} font with span of $span")
    }

}

// ConcreteFlyweight
class Character(char : Char): Glyph {

    var _charcode : Int = 0
    var font_style : String? = null

    override fun create(char: Char, font: String, glyphContext: GlyphContext) {

            when(char){
                'a' -> _charcode = 97 'b' -> _charcode = 98  'c' -> _charcode = 99
                'd' -> _charcode = 100 'e' -> _charcode = 101 'f' -> _charcode = 102
                'g' -> _charcode = 103 'h' -> _charcode = 104 'i' -> _charcode = 105
                'j' -> _charcode = 106 'k' -> _charcode = 107 'l' -> _charcode = 108
                'm' -> _charcode = 103 'n' -> _charcode = 104 'o' -> _charcode = 105
                'p' -> _charcode = 106 'q' -> _charcode = 107 'r' -> _charcode = 108
                's' -> _charcode = 109 't' -> _charcode = 110 'u' -> _charcode = 110
                'v' -> _charcode = 112 'w' -> _charcode = 113 'x' -> _charcode = 114
                'y' -> _charcode = 115 'z' -> _charcode = 116
        }
       println("Font style set to $font and charcode of $char is $_charcode")
    }

    override fun setFont(font: Font, glyphContext: GlyphContext) {
        println("Font set to $font")
    }

    override fun getFont(data: Int) {

    }

    override fun insert(glyph: Glyph, glyphContext: GlyphContext) {

    }

}

// UnSharedConcreteFlyweight
class Row : Glyph{
    override fun create(char:Char, font: String, glyphContext: GlyphContext) {
        println("Font style set to $font in Row")
    }
    override fun setFont(font: Font, glyphContext: GlyphContext) {
        println("Font set to $font")
    }
    override fun getFont(data: Int){

    }
    override fun insert(glyph: Glyph, glyphContext: GlyphContext) {
        println("Inserted")
    }
}

// UnSharedConcreteFlyweight
class Column : Glyph{
    override fun create(char: Char, font: String, glyphContext: GlyphContext) {
        println("Font style set to $font in Column")
    }

    override fun setFont(font: Font, glyphContext: GlyphContext) {
        println("Font set to $font")
    }

    override fun getFont(data: Int){

    }

    override fun insert(glyph: Glyph, glyphContext: GlyphContext) {
        println("Inserted")
    }
}


// FlyweightFactory
class GlyphFactory {

    var NCHARCODES : Int = 128
    var _character = ArrayList<Char>()      // Flyweight Pool

    fun createCharacter(char : Char, font: Font) {

        // Initially adding a, b  and c to flyweight pool
        if(!_character.contains('a')){ _character.add('a')}
        if(!_character.contains('b')){ _character.add('b')}
        if(!_character.contains('c')){ _character.add('c')}


        // Checks whether required character is present in flyweight pool or not...
        // If not present then a new Flyweight object is created and added to flyweight pool
        // If present then the object from the flyweight pool is called


        if(!_character.contains(char)) {
            println("$char -> added in flyweight pool..")
            val addedchar : Glyph = Character(char)
            _character.add(char)
            addedchar.create(char,font.font_style, glyphContext = GlyphContext(font.font_style))
        }
        else {
            println("$char -> present in flyweight pool..")
            Character(char).create(char,font.font_style, glyphContext = GlyphContext(font.font_style))
        }
    }


    fun createRow() : Row{
        return Row()
    }
    fun createColumn() : Column{
        return Column()
    }
}

class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
    var font : Font? = null
}

open class BinaryTree{

    var root: Node? = null
    val map : MutableMap<Int, String>
    init {
        map = HashMap()
    }
    open fun insert(node: Node?, value: Int,font: Font): Node? {

        map.put(value, font.font_style)

        if (node == null) {
            node?.font = font
            return Node(value)
        }
        if (value < node.value) {
            node.left = insert(node.left, value, font)
        } else if (value > node.value) {
            node.right = insert(node.right, value, font)
        }
        return node
    }
}


fun main(){

    val gc = GlyphContext(" ")
    val times12 = Font("Times-Roman-12")
    val timesItalic12 = Font("Times-Italic-12")
    val timesBold12 = Font("Times-12-Bold")

    gc.insert(6, times12)
    println("--".repeat(50))
    gc.insert(90, timesItalic12)
    println("--".repeat(50))
    gc.insert(45, timesBold12)
    println("--".repeat(50))
    gc.insert(34, timesItalic12)
    println("--".repeat(50))
    gc.insert(98, times12)
    println("--".repeat(50))

    gc.getFont(6)
    gc.getFont(98)
    gc.getFont(30)
    gc.getFont(50)
    gc.getFont(34)
    gc.getFont(45)
    println("--".repeat(50))

    val glyphFactory = GlyphFactory()
    glyphFactory.createCharacter('a', times12)
    println("--".repeat(50))
    glyphFactory.createCharacter('e', timesBold12)
    println("--".repeat(50))
    glyphFactory.createCharacter('k', timesItalic12)
    println("--".repeat(50))
    glyphFactory.createCharacter('c', times12)
    println("--".repeat(50))
    glyphFactory.createCharacter('v', timesBold12)
    println("--".repeat(50))

}

/*
Font is set to Times-Roman-12 font with span of 1
Inserted 6..!!!
----------------------------------------------------------------------------------------------------
Font is set to Times-Italic-12 font with span of 1
Inserted 90..!!!
----------------------------------------------------------------------------------------------------
Font is set to Times-12-Bold font with span of 1
Inserted 45..!!!
----------------------------------------------------------------------------------------------------
Font is set to Times-Italic-12 font with span of 1
Inserted 34..!!!
----------------------------------------------------------------------------------------------------
Font is set to Times-Roman-12 font with span of 1
Inserted 98..!!!
----------------------------------------------------------------------------------------------------
Font style for 6 is Times-Roman-12
Font style for 98 is Times-Roman-12
Font style for 30 is null
Font style for 50 is null
Font style for 34 is Times-Italic-12
Font style for 45 is Times-12-Bold
----------------------------------------------------------------------------------------------------
a -> present in flyweight pool..
Font style set to Times-Roman-12 and charcode of a is 97
----------------------------------------------------------------------------------------------------
e -> added in flyweight pool..
Font style set to Times-12-Bold and charcode of e is 101
----------------------------------------------------------------------------------------------------
k -> added in flyweight pool..
Font style set to Times-Italic-12 and charcode of k is 107
----------------------------------------------------------------------------------------------------
c -> present in flyweight pool..
Font style set to Times-Roman-12 and charcode of c is 99
----------------------------------------------------------------------------------------------------
v -> added in flyweight pool..
Font style set to Times-12-Bold and charcode of v is 112
----------------------------------------------------------------------------------------------------

Process finished with exit code 0

 */