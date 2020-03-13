case class Pairr[T](first: T, second: T)(implicit im: T => Ordered[T]) {
  def smaller: T = {
    if (first < second) first
    else second
  }
}


val p = Pairr(BigInt("7000000000002000"),BigInt("7000000000000000"))
require(p.smaller == BigInt("1000000000000000"))

println(p.smaller == BigInt("1000000000000000"))