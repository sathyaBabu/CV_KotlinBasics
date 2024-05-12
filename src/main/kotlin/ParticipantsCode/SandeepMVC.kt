package ParticipantsCode



//weight gets to be live from now on.
//    var weight: Int by Delegates.observable(2000){
//        property, oldValue, newValue ->  println("Old value $oldValue New value $newValue")
//    }


import kotlin.properties.Delegates


class MODEL_Student2 {
    var rollNo: String? = null
    var name: String? = null
}

class VIEW_Student2 {

    fun printStudentDetails(studentName1: String,studentName2: String) {
        println("Student information : ")
//        println("Name: $studentName1")
        println("changed from old_name:$studentName1  to new_Name:$studentName2")
    }
    fun printStudentDetails1(Rollnumber1: String,Rollnumber2: String) {
//        println("Roll: $Rollnumber1")
        println("changed from old_Roll_number:$Rollnumber1 to  new_Roll_number:$Rollnumber2")
    }

}
class Controller_Student2(model:MODEL_Student2,view:VIEW_Student2) {
    private var model: MODEL_Student2
    private var view: VIEW_Student2? = null

    init {
        this.model = model
        this.view = view
    }

    fun setStudentName(name: String) {
        model.name = name
    }

    fun getStudentName(): String? {
        return model.name
    }

    fun setStudentRollNo(rollno: String) {
        model.rollNo = rollno
    }

    fun getStudentRollNo(): String? {
        return model.rollNo
    }

    var name:String by Delegates.observable("Sandeep"){
            property, oldValue, newValue  ->  view.printStudentDetails(oldValue,newValue)
    }
    var roll:String by Delegates.observable("101"){
            property, oldValue, newValue  ->  view.printStudentDetails1(oldValue,newValue)
    }

}
// 1 implimeant the same using kotlin
// 2 Delegats.Observer to the same

fun main() {
    // write your code here
    //fetch student record based on his roll no from the database
    val model = retriveStudentFromDatabase()

    //Create a view : to write student details on console
    val view = VIEW_Student2()
    val controller = Controller_Student2(model, view)

    // Following line will go after you bring in Delegates.observer





//    controller.setStudentName("Sandeep S ") // model gets called..
//    controller.setStudentRollNo("102")

    // data in model has changed.. so call the updateview..
    // OUR OBSERVER SHALL CALL UpdateView

    // Following line will go after you bring in Delegates.observer
//    controller.updateView()



    //update model data   Pranav to model... Hold the name and the roll number
    println("enter the number of times user want to input details:")
    var loop:Int= readln().toInt()
    for(i in 1..loop) {
        println("enter name to input:")
        var name = readln()
        println("enter roll_number to input:")
        var roll = readln()

        controller.setStudentName(name)
        controller.setStudentRollNo(roll)
        controller.name = controller.getStudentName().toString()
        controller.roll = controller.getStudentRollNo().toString()
    }
//    controller.setStudentName("sruti")
//    controller.setStudentRollNo("102")
//    controller.name=controller.getStudentName().toString()
//    controller.roll=controller.getStudentRollNo().toString()
//
//    controller.setStudentName("sricharan")
//    controller.setStudentRollNo("202")
//
//    controller.name=controller.getStudentName().toString()
//    controller.roll=controller.getStudentRollNo().toString()

//    controller.name=controller.getStudentName().toString()
//    controller.roll=controller.getStudentRollNo().toString()
//
//    controller.name=controller.getStudentName().toString()
//    controller.roll=controller.getStudentRollNo().toString()


    // Following line will go after you bring in Delegates.observer



}





private fun retriveStudentFromDatabase(): MODEL_Student2 {
    val student = MODEL_Student2()
    student.name="Sandeep"     //set( value)  field = "Sandeep" //gets called...
    student.rollNo = "101"
    return student
}

//
//    private fun retriveStudentFromDatabase(): MODEL_Student2 {
//        val student = MODEL_Student2()
//        student.setName("Sandeep")
//        student.setRollNo("101")
//        return student
//    }


// first of all i need to change the updateView to Delegates.observer for that i need to delete the updateView function
// After that i need to take care of the oldvalue and newvalue. i created two variables like roll and name to get roll number and name from the main function
// i intialized Delegates.observer with null and then i have to split the print function into to differnt function so that i can keep the track of both name and roll number
//then from the main function i called the Delegates.observer with object of controller2 class and provided the different name and roll number to it and check the output