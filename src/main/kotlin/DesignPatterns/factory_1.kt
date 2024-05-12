package DesignPatterns


/*
    Why and where to use which Pattern?

    User is waiting for the food.. Observer  Will reg the user as well as the kitchen when the food is ready user is notifyed


 */

enum class DocumentType { Drawing, Word }

interface Document {
    fun ShowDocumentInfo()
}

class DrawingDocument : Document{
    override fun ShowDocumentInfo() {
        println("This is a drawing Document...")
    }

}

class WordDocument : Document {
    override fun ShowDocumentInfo() {
        println("This is a  Word  Document...")
    }

}


class DrawingApplication : Application() {
    override fun createDocument() =  DrawingDocument()

}


class WordApplication : Application() {
    override fun createDocument() =  WordDocument()

}



// Android has an Application class by Default..

abstract class Application{

    abstract fun createDocument() : Document


    // Singleton is what got converted as companion object in Kotlin

    companion object  {   // single object so that my factory will not be churning out new objects every time when it gets called

    fun getApplicationDocument( documentType: DocumentType) : Application {


            return  when ( documentType )
            {
                DocumentType.Drawing -> DrawingApplication()
                DocumentType.Word    -> WordApplication()
                else -> throw Exception("Invalid document")
            }
        } // Application closure
    }//   companion object

}

fun main(){

    QueryObject(DocumentType.Word)
    QueryObject(DocumentType.Drawing)


}

private fun QueryObject(docWordDrawing: DocumentType) {
    val drawingApplication = Application.getApplicationDocument(docWordDrawing)
    val drwaingDocument = drawingApplication.createDocument()
    drwaingDocument.ShowDocumentInfo()
}