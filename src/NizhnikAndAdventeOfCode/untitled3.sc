class Point(val x: Double, val y: Double, val z: Double)

object Point {

  def apply(x: Double, y: Double, z: Double): Point = new Point(x, y, z)

  def average(l: List[Point]): Point = {
    if (l.isEmpty) Point(0, 0, 0)
    else {
      val sum = l.reduce((point1, point2) => Point(point1.x + point2.x, point1.y + point2.y, point1.z + point2.z))
      Point(sum.x / l.length, sum.y / l.length, sum.z / l.length)
    }
  }

  def show(p: Point): String = s"${p.x} ${p.y} ${p.z}"

}