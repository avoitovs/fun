import scala.io.StdIn

object Extract extends App {



  val text = StdIn.readLine()

  println(text match {
    case FacedString(s) => s
    case _ => "Could not recognize string"
  })


}

object FacedString {
  def apply(input: String) = s"*_*$input*_*"

  val mask = "\\*_\\*(.*)\\*_\\*".r

  def unapply(arg: String): Option[String] = arg match {
    case mask(x) => Some(x)
    case _ => None
  }

}