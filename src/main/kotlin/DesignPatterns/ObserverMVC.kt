package day8

abstract class ObserverMVC {
    protected var subj: SubjectMVC? = null
    abstract fun Update()
}

class SubjectMVC {
    protected val observers = arrayOfNulls<ObserverMVC>(9)

    private var totObjects = 0
    var state = 0
        // set
        set(changedIntValue) {
            field = changedIntValue
            // state change alert
            notifyMe()
        }


    @JvmName("getState1")
    fun getState(): Int {
        return state
    }

    // Attach
    fun attach(observer: ObserverMVC) {

        observers[totObjects++] = observer
        println(" Attached : processing the data STATE  busy... $totObjects")
    }


    // detach
    fun detach() {
        println(" Your turn to  implement the detach functionality here...")
    }

    // notifyMe
    fun notifyMe() {

        for (regUsers in 0 until totObjects)
            observers[regUsers]?.Update()
    }

}

// Model
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

class Controller_Student2(model: MODEL_Student2, view: VIEW_Student2, subjectMVC: SubjectMVC) : ObserverMVC() {
    private var model: MODEL_Student2
    private var view: VIEW_Student2? = null

    init {
        this.model = model
        this.view = view
        subj = subjectMVC
        subjectMVC.attach(this)
    }

    fun setStudentName(name: String) {
        model.name = name
        subj?.state = subj?.state!! + 1
    }

    fun getStudentName(): String? {
        return model.name
    }

    fun setStudentRollNo(rollno: String) {
        model.rollNo = rollno
        subj?.state = subj?.state!! + 1
    }

    fun getStudentRollNo(): String? {
        return model.rollNo
    }

    fun updateView() {

        println("Update View Called .....")
        getStudentRollNo()?.let {
            getStudentName()?.let { it1 -> view?.printStudentDetails(it1, it) }
        }
        // view?.printStudentDetails(model.name,model.rollNo)
    }

    override fun Update() {
        println("Update from observer called .....")
        println("View is notified")
        updateView()
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
    val subject = SubjectMVC()
    val controller = Controller_Student2(model, view, subject)

    // Following line will go after you bring in Delegates.observer
//    controller.updateView()

    controller.setStudentName("Sandeep S ") // model gets called..
    controller.setStudentRollNo("102")

    // data in model has changed.. so call the updateview..
    // OUR OBSERVER SHALL CALL UpdateView
    // Following line will go after you bring in Delegates.observer
//    controller.updateView()

    //update model data   Pranav to model... Hold the name and the roll number
    controller.setStudentName("Pranav")
    controller.setStudentRollNo("201")

    // Following line will go after you bring in Delegates.observer
//    controller.updateView()
}


private fun retriveStudentFromDatabase(): MODEL_Student2 {
    val student = MODEL_Student2()
    student.name = "Sandeep"     //set( value)  field = "Sandeep" //gets called...
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