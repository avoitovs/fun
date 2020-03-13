
case class Pet(name: String, says: String)

val pet = Pet("Rex", "1d")


val rezdeliNa10: PartialFunction[Int, Int] = {
  case 1 => 10
}


val squareRoot: PartialFunction[Double, Double] = {
  case d: Double if d > 0 => Math.sqrt(d)
}

squareRoot.isDefinedAt(0)


val log: PartialFunction[Double, Double] = {
  case d: Double if d > 0 => Math.log(d)
}

log(25)


case class Jar(name: String, value: Int, price: Double)
val jars = List(Jar("Морской синий 6л", 6, 3000), Jar("Огненно-красный 12л", 12, 5000))


val discount: PartialFunction[Jar, String] = {
  case Jar(name, value, price) if value > 10 => s"$name ${price * 0.1}"
  case Jar(name, value, price) if value <= 10 && value >= 5 => s"$name ${price * 0.05}"
}

List(
  Jar("Морской синий 6л", 6, 3000.0),
  Jar("Огненно-красный 12л", 12, 5000.0),
  Jar("Зеленый 1л", 1, 500.0)
).collect(discount)



def swap3(tuple: (Int, Int, Int)): (Int, Int, Int) = (tuple._3, tuple._2, tuple._1)


def foo(list: List[Int]): Int = list.find(_ % 3 == 0).map(_ * 2).getOrElse(0)

















/*
def checkForMeow(string: String): Boolean = {
  string == "meow" || string == "nya"
}
def checkFor1(string: String): Boolean = string.matches(".*(0|1).*")

def checkIfDog(p: Pet): Boolean = p.name == "Rex" && !checkForMeow(p.says) && !checkFor1(p.says)

def checkIfCat(p: Pet): Boolean = !(p.name == "Rex") && checkForMeow(p.says) && !checkFor1(p.says)

def checkIfRobot(p: Pet): Boolean = !(p.name == "Rex") && !checkForMeow(p.says) && checkFor1(p.says)

val kind = pet match {
  case dog if checkIfDog(dog) => "dog"
  case cat if checkIfCat(cat) => "cat"
  case robot if checkIfRobot(robot) => "robot"
  case _ => "unknown"
}
println(kind)*/


val input = "oleg oleg@email.com 7bdaf0a1be3 a8af118b1a2 28d74b7a3fe".split(" ").toList
val input2 = List("oleg oleg@email.com", "7bdaf0a1be3", "a8af118b1a2", "28d74b7a3fe")


val nameRegex = "([a-zA-Z]+)".r
val emailRegex = "\\w+@(\\w+\\.\\w+)".r
val nameEmailRegex = "(\\w+[a-zA-Z]) \\w+@(\\w+\\.\\w+)".r

/*
val result = input2 match {

  case List(x, y, rest@_*) if x.contains("@") =>
  case List(x, y, rest@_*) if y.contains("@") => "second"
  case _ => println("invalid")


}
println(result)*/


val result = input2 match {

  case List(nameRegex(name), emailRegex(domain), rest@_*) => s"$name $domain"
  case List(nameEmailRegex(name, domain), rest@_*) => s"$name $domain"
  case _ => "invalid"


}
println(result)