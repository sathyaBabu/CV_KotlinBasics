package Builder_Frame_Work.CoreModels

import Builder_Frame_Work.Filings.Ingredient


class Salt : Ingredient {
    override fun description(): String {
        return "Salt"
    }

    override fun kcal(): Int {
        return 0
    }
}
