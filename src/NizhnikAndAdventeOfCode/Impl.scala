
trait Expr[T] {
  def literalInt(value: Int): T
  def variable(name: String): T
  def times(x: T, y: T): T
  def plus(x: T, y: T): T
  def minus(x: T, y: T): T = plus(x, negate(y))
  def negate(x: T): T = times(x, literalInt(-1))
}


object exprSyntax {
  def literalInt[T](value: Int)(implicit expr: Expr[T]): T = expr.literalInt(value)
  def X[T](implicit expr: Expr[T]): T = expr.variable("x")
  def Y[T](implicit expr: Expr[T]): T = expr.variable("y")
  def Z[T](implicit expr: Expr[T]): T = expr.variable("z")

  implicit class IntToExpr[T](x: Int)(implicit expr: Expr[T]) {
    def lit: T = expr.literalInt(x)
  }

  implicit class NumOps[T](val x: T) extends AnyVal {
    def +(y: T)(implicit expr: Expr[T]): T = expr.plus(x, y)
    def -(y: T)(implicit expr: Expr[T]): T = expr.minus(x, y)
    def *(y: T)(implicit expr: Expr[T]): T = expr.times(x, y)
    def unary_-(implicit expr: Expr[T]): T = expr.negate(x)
  }
}

object Expr2 {
  type Calc[T] = Map[String, T] => T
  implicit def numericExpr[T: Numeric]: Expr[Calc[T]] = new Expr[Calc[T]] {
    import Numeric.Implicits._

    override def literalInt(value: Int): Calc[T] = c => implicitly[Numeric[T]].fromInt(value)
    override def variable(name: String): Calc[T] = c => c(name)
    override def times(x: Calc[T], y: Calc[T]): Calc[T] = calc => x(calc) * y(calc)
    override def plus(x: Calc[T], y: Calc[T]): Calc[T] = calc => x(calc) + y(calc)
    override def minus(x: Calc[T], y: Calc[T]): Calc[T] = calc => x(calc) - y(calc)
    override def negate(x: Calc[T]): Calc[T] = calc => -x(calc)

  }
}


object Expr {
  implicit val stringOrderExpr: Expr[Print] = new Expr[Print] {
    override def literalInt(value: Int): Print = Print(value.toString, 4, true)
    override def variable(name: String): Print = Print(name.toUpperCase, 5)
    override def negate(x: Print): Print = Print(s"-${x.print(1)}", 1, false)
    override def times(x: Print, y: Print): Print = if (x.isLit) Print(s"${x.print(3)}${y.print(3)}", 3) else Print(s"${x.print(3)}*${y.print(3)}", 3)
    override def plus(x: Print, y: Print): Print = Print(s"${x.print(2)}+${y.s}", 2)
    override def minus(x: Print, y: Print): Print = Print(s"${x.print(2)}-${y.print(2)}", 2)
  }
}

final case class Print(s: String, priority: Int, isLit: Boolean = false) {
  def print(outer: Int = 0) = if (outer <= priority) s else s"($s)"
}


object hh extends App {

  import exprSyntax._

  // def function[T: Expr]: T = X * X + 2.lit * (Y + Z * X * 2.lit) - 7.lit * Z + 4.lit
  //println(function[String]) // ((((X)*(X))+((2)*((Y)+(((Z)*(X))*(2)))))-((7)*(Z)))+(4)

  // println(function[Calc[Double]].apply(Map("x" -> 1, "y" -> -1, "z" -> 0.2))) // 2.4

  def function[T: Expr]: T = X * X + 2.lit * (Y + Z * X * 2.lit) - 7.lit * Z + 4.lit
  println(function[Print].print()) // X*X+2(Y+Z*X*2)-7Z+4

}







