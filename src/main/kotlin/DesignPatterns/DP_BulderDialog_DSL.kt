package DesignPatterns


//import org.junit.jupiter.api.Test
import java.io.File
import javax.swing.text.html.HTML.Tag.LI

// Let's assume that Dialog class is provided by external library.
// We have only access to Dialog public interface which cannot be changed.
/*

// https://kotlinlang.org/docs/lambdas.html#instantiating-a-function-type

Book good explination

// https://livebook.manning.com/book/kotlin-in-action/chapter-11/52

Non-literal values of function types with and without a receiver are interchangeable, so the receiver
 can stand in for the first parameter, and vice versa. For instance, a value of type (A, B) -> C can be
 passed or assigned where a value of type A.(B) -> C is expected, and the other way around:

 val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
val twoParameters: (String, Int) -> String = repeatFun // OK

fun runTransformation(f: (String, Int) -> String): String {
    return f("hello", 3)
}
val result = runTransformation(repeatFun) // OK

result = hellohellohello
 */
class Dialog {

    fun setTitle(text: String) = println("setting title text $text")
    fun setTitleColor(color: String) = println("setting title color $color")
    fun setMessage(text: String) = println("setting message $text")
    fun setMessageColor(color: String) = println("setting message color $color")
    fun setImage(bitmapBytes: ByteArray) = println("setting image with size ${bitmapBytes.size}")

    fun show() = println("showing dialog $this")
}
/*

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}
This function takes one parameter named init, which is itself a function. The type of the function is HTML.() -> Unit, which is a function type with receiver. This means that you need to pass an instance of type HTML (a receiver) to the function, and you can call members of that instance inside the function.

The receiver can be accessed through the this keyword:

html {
    this.head { ... }
    this.body { ... }
}
Copied!
(head and body are member functions of HTML.)

Now, this can be omitted, as usual, and you get something that looks very much like a builder already:

html {
    head { ... }
    body { ... }
}
 */
// Builder
class DialogBuilder() {

    // init receives title message image
    // val intPlus: Int.(Int) -> Int = Int::plus
// https://stackoverflow.com/questions/36140791/how-to-implement-builder-pattern-in-kotlin
    // crispp
    // https://kotlinlang.org/docs/type-safe-builders.html#how-it-works

    constructor(init: DialogBuilder.() -> Unit) : this() {
        init()  // calls title message image
    }

    private var titleHolder: TextView?      = null
    private var messageHolder: TextView?    = null
    private var imageHolder: File?          = null

    //  text is passed here to attributes
    fun title(attributes: TextView.() -> Unit) {
        titleHolder = TextView().apply {
            attributes() } // returns this *
    }

    fun message(attributes: TextView.() -> Unit) {
        messageHolder = TextView().apply { attributes() }  // returns this *
    }

    fun image(attributes: () -> File) {
        imageHolder = attributes()  // returns this *
    }

    fun build(): Dialog {
        println("build")
        val dialog = Dialog()

        titleHolder?.apply {
            dialog.setTitle(text)
            dialog.setTitleColor(color)
        }

        messageHolder?.apply {
            dialog.setMessage(text)
            dialog.setMessageColor(color)
        }

        imageHolder?.apply {
            dialog.setImage(readBytes())
        }

        return dialog
    }

    class TextView {
        var text: String = ""
        var color: String = "#00000"
    }
}

//Function that creates dialog builder and builds Dialog
//  init title message  image

fun dialog(init: DialogBuilder.() -> Unit): Dialog =
    DialogBuilder(init).build()


fun main() {

    println("Build dialog")

    val dialog: Dialog =

        dialog {
            title {
                text = "Dialog Title"
            }
            message {
                text = "Dialog Message"
                color = "#FF00FF"
            }
            image {
                File.createTempFile("image", "jpg")
            }
           /*
                  button(caption:"Click me ",onClick = { show(messsage : "Clicked") }
                  button(caption:"Click me ",HAND_IMG, { show(messsage : "Clicked") }

            */


        }

    println("Show dialog")

    dialog.show()


// A break up in simple way
//
//            val s = buildString {
//                this.append("Hello, ")
//                append("World!")
//            }
//            println(s)


    // require usage *******

    val person = Person55(name = "Wayne", firstname = "Sathya padmanabhan")


// ...

}


data class Person55(
    val name: String,
    val firstname: String,
    val year: Int = 1900
) {
    init {
        require(name.isNotBlank()) { "Name is blank" }  // throws an exception
        require(firstname.length > 3) { "Firstname is blank" }  // firstname.isBlnk
        require(year in 1901..2099) { println("Invalid year $year" )}
    }
}

/*
/Users/malsneha/Library/Java/JavaVirtualMachines/corretto-11.0.11/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=52319:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/malsneha/AndroidStudioProjects/A_Kotlin/collections/build/classes/kotlin/main:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk8/1.6.10/e80fe6ac3c3573a80305f5ec43f86b829e8ab53d/kotlin-stdlib-jdk8-1.6.10.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk7/1.6.10/e1c380673654a089c4f0c9f83d0ddfdc1efdb498/kotlin-stdlib-jdk7-1.6.10.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib/1.6.10/b8af3fe6f1ca88526914929add63cf5e7c5049af/kotlin-stdlib-1.6.10.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains/annotations/13.0/919f0dfe192fb4e063e7dacadee7f8bb9a2672a9/annotations-13.0.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-common/1.6.10/c118700e3a33c8a0d9adc920e9dec0831171925/kotlin-stdlib-common-1.6.10.jar DP_Builder_1Kt
Build dialog
build
setting title text Dialog Title
setting title color #00000
setting message Dialog Message
setting message color #333333
setting image with size 0
Show dialog
showing dialog Dialog@337d0578
Hello, World!

Hi.. .!
!

Process finished with exit code 0

class BuilderTest {

    @Test
    fun Builder() {

        println("Build dialog")

        val dialog: Dialog =
            dialog {
                title {
                    text = "Dialog Title"
                }
                message {
                    text = "Dialog Message"
                    color = "#333333"
                }
                image {
                    File.createTempFile("image", "jpg")
                }
            }

        println("Show dialog")

        dialog.show()
    }
}
 */

/*
       verticalLayout( verticalLayout = true , margine_width = wrap_content ,....) {
       tabSheeet {
          tab( caption: "Button",HAND_IMG) {

            horizontalLayout( margine_width = wrap_content, margine_height = wrap_conyent {
                 button()
                 button(caption:"Lable")
                 button(caption:"Lable",HAND_IMG)
                 button(caption:"Click me ",onClick = { show(messsage : "Clicked") }
                 button(caption:"Click me ",HAND_IMG,{ show(messsage : "Clicked") }
                   // end Button
                 }
             }
          }

        */