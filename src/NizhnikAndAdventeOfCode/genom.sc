import scala.annotation.tailrec

val points: List[Int] = List(1, 3)
val chr1: List[Char] = List('x', 'x', 'x', 'x', 'x')
val chr2: List[Char] = List('y', 'y', 'y', 'y', 'y')

val gen1Ind = chr1.zipWithIndex
val gen2Ind = chr2.zipWithIndex

def checkPoints(
  points: List[Int],
  listIndex: Int,
  change: Boolean): (List[Int], Boolean) = {

  if (points.isEmpty) (Nil, change)
  else if (points.head == listIndex) (points.tail, if (change) false else true)
  else (points, change)
}


def getResult(
  resList: (List[Char], List[Char]),
  changeNumbers: Boolean,
  list1: Char,
  list2: Char): (List[Char], List[Char]) = {

  if (changeNumbers) (resList._1 :+ list2, resList._2 :+ list1)
  else (resList._1 :+ list1, resList._2 :+ list2)
}

@tailrec
def xxx(
  points: List[Int],
  list1: List[(Char, Int)],
  list2: List[(Char, Int)],
  change: Boolean,
  res: (List[Char], List[Char])): (List[Char], List[Char]) = {

  if (list1.isEmpty) res

  else {
    val newPoints = checkPoints(points, list1.head._2, change)
    val needToChange = newPoints._2
    val result = getResult(res, needToChange, list1.head._1, list2.head._1)

    xxx(
      newPoints._1,
      list1.tail,
      list2.tail,
      needToChange,
      result
    )
  }
}


val mygenom = xxx(points, gen1Ind, gen2Ind, false, (Nil, Nil))

println(mygenom._1.mkString)
println(mygenom._2.mkString)

