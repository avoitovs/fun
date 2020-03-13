import Vect.Aux

trait Vect extends Any {
  type Item
  def length: Int
  def get(index: Int): Item
  def set(index: Int, item: Item): Aux[Item]
}

object Vect {
  type Aux[I] = Vect {type Item = I}
}

final case class StringVect(str: String) extends AnyVal with Vect {
  type Item = Char
  def length = str.length
  def get(index: Int) = str.charAt(index)
  def set(index: Int, item: Char): Aux[Char] = StringVect(str.updated(index, item))
}

final case class BoolVect64(values: Long) extends AnyVal with Vect {
  type Item = Boolean
  def length = 64
  def repr = values.toBinaryString.reverse.padTo(64, '0').reverse
  def get(index: Int): Boolean = repr(index) == 1
  def set(index: Int, item: Boolean): Aux[Boolean] = BoolVect64(BigInt(repr.updated(index, if (item) '1' else '0' ).mkString, 2).toLong)

}


final case class BoolVect8(values: Byte) extends AnyVal with Vect {
  type Item = Boolean
  def length = 8
  def repr = values.toBinaryString.padTo(8, '0')
  def get(index: Int) = repr(index) == '1'
  def set(index: Int, item: Boolean): Aux[Boolean] = BoolVect8(BigInt(repr.updated(index, if (item) '1' else '0' ).mkString, 2).toByte)

}

object jkdvohfv extends App {


  def repr = 123.toBinaryString.reverse.padTo(10, "0").reverse



  println(BigInt(repr.mkString, 2).toLong)
  println("====")

  println(123.toByte)

  println(repr.updated(7, if (true) 1 else 0 ).mkString.toLong)
  println(Integer.parseInt(repr.updated(7, if (true) 1 else 0 ).mkString, 2))



  def toList(vect: Vect): List[vect.Item] = {
    val x = for (i <- 0 to vect.length) yield vect.get(i)
    x.toList

  }

}