package Sudoku

object Main extends App {

  type Field = Vector[Vector[Int]]
  type Square = Vector[Vector[Int]]

  val sudokuStart = Vector(
    Vector(6, 0, 0, 0, 0, 3, 0, 0, 0),
    Vector(0, 1, 3, 0, 0, 0, 4, 0, 7),
    Vector(0, 0, 4, 0, 9, 1, 6, 0, 3),

    Vector(4, 0, 9, 0, 8, 6, 1, 0, 0),
    Vector(1, 0, 2, 4, 0, 0, 0, 0, 8),
    Vector(0, 0, 0, 0, 1, 0, 0, 0, 4),

    Vector(0, 4, 0, 6, 0, 9, 0, 7, 0),
    Vector(0, 2, 0, 0, 0, 0, 3, 0, 0),
    Vector(8, 9, 0, 0, 0, 0, 0, 5, 0)
  )

  def getY(index: Int, field: Field): Vector[Int] = (0 to 8).map(i => field(index)(i)).toVector
  def getX(index: Int, field: Field): Vector[Int] = field(index)
  def getAllSquares(field: Field): Vector[Square] = {
    Vector(0, 3, 6).map { in =>
      (in to in + 2).map { i =>
        (in to in + 2).map(z => field(i)(z)).toVector
      }.toVector
    }

  }

  def checkLine(line: Vector[Int]): Boolean = line.distinct.size == line.size
  def checkSquare(square: Square): Boolean = square.flatten.distinct.size == 9

  def checkIfNumberFits(x: Int, y: Int, guess: Int, field: Field) = {
    val upFi = field.updated(x, field(x).updated(y, guess))

    val xRow = getX(x, upFi)
    val yRow = getY(y, upFi)
    val sq = getAllSquares(field).map(checkSquare(_)).forall(i => i)

    checkLine(xRow) && checkLine(yRow) && sq
  }

  def changeField(x: Int, y: Int, guess: Int, field: Field): Field = field.updated(x, field(x).updated(y, guess))

  def solve(field: Field): Field = {

    for (x <- 0 to 8; y <- 0 to 8) yield {
      if (field(x)(y) == 0) {
        (1 to 9).map { g =>
          if (checkIfNumberFits(x, y, g, field)) {
            val upFi = field.updated(x, field(x).updated(y, g))
            solve(upFi)
          }
        }}}

        /*
        (0 to 8).map{x=>
          (0 to 8).map{ y=>
            if(field(x)(y)==0){
              (1 to 9).map{g =>
                if (checkIfNumberFits(x,y,g, field)){
                  val upFi = field.updated(x, field(x).updated(y, g))
                  solve(upFi)
                }
              }
            }
          }
        }
    */
      }


      def printSudokuField(field: Field): Unit = {
        field.foreach(i => println(i))
      }

      println(solve(sudokuStart))


      val v = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9)
      val n = Vector(7, 8, 9, 10, 11, 12, 13, 14, 15)
      val k = Vector(13, 14, 15, 16, 17, 18, 22, 21, 1)
      val l = Vector(21, 22, 23, 24, 25, 26, 1, 2, 3)
      val h = Vector(31, 32, 33, 34, 35, 36, 4, 5, 6)
      val w = Vector(312, 322, 323, 324, 352, 236, 42, 25, 62)
      val vw = Vector(19, 92, 93, 94, 95, 96, 97, 98, 99)
      val nw = Vector(87, 88, 89, 810, 181, 182, 183, 184, 185)
      val kw = Vector(173, 147, 715, 176, 717, 178, 722, 271, 71)

      val y: Field = Vector(v, n, k, l, h, w, vw, nw, kw)

      val hg = (0 until 9).map(i => i)

      val hdddd = Vector(true, true, true)

      // println(hdddd.forall(i => i))

      // println(getAllSquares(y))


    }


