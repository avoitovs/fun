import scala.io.StdIn


trait StringProcessor {
  def process(input: String): String
}


object Traits extends App {


  val tokenDeleter = new StringProcessor {
    val regex = "/W+/g"
    override def process(input: String): String = input.replaceAll(regex, "")
  }

  val shortener = new StringProcessor {
    override def process(input: String): String = if (input.length > 20) s"${input.take(20)}..." else input
  }

  val toLowerConvertor = new StringProcessor {
    override def process(input: String): String = input.toLowerCase
  }


  val input = StdIn.readLine()

  val x = toLowerConvertor.process(input)
  val z = tokenDeleter.process(x)
  val y = shortener.process(z)

  println(y)

}
