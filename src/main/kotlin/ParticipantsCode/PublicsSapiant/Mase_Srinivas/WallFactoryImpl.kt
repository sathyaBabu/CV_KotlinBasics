
class Wall : MapSite()
{
    override fun enter() {

        println("You entered the wall! OOPS your nose is broken")

    }
}

class WallFactoryimpl() : WallFactory() {

 override fun enter() {

        println("you entered into the wall OOPS your nose is broken")
 }
}


// Abstraction layer
// he is the provider of CITI_BANK and HDFC_BANK idf thats the case CITIBankFactory()
// has to be a dependency ( has to injected )
abstract class WallFactory : MapSite(){
    abstract override fun enter()

    //  abstract  fun createBankLoan() : BANK_RBI_LOAN
    //  make the abstract class RBIbank_factory  as a SingleTon
    companion object {
        // T has a problem? it cannot reinterpret the cast
        //                                  queryFactory()
        inline fun < reified T : MapSite>createFactory() : WallFactory =
            when( T::class) {

                Wall::class  -> WallFactoryimpl()

                else -> throw IllegalArgumentException()
            }
    }

}


