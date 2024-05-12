package Class

//package DesignPatterns

/*

Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
***** KEY *****
Template Method lets subclasses redefine certain steps of an algorithm without changing
the algorithm's structure.

????? Template Method  ???????

Image processing ALGO

operation(){

// to make a cup of Tea/ Coffee Image processing // graph
// we cant revamp the functions which we see below


//  without changing
//the algorithm's structure.

// -------> Template Method   <---------------------

     a()
     b()
     z()
     f()
     k()

}


// lets subclasses
// Sub class... light weight image processor..
class CarImageProcessing{

  // b()  need a change b   ---> redefine certan steps in the sub calss..
  // k()  so as need a change in k
}
 */
/*
  My version of understanding goes here....


 */
// Lets make a cup of Tea / Coffee...

// Super class  ABS class
/*

boil()
brew()
addCondiments()
serve()

 */





// Sub classs  brew maker.. Tea coffee...
/*

    brew()    // Tea/ Coffee..
    addCondiments()   // Sugar Hone Lemon.. Cinamum..

 */

abstract  class MakeBeverage{     // MEdia Player..

    // This functions are ment to be reused by the implementor..

    // 2 deferring some steps to subclasses
    abstract  fun addCondiments()       //  PLAY() wifi().. MOBILENETWORK   SAVED DATA
    abstract  fun brew()                //   POWER //  BATTERY..

    fun boilWater(){                     // STARTTHEPLAYER()
        println("Boil water to 180 c for 5 min ")
    }
    fun serve(){                          // SELLECT A SONG..
        println("Pour it in Mug...")
    }


    // Template method is the operation
    // 1. Define the skeleton of an algorithm in an operation,

    // Builder( Director )  VS Template both hide the order of Algo..
//    Phase II


    fun prepare(){

        boilWater()                                   // startThePlayer()
        brew()                                        // selectPower()
        addCondiments()                               // switchWIFI()
        serve()                                       // select a song

    }


}
// 3. Template Method lets subclasses redefine certain steps of an algorithm without changing
//the algorithm's structure.

class Coffee : MakeBeverage(){
    override fun addCondiments() {
        println("Milk.")
    }

    override fun brew() {
        println("Add fresh rosted..Mexican Coffee .. ")
    }

}

class Tea : MakeBeverage(){
    override fun addCondiments() {
        println("Add Lemon")
    }

    override fun brew() {
        println("Steaping the tea bags..")
    }

}

fun main(){

//
//    val makeBewrage : MakeBeverage = Tea()
//    makeBewrage.prepare() //  // 1. Define the skeleton of an algorithm in an operation,
//    // It's Coffee Days..secrete ALGO in the operation
//
//    println("*".repeat(50))
//
//    val makeBeverageCoffee : MakeBeverage = Coffee()
//    makeBeverageCoffee.prepare()


    // Phase I
    val makeBewrage : MakeBeverage = Tea()
    makeBewrage.boilWater()                                   // startThePlayer()
    makeBewrage.brew()                                        // selectPower()
    makeBewrage.serve()
    makeBewrage.addCondiments()                               // switchWIFI()
    // select a song
   // makeBewrage.prepare()      // template gets you out of the clutter!!!
    println("*".repeat(50))
   // makeBewrage.prepare()  // template gets you out of the clutter!!!
}
//Boil water to 180 c for 5 min
//Steaping the tea bags..
//Pour it in Mug...
//Add Lemon
//**************************************************



/*
Async


    @Override
    public void onClick(View v) {

        // AsyncThread gets executed only once..   new MyAsync().execute("sathya");

        new MoviewDownloadTask().execute(URL);  // about to fire the Async task...




    }

   // @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)   :  AsyncTask<String, Void, String> {
    class MoviewDownloadTask extends AsyncTask<String, Void, String> {

        protected void onPreExecute() {

            // we are still in UI thread...

        }

        // Sec. thread.... ( Non UI Thread...  )
        @Override
        protected String doInBackground(String[] params) {



                Log.d("tag"," JSON : "+stringBuilder.toString());



                return "Hello there ".toString();


        }


        @Override
        protected void onProgressUpdate(Void... values) {  // Variable number of arguments... Stuct   struct



            super.onProgressUpdate(values);
        }

        // we are in UI THread
        @Override
        protected void onPostExecute(String response) {
           progressBar.setVisibility(View.GONE);

            // U r in Ui Thread
            if (response != null) {
                parseJsonResponse(response);
            }
        }
    }

    private void parseJsonResponse(String response) {


    }

 */