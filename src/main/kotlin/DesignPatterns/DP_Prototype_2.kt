interface ReportItemPrototype {

    fun clone(): ReportItemPrototype

}
class TextItem : ReportItemPrototype {

    var text: String? = null

    var color: String? = null



    constructor() {}



    constructor(source: TextItem) {

        this.text = source.text

        this.color = source.color

    }



    fun initializeText(newText: String, newColor: String) {

        this.text = newText

        this.color = newColor

    }



    override fun clone(): TextItem {

        return TextItem(this)

    }



}
class ImageItem : ReportItemPrototype {

    var url: String? = null

    var width: Int? = null



    constructor() {}



    constructor(source: ImageItem) {

        this.url = source.url

        this.width = source.width

    }



    override fun clone(): ImageItem {

        return ImageItem(this)

    }

}

class Report {

    fun printReport(reportItems: MutableMap<String, ReportItemPrototype>) {

        reportItems.forEach {

            if (it.value is TextItem) {

//                console.log(
                  println(
                    "${it.key} TextItem"

                )

            } else if (it.value is ImageItem) {

              //  console.log(
                    println(
                    "${it.key} ImageITem"

                )

            }

        }

    }

}
fun main() {

    val report = Report()

    val reportItems: MutableMap<String, ReportItemPrototype> = mutableMapOf()





    val text = TextItem()

    text.text = "Normal text"

    text.color = "Black"

    reportItems["Normal text"] = text



    val image = ImageItem()

    image.url = "/image/url"

    image.width = 100

    reportItems["Normal image"] = image



    report.printReport(reportItems)



///////////////////////////////////////////////



    val redText = text.clone()

    redText.initializeText("Red text", "Red")

    reportItems["Red text"] = redText



    val secondImage = image.clone()

    reportItems["Second image"] = secondImage



    println("\n \n Updated report")

    report.printReport(reportItems)

}



