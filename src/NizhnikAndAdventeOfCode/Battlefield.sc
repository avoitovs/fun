import scala.util.Random

type Point = (Int, Int)
type Field = Vector[Vector[Boolean]]
type Ship = List[Point]
type Fleet = Map[String, Ship]
type Game = (Field, Fleet)

// определить, можно ли его поставить
def checkVector(field: Field, point: Point): Boolean = {
  point match {
    case (0, 0) => field(0)(0) || field(1)(0) || field(0)(1) || field(1)(1)
    case (9, 9) => field(9)(9) || field(8)(9) || field(9)(8) || field(8)(8)
    case (0, 9) => field(0)(9) || field(0)(8) || field(1)(8) || field(1)(9)
    case (9, 0) => field(9)(0) || field(8)(0) || field(8)(1) || field(9)(1)
    case (x, 0) => field(x)(0) || field(x - 1)(0) || field(x + 1)(0) || field(x - 1)(1) || field(x + 1)(1) || field(x)(1)
    case (0, y) => field(0)(y) || field(0)(y - 1) || field(0)(y + 1) || field(1)(y - 1) || field(1)(y + 1) || field(1)(y)
    case (x, 9) => field(x)(9) || field(x - 1)(9) || field(x + 1)(9) || field(x - 1)(8) || field(x + 1)(8) || field(x)(8)
    case (9, y) => field(9)(y) || field(9)(y - 1) || field(9)(y + 1) || field(8)(y - 1) || field(8)(y + 1) || field(8)(y)
    case (x, y) => field(x)(y) || field(x)(y - 1) || field(x)(y + 1) || field(x + 1)(y - 1) || field(x + 1)(y + 1) || field(x + 1)(y) ||
      field(x - 1)(y - 1) || field(x - 1)(y + 1) || field(x - 1)(y)
  }
}

def checkPosition(ship: Ship, field: Field, res: Boolean): Boolean = {
  if (ship.isEmpty) res
  else if (!checkVector(field, ship.head)) checkPosition(ship.tail, field, true)
  else false
}

// определить, подходит ли корабль по своим характеристикам
def checkShipSize(ship: Ship): Boolean = if (ship.size > 4 || ship.isEmpty) false else true

val nothing = _: Int
val plus = (_: Int) + 1
val minus = (_: Int) - 1

def checkX(f: Int => Int = nothing)(ship: Ship): Boolean = ship.head._1 == f(ship.tail.head._1)
def checkY(f: Int => Int = nothing)(ship: Ship): Boolean = ship.head._2 == f(ship.tail.head._2)

def check(ship: Ship, f: Ship => Boolean, res: Boolean): Boolean = {
  if (ship.size == 1) res
  else if (f(ship)) check(ship.tail, f, true)
  else false
}

def checkForCurve(ship: Ship): Boolean = ship match {
  case x if checkX(nothing)(x) => check(x, checkX(nothing), true)
  case y if checkY(nothing)(y) => check(y, checkY(nothing), true)
  case _ => false
}

def checkForCut(ship: Ship): Boolean = ship match {
  case x if checkX(plus)(x) => check(x, checkX(plus), true)
  case y if checkY(plus)(y) => check(y, checkY(plus), true)
  case xM if checkX(minus)(xM) => check(xM, checkX(minus), true)
  case yM if checkY(minus)(yM) => check(yM, checkY(minus), true)
  case _ => false
}

def validateShip(ship: Ship): Boolean = checkShipSize(ship) && checkForCurve(ship) && checkForCut(ship)
def validatePosition(ship: Ship, field: Field): Boolean = checkPosition(ship, field, false)
// добавить корабль во флот
def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = fleet + (name -> ship)
// пометить клетки, которые занимает добавляемый корабль
def markUsedCells(field: Field, ship: Ship): Field = {
  if (ship.isEmpty) field
  else {
    val x = ship.head._1
    val y = ship.head._2
    val res = field(x).updated(y, true)
    val updatedField = field.updated(x, res)
    markUsedCells(updatedField, ship.tail)
  }
}



// логика вызовов методов выше
def tryAddShip(game: Game, name: String, ship: Ship): Game = {

}
