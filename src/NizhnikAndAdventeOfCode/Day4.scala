object Day4 extends App {

  /*
    val reg = "^[a-z]([a-z]*_?[a-z]+)*[a-z]?$".r

    val x = StdIn.readLine()

   println(x.matches(reg.regex))

  */
  /** *
    * Известно, что все, кто говорит "meow" или "nya" - кошки,
    * все, кого зовут "Rex" - собаки,
    * а цифры "0" или "1" в строке says есть только у роботов.
    * (Кошек и роботов не могут звать "Rex", собаки не мяукают)
    *
    *
    * Используя pattern-matching, определите вид питомца в переменной pet. Выведите "cat" для кошек, "dog" для собак, "robot" для роботов и "unknown" иначе.
    */

  /*
    val number = StdIn.readInt()

    for {
      first <- 1 until number
      second <- 1 until number if BigInt(second).gcd(first) == 1
    } println(s"$first $second")

  */
  /*
    println(Right(1).flatMap(_ => Left(2)).flatMap(_ => Left(3)))

    case class Pet(name: String, says: String)

    val pet = Pet("Resx", "meow")

    val dog = "[^.*(0|1).*]".r
    val saysMeowOrNja = "(meow|nya)".r
    val says0or1 = "[(0|1)+]".r

    //says0or1.

    val kind = pet match {
      case Pet("Rex", _) => "dog"
      case Pet(_, says0or1) => "robot"
      case Pet(_, saysMeowOrNja) => "cat"
      case Pet(_, _) => "unknown"
    }
    println(kind)
  */

  /*def checkInput(drobj: (Int, Int)): Either[String, (Int, Int)] = {
    if (drobj._1 == 0|| drobj._2 == 0) Left("Zero divisor")
    else if (!(Math.abs(drobj._1) < Math.abs(drobj._2))) Left("Invalid input")
    else Right(drobj)
  }

  def uluchitj(r: (Int, Int)): (Int, Int) = {
    val gcd = BigInt(r._1).gcd(r._2).toInt
    (r._1 / gcd, r._2 / gcd)
  }

  def division(p: (Int, Int), q: (Int, Int)): Either[String, (Int, Int)] = {
    val x = checkInput(p._1 * q._2, p._2 * q._1)
    x match {
      case Right(value) => Right(uluchitj(value))
      case Left(_) => Left("Improper result")
    }
  }

  def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = {
    checkInput(p).flatMap { pp =>
      checkInput(q).flatMap { qq =>
        division(pp, qq)
      }
    }
  }


  println(divide(1, 2)(0, 2) == Left("Zero divisor"))

  println(divide(3, 4)(1, 10) == Left("Improper result"))
  println(divide(1, 2)(1, 2) == Left("Improper result"))

  println(divide(2, 1)(1, 7) == Left("Invalid input"))
  println(divide(1, 2)(7, 1) == Left("Invalid input"))
  println(divide(1, 1)(2, 2) == Left("Invalid input"))
  println(divide(2, 1)(3, 1) == Left("Invalid input"))

  println(divide(1, 2)(2, 3).isRight)
  println(divide(-1, 2)(2, 3).isRight)
  println(divide(1, -2)(2, 3).isRight)
  println(divide(1, 2)(-2, 3).isRight)
  println(divide(1, 2)(2, -3).isRight)
*/


  /*
    val list = List(0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0)

    val x: (List[Int], List[Int]) = list.sorted.splitAt(list.count(_ == 0))

    println(x._1.mkString(","))
    println(x._2.mkString(","))*/

  /*
  val k = StdIn.readInt()
  val list = StdIn.readLine()
  val xxxxxx = list.split(" ").map(_.toInt).toList

  def kOrder(list: List[Int], k: Int): Int = {
    val x = list.sorted
    x(k - 1)
  }

  kOrder(xxxxxx, k)
*/


  /**
    * Считайте числа из консоли до слова END.
    * С полученным списком необходимо выполнить:
    * выбрать каждый второй элемент
    * каждый выбранный элемент умножить на 2
    * вывести в консоль сумму элементов полученного списка*/


  //val list: Stream[String] = Stream.continually(StdIn.readLine()).takeWhile(_ != "END")
  //println(list.zipWithIndex.filter(x => x._2 % 2 != 0).map(_._1.toInt * 2).sum)

/*
  val points: List[Int] = List(1, 3)
  val chr1: List[Char] = List('x', 'x', 'x', 'x', 'x')
  val chr2: List[Char] = List('y', 'y', 'y', 'y', 'y')


  def go(i: Int) =
    chr1.zip(chr2).zipWithIndex.map(x => if (x._2 < i) x._1 else x._1.swap).unzip

  val x = points.foreach(i => println(go(i)))
*/

}
