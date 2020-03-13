def checkInput(drobj: (Int, Int)): Either[String, (Int, Int)] = {
  if (!(Math.abs(drobj._1) < Math.abs(drobj._2))) Left("Invalid input")
  else if (drobj._2 == 0) Left("Zero divisor")
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



divide(1, 2)(1, 4)

println(divide(1, 0)(1, 2) == Left("Zero divisor"))
println(divide(1, 2)(1, 0) == Left("Zero divisor"))
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

