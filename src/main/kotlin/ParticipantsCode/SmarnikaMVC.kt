import kotlin.properties.Delegates

//********************************* MODEL_Student2 Class *********************************************

class MODEL_Student2 {


    var rollNo: String? = null
    var name: String?   = null
}

//********************************* VIEW_Student2 class **********************************************

class VIEW_Student2 {
    fun printStudentDetails(studentName: String, studentRollNo: String) {
        println("Student information : ")
        println("Name: $studentName")
        println("Roll No: $studentRollNo")
    }
}


//********************************** Controller_Student2 class ******************************************


class Controller_Student2(private var model: MODEL_Student2, private var view: VIEW_Student2) {

    //giving the name and rollno to view
    init {
        view.printStudentDetails(model.name!!, model.rollNo!!)
    }


    //storing the model.name and model.rollno in a variable
    var prevName    = this.model.name
    var prevRollno  = this.model.rollNo



    var updateName: String by Delegates.observable(prevName.toString()){
            property, oldValue, newValue ->  view.printStudentDetails("$newValue",prevRollno.toString())
    }
    var updateRollno: String by Delegates.observable(prevRollno.toString()){
            property, oldValue, newValue ->  view.printStudentDetails(updateName.toString(),"$newValue")
    }

}

//**********************************************  MAIN *********************************************************
fun main() {

    //fetch student record based on his roll no from the database
    val model = retriveStudentFromDatabase()

    //Create a view : to write student details on console
    val view = VIEW_Student2()

    //creating object of the Controller_Student2 class
    val controller = Controller_Student2(model, view)

    //here we are updating the model.name to Sam and the rollno to 786
    controller.updateName = "sam"
    controller.updateRollno = "786"


}


private fun retriveStudentFromDatabase(): MODEL_Student2 {
    val student = MODEL_Student2()
    student.name="Sandeep"
    student.rollNo="101"
    return student
}


