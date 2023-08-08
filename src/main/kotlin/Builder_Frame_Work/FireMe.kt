//package Builder_Frame_Work
//
//import Builder_Frame_Work.Breads.Bagel
//import Builder_Frame_Work.Breads.Bread
//import Builder_Frame_Work.CoreModels.Salt
//import Builder_Frame_Work.Filings.CreamCheese
//import Builder_Frame_Work.Filings.SmokedSalmon
//import Builder_Frame_Work.decorations.Toasted
//import TO_WORK.src.Salt
//import TO_WORK.src.Sandwich
//import TO_WORK.src.SandwichBuilder
//
//fun main()
//{
//
//    val builder: SandwichBuilder
//    var sandwich: Sandwich
//
//    val bread: Bread? = null
//
//    // public CheckBox egg, cress;
////    public Switch salt;
////    public TextView order;
////    public Switch toasted;
////    private RadioButton bagel;
////
////
//
//
//    // public CheckBox egg, cress;
////    public Switch salt;
////    public TextView order;
////    public Switch toasted;
////    private RadioButton bagel;
////
////
//    builder = SandwichBuilder()
//    sandwich = Sandwich() // Creates a platform to hold the Abstraction Layer.
//
//
//    val toast: String
//    var extraKcal = 0
//
//    // Radio button group : Bread
////        if (bagel.isChecked()) {
//
//
//    // Radio button group : Bread
////        if (bagel.isChecked()) {
//    sandwich = builder.build(sandwich, Salt()) // prototype
//
//
//    sandwich = builder.build(sandwich, Bagel())
////        } else {
////            sandwich = builder.build(sandwich, new Bun());
////        }
////
//
//    // Switch : Toasted
//    // if (toasted.isChecked()) {
//    // Not used
//    //        } else {
////            sandwich = builder.build(sandwich, new Bun());
////        }
////
//
//    // Switch : Toasted
//    // if (toasted.isChecked()) {
//    // Not used
//    val t = Toasted(bread)
//    toast = t.getDecoration()
//    extraKcal += t.getDecorationKcal()
//
////        } else {
////            toast = "";
////        }
//    // we can wrp this conditions with template or with state
//    // Check boxes : Filling
////        if (egg.isChecked()) {
//
////        } else {
////            toast = "";
////        }
//    // we can wrp this conditions with template or with state
//    // Check boxes : Filling
////        if (egg.isChecked()) {
//    sandwich = builder.build(sandwich, SmokedSalmon())
////        }
////
////        if (cress.isChecked()) {
//    //        }
////
////        if (cress.isChecked()) {
//    sandwich = builder.build(sandwich, CreamCheese())
////        }
////
////        // Switch : Salt
////        if (salt.isChecked()) {
//    //        }
////
////        // Switch : Salt
////        if (salt.isChecked()) {
//    sandwich = builder.build(sandwich, Salt())
////        }
////
////        // Display output
//    //        }
////
////        // Display output
//    println(
//        StringBuilder()
//            .append("$toast ")
//            .append(sandwich.sandwich)
//            .append("\n")
//            .append(sandwich.kcal + extraKcal)
//            .append(" kcal")
//            .append("\n")
//            .toString()
//    )
//}