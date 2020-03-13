object ChessBoard {

  // Complete the queensAttack function below.
  def queensAttack(dimensions: Int, numberOfObstacles: Int, queenRow: Int, queenColumn: Int, obstaclesArray: Array[Array[Int]]): Int = {

    val obstacles = obstaclesArray.map(_.toList).toList

    getHorizontalLeft(queenRow, queenColumn, obstacles) + getHorizontalRight(dimensions, queenRow, queenColumn, obstacles) +
      getVerticalUp(dimensions, queenRow, queenColumn, obstacles) + getVerticalDown(queenRow, queenColumn, obstacles) +
      getDiagonalLeftUp(dimensions, queenRow, queenColumn, obstacles) + getDiagonalLeftDown(queenRow, queenColumn, obstacles) +
      getDiagonalRightUp(dimensions, queenRow, queenColumn, obstacles) + getDiagonalRightDown(dimensions, queenRow, queenColumn, obstacles)

  }

  def getDiagonalLeftUp(dimension: Int, queenRow: Int, queenColumn: Int, obstacles: List[List[Int]]): Int = {
    var currentColumn = queenColumn - 1
    var currentRow = queenRow +1
    var possibleSteps = 0


    while (currentColumn > 0 && currentRow <= dimension) {
      if (obstacles.contains(List(currentRow, currentColumn))) {
        return possibleSteps
      } else
        currentColumn = currentColumn - 1
      currentRow = currentRow + 1
      possibleSteps = possibleSteps + 1
    }
    possibleSteps
  }

  def getDiagonalRightUp(dimension: Int, queenRow: Int, queenColumn: Int, obstacles: List[List[Int]]): Int = {
    var currentColumn = queenColumn+1
    var currentRow = queenRow+1
    var possibleSteps = 0


    while (currentColumn <= dimension && currentRow <= dimension) {
      if (obstacles.contains(List(currentRow, currentColumn))) {
        return possibleSteps
      } else
        currentColumn = currentColumn + 1
      currentRow = currentRow + 1
      possibleSteps = possibleSteps + 1
    }
    possibleSteps
  }

  def getDiagonalLeftDown(queenRow: Int, queenColumn: Int, obstacles: List[List[Int]]): Int = {
    var currentColumn = queenColumn - 1
    var currentRow = queenRow - 1
    var possibleSteps = 0


    while (currentColumn > 0 && currentRow > 0) {
      if (obstacles.contains(List(currentRow, currentColumn))) {
        return possibleSteps
      } else
        currentColumn = currentColumn - 1
      currentRow = currentRow - 1
      possibleSteps = possibleSteps + 1
    }
    possibleSteps
  }

  def getDiagonalRightDown(dimension: Int, queenRow: Int, queenColumn: Int, obstacles: List[List[Int]]): Int = {
    var currentColumn = queenColumn + 1
    var currentRow = queenRow -1
    var possibleSteps = 0


    while (currentColumn <= dimension && currentRow > 0) {
      if (obstacles.contains(List(currentRow, currentColumn))) {
        return possibleSteps
      } else
        currentColumn = currentColumn + 1
      currentRow = currentRow - 1
      possibleSteps = possibleSteps + 1
    }

    possibleSteps
  }


  def getHorizontalLeft(queenRow: Int, queenColumn: Int, obstacles: List[List[Int]]): Int = {
    var currentColumn = queenColumn-1
    val currentRow = queenRow
    var possibleSteps = 0


    while (currentColumn > 0) {
      val shit = List(currentRow, currentColumn)
      if (obstacles.contains(shit)) {
        return possibleSteps
      } else
        currentColumn = currentColumn - 1
      possibleSteps = possibleSteps + 1
    }
    possibleSteps
  }

  def getHorizontalRight(dimension: Int, queenRow: Int, queenColumn: Int, obstacles: List[List[Int]]): Int = {
    var currentColumn = queenColumn+1
    val currentRow = queenRow
    var possibleSteps = 0


    while (currentColumn <= dimension) {
      if (obstacles.contains(List(currentRow, currentColumn))) {
        return possibleSteps
      } else
        currentColumn = currentColumn + 1
      possibleSteps = possibleSteps + 1
    }
    possibleSteps
  }

  def getVerticalUp(dimension: Int, queenRow: Int, queenColumn: Int, obstacles: List[List[Int]]): Int = {
    val currentColumn = queenColumn
    var currentRow = queenRow+1
    var possibleSteps = 0


    while (currentRow <= dimension) {
      if (obstacles.contains(List(currentRow, currentColumn))) {
        return possibleSteps
      } else
        currentRow = currentRow + 1
      possibleSteps = possibleSteps + 1
    }
    possibleSteps
  }

  def getVerticalDown(queenRow: Int, queenColumn: Int, obstacles: List[List[Int]]): Int = {
    val currentColumn = queenColumn
    var currentRow = queenRow - 1
    var possibleSteps = 0


    while (currentRow > 0) {
      if (obstacles.contains(List(currentRow, currentColumn))) {
        return possibleSteps
      } else
        currentRow = currentRow - 1
      possibleSteps = possibleSteps + 1
    }
    possibleSteps
  }


  def main(args: Array[String]) {


    println(queensAttack(5, 3, 4, 3, Array(Array(5, 5),Array(4, 2),Array(2, 3))))
  }
}
