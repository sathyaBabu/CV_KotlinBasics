package Builder_Frame_Work.Breads

import Builder_Frame_Work.Filings.Ingredient


abstract class Bread : Ingredient {
    open var decoration: String? = null
    open var decorationKcal = 0
}
