import scala.annotation.tailrec



val test = Vector.fill(3,3)(false)
val res = test(2).updated(2,true)
val res2 = test.updated(2,res)


val says0or1 = "(0|1)+".r

says0or1.findAllMatchIn("1111111")



/*val add1 = (_: Int) + 1

val calc42 = (f: Int => Int) => f(42)

calc42(add1)


calc42(_ + 1)

def sumTo(x: Int): Int = {
  if (x == 0) 0
  else x + sumTo(x - 1)
}

calc42(sumTo)

//calc42((x:Int) => if(x==0) 0 else )

def fix(f: (=> Int => Int) => Int => Int): Int => Int = f(fix(f))

fix(_ => _ => 1)(1)

fix(rec => x => if (x == 0) 0 else x + rec(x - 1))(7)

calc42(fix(rec => x => if (x == 0) 0 else x + rec(x - 1)))


def addOne(x: Int) = x + 1
val add222 = calc42(_)

add222(add1)



def fibs(n: Int, currentNumber: Int = 1, f1: BigInt = 0, f2: BigInt = 1): BigInt = {
  if (n == currentNumber)
    f2
  else {
    fibs(n, currentNumber + 1, f2, f2 + f1)
  }
}
println(fibs(8))





//val dataEl = (data: => Iterable[T]) => data.splitAt(data.size / 2)._2.head

def middle[T](data: Iterable[T]): T = {
  if (data.size % 2 == 0) data.splitAt(data.size / 2)._2.head
  else data.splitAt(Math.round(data.size / 2))._2.head
}



println(require(middle("Scala") == 'a'))

println(require(middle(Seq(1, 7, 5, 9)) == 5))











*/

for (i <- Range(1, 10).inclusive) println(i)

/*
def calc42M[A]: (Int => A) => A = f => f(42000000)

//calc42M(_.toString)

def tailRec[A, B](
  iter: A => A,
  comb: (B, A) => B,
  cond: A => Boolean)(start: A, init: B):B = {

  def go(x: A, acc: B): B =
    if (cond(x)) go(iter(x), comb(acc, x))
    else acc
  go(start, init)

}

calc42M(n => tailRec[Int, Long](_ - 1, _ + _, _ >= 0)(n, 0))

*/
val regex = "(Russia|Japan)".r
case class Address(country: String, city: String)

def getInfo(address: Address): String = address match {
  case Address(regex(country), city) => s"$city, $country"
  case Address(_, _) => "unknown country"
}




getInfo(Address("uyf", "hz"))




