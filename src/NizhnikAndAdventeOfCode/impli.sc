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

object Expr {
  ﻿ ﻿
  implicit val stringExpr: Expr[String] = new Expr[String] {
    ﻿
    override def literalInt(value: Int): String = s"$value"
    ﻿
    override def variable(name: String): String = s"${name.toUpperCase}"
    ﻿
    override def times(x: String, y: String): String = s"($x)*($y)"
    ﻿
    override def plus(x: String, y: String): String = s"($x)+($y)"
    ﻿
    override def minus(x: String, y: String): String = s"($x)-($y)"
    ﻿
    override def negate(x: String): String = s"-($x)"
    ﻿
  }
  ﻿
}


def function[T: Expr]: T = X * X + 2.lit * (Y + Z * X * 2.lit) - 7.lit * Z + 4.lit
println(function[String]) // ((((X)*(X))+((2)*((Y)+(((Z)*(X))*(2)))))-((7)*(Z)))+(4)

type Calc[T] = Map[String, T] => T

implicit def numericExpr[T: Numeric]: Expr[Calc[T]] = new Expr[Calc[T]] {
  import Numeric.Implicits._

    // methods


}

println(function[Calc[Double]].apply(Map("x" -> 1, "y" -> -1, "z" -> 0.2))) // 2.4


