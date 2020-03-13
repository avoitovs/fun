import scala.collection._

object Solution {

  // Complete the equalizeArray function below.
  def equalizeArray(arr: Array[Int]): Int = {

    val sortedArray = arr.sorted.toList

    val myMap = sortedArray.groupBy(identity).mapValues(_.size)

    val maxAmOfRep = myMap.valuesIterator.max

    if (arr.length > maxAmOfRep) arr.length - maxAmOfRep
    else maxAmOfRep


  }

  def main(args: Array[String]) {

    val arr = Array(1, 3, 2, 3, 4, 5, 6)

    equalizeArray(arr)

  }
}