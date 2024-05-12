package Class


class StudentData(var name : String, var age : Int){
    init{
        noofStudents += 1 ;
    }

    companion object StudentsStats{

        private  var  noofStudents : Int = 0 ;
        fun getStudentRefCount() : Int = noofStudents

        val COLLEGE_NAME = "St Joseph"
    }
}




fun main()
{
    var student1 = StudentData("Aameer",29)
    println(StudentData.getStudentRefCount())

    var student2 = StudentData("Swapnil",39)
    println(StudentData.getStudentRefCount())

    println(StudentData.COLLEGE_NAME)


}