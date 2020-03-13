val n = 9
val s = Math.sqrt(n).toInt
type Board = IndexedSeq[IndexedSeq[Int]]

def solve(board: Board, cell: Int = 0): Option[Board] = (cell%n, cell/n) match {
  case (r, `n`) => Some(board)
  case (r, c) if board(r)(c) > 0 => solve(board, cell + 1)
  case (r, c) =>
    def cells(i: Int) = Seq(board(r)(i), board(i)(c), board(s*(r/s) + i/s)(s*(c/s) + i%s))
    def guess(x: Int) = solve(board.updated(r, board(r).updated(c, x)), cell + 1)
    val used = board.indices.flatMap(cells)
    (1 to n).diff(used).collectFirst(Function.unlift(guess))
}


val board = Vector(
  Vector(1, 0, 0, 0, 0, 7, 0, 9, 0),
  Vector(0, 3, 0, 0, 2, 0, 0, 0, 8),
  Vector(0, 0, 9, 6, 0, 0, 5, 0, 0),
  Vector(0, 0, 5, 3, 0, 0, 9, 0, 0),
  Vector(0, 1, 0, 0, 8, 0, 0, 0, 2),
  Vector(6, 0, 0, 0, 0, 4, 0, 0, 0),
  Vector(3, 0, 0, 0, 0, 0, 0, 1, 0),
  Vector(0, 4, 0, 0, 0, 0, 0, 0, 7),
  Vector(0, 0, 7, 0, 0, 0, 3, 0, 0)
)
println(solve(board).get.map(_.mkString(" ")).mkString("\n"))