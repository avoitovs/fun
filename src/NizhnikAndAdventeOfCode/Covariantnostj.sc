import Vect.Aux

/*trait T {
  val value: String
}

case class A (value: String) extends T

case class B (override val value: String)
  extends T

val objB = B("It is a B.value")
val objA = A("It is a A.value")


class FunctionPrint[A <: T](prefix: String) {
  def apply(t: T): Unit = println(prefix + " " + t.value)
}

object FunctionPrint {
  def apply[A <: T](prefix: String) = new FunctionPrint[T](prefix)
}



val printA = FunctionPrint[A]("A-value:")
val printB = FunctionPrint[B]("B-value:")

def methodPrint[A <: T](f: FunctionPrint[T], obj: T) = {
  f(obj)
}

methodPrint(printB, objA)

////////

class Person (val name: String)

class Student(name: String, val course: Int) extends Person(name)

class Pair[+T](val first: T, val second: T) {

  def replaceFirst[B >: T](newValue: B): Pair[B] = {
    new Pair[B](newValue, second)
  }


}

def printNames(pair: Pair[Person]): Unit = {
  println("1: " + pair.first.name + "  2: " + pair.second.name)
}

val pair = new Pair(new Student("Pavel", 1), new Student("Oleg", 5))
printNames(pair.replaceFirst(new Person("Oliver")))

/////////

*/
