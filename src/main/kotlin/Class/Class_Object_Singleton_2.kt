package Class

class StudentData(var name: String, var age: Int) {
    init {
        noOfStudents += 1
    }

    // can't be just an object without companion

    companion object StudentStats {
        private var noOfStudents : Int = 0
        fun getStudentCount():Int = noOfStudents
        val SCHOOL_NAME = "St Joseph"
    }

}

fun main() {
// accessing static methods (which uses private variable)
    var student1 = StudentData("Virupaksh", 18)
    println(StudentData.getStudentCount())

    var student2 = StudentData("Suresh", 18)
    println(StudentData.getStudentCount())

// accessing static parameter
    println(StudentData.SCHOOL_NAME)
}