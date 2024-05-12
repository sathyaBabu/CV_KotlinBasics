package Prototype

class Book {
    var bid = 0
    var bname: String? = null

    override fun toString(): String {
        // TODO Auto-generated method stub
        return "Book [bid = $bid, bname = $bname]"
    }
}


// as phase II lets clone this BookShop
class BookShop : Cloneable {
    private var shopName: String? = null

    //productManager
    var books: MutableList<Book> = ArrayList()

    fun setShopName(shopName: String?) {
        this.shopName = shopName
    }

    fun setShopName(): String? {
        return shopName
    }

    //productManager
    fun loadData() {
        for (i in 1..10) {
            val b = Book()
            b.bid = i
            b.bname = "Book $i"
            books.add(b)
        }
    }

    //	public Object getBooks() {
    //		// TODO Auto-generated method stub
    //		return null;
    //	}
    override fun toString(): String {
        // TODO Auto-generated method stub
        return "Book Shop [ ShopName = $shopName, books = $books]"
    }

  //  @Throws(CloneNotSupportedException::class)
    public override fun clone(): BookShop {
        // TODO Auto-generated method stub
        //return super.clone();
        // This returns a deep copy back to the main code
        val shop = BookShop()
        for (b in books) {
            shop.books.add(b)
        }
        return shop
    } //	@Override
    //	public Object clone() throws CloneNotSupportedException {
    //		// TODO Auto-generated method stub
    //		return super.clone();
    //	}
}

fun main() {
    // TODO Auto-generated method stub
    val bs = BookShop()
    bs.setShopName("Sapna")
    bs.loadData()
    //		// add the following line after cloning the BookShop
//		bs.getBooks().remove(2);  // 3rd book is deleted
//		System.out.println(bs);


    // cache - prototype has not come in so far
    //		BookShop bs1 = new BookShop();//bs.clone();
    //		bs1.setShopName("MyCache");
    //		bs1.loadData(); // return the books
    //		System.out.println(bs1);


    // cache - prototype we made BookShop implements Cloneable
    // then we got clone method overide
    // basic Cloning creates a shalow copy bs as well as bs1 displays the same data
    // after adding this line above 	bs.getBooks().remove(2);  // 3rd book is deleted

    // lets look towards deep cloning which will not alrer other cloned data like shallow clone

    // phase II following is for shalow cloning
    //	BookShop bs1 = (BookShop)bs.clone(); // cznt use since this is declared as protected
    //  lets prepare for deep cloning
    val bs1 = bs.clone() // clone return type is marked as BookShop
    bs1.setShopName("MyCache")
    // add the following line after cloning the BookShop
    bs.books.removeAt(2) // 3rd book is deleted
    //	bs1.loadData(); // return the books
    println(bs)
    println(bs1)
}


