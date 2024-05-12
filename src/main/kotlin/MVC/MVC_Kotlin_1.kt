package MVC

// MVC

//     Model   View        Controller
//     Observer also --> When the data changes the same is displayed on view..

//     Data    print       in turn knows about the model and view
//     model or view dosent know each other..

// MVP   MV VM( Android )
// 2 Assignments
// 1  Bring in jet air concept gere ( interface )
// model as user ( a,b,c,d,e )   JtAir ( Controller )
// let all the model reg with controller
// when ever the model changes controller will pick the data from the model and display the sam ein the view
// every model has its view
// many model has one view
/*

View displaying data as follows.. many model has one view

    Model A

     Model b


      Model c

        Model d


 */





//  2 Model A,b,c,d


class Model{
    var rollNo : String? = null
    var name : String ? = null
}

///data class  Model_D( val rollNo : String, val name : String)

class  View {
    fun displayData(name : String , rollNumber : String){
        println(" Student information..")
        println(" Name : $name")
        println(" Roll no : $rollNumber")
    }
}

class Controller( model:Model ,view:View){

    private  var model : Model  // many Array or mutableListOf
    private  var view : View    // many


    // not the way we registered it in jet air ( mutableListOf< iINTERFACE >   )
    // notify()

    init{
        this.model = model
        this.view = view
    }

    // Getter's and setters are out dated in kotlin
    // Think of a better way to implement the following code...
//
//    set(){
//
//    }
//    get(){
//
//    }

    fun setName( name : String){
        model.name = name
    }
    fun setRollno( rollNumber : String){
        model.rollNo = rollNumber
    }

    fun getName() : String? {
        return  model.name
    }
    fun getRollno() : String? {
        return model.rollNo
    }

    fun updateView() {

        getName()?.let{
            getRollno()?.let {
                    it1 ->view?.displayData(it, it1)
                // view?.displayData(model.name,model.rollNo)
            }
        }

    }


}

// concrete class
fun main()
{
    val model = retriveDataFronDB()

    val view = View()


    val controller = Controller(model,view)

    controller.updateView()

    controller.setName("Sathya")
    controller.setRollno("9876")

    // please automate the data change
    controller.updateView()


    controller.setName("Swami")
    controller.setRollno("1155")

    // please automate the data change
    controller.updateView()



}

fun retriveDataFronDB(): Model {

    // convert this to get() and set()


    val student = Model()
    student.name = "Shifa"
    student.rollNo = " 1234"

    return  student

}
/*

Out put :

 Student information..
 Name : Shifa
 Roll no :  1234
 Student information..
 Name : Sathya
 Roll no : 9876
 Student information..
 Name : Swami
 Roll no : 1155

Process finished with exit code 0

 */