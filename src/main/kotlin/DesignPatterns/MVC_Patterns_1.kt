package DesignPatterns



open  class ATM_Machine{

    var cashInTheMachine : Double = 50000.00

    fun getContext() : Any {
        return  this
    }
    fun getCash(cash:Double) : Double{
        return  3400.00
    }
    fun setCash(cash:Double) {

    }

    fun someFun(cash:Double) {

    }


}

////   interface Proxy
// shouls identify from which obj getCash is called from( who is the user AC/id )

// implement getCash() return the cash from the user object



//  when user asks for  getContext() do not return this return  a pointer to someFun() /what he needs at that point  / value / fun /

class User : ATM_Machine() {

//    getCash( 50000.00)
   //  getContext().--> exposses all the function from the ATM Machine
}






class MODEL_Student2 {
    var rollNo: String? = null
    var name: String? = null
}

class VIEW_Student2 {
    fun printStudentDetails(studentName: String, studentRollNo: String) {
        println("Student information : ")
        println("Name: $studentName")
        println("Roll No: $studentRollNo")
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

    fun updateView() {

        getStudentRollNo()?.let { getStudentName()?.let { it1 -> view?.printStudentDetails(it1, it) } }
      // view?.printStudentDetails(model.name,model.rollNo)
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
        controller.updateView()

        controller.setStudentName("Sandeep S ") // model gets called..
        controller.setStudentRollNo("102")

        // data in model has changed.. so call the updateview..
        // OUR OBSERVER SHALL CALL UpdateView

        // Following line will go after you bring in Delegates.observer
        controller.updateView()

        //update model data   Pranav to model... Hold the name and the roll number
        controller.setStudentName("Pranav")
        controller.setStudentRollNo("201")

        // Following line will go after you bring in Delegates.observer
        controller.updateView()
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
