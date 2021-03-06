package algebra
package std

import algebra.lattice._
import algebra.number._
import algebra.ring._
import algebra.std.util.StaticMethods

package object int extends IntInstances

trait IntInstances {
  implicit val intAlgebra = new IntAlgebra

  val IntMinMaxLattice: Lattice[Int] =
    Lattice.minMax[Int](intAlgebra)
}

class IntAlgebra extends EuclideanRing[Int]
    with Order[Int] with Signed[Int] with IsIntegral[Int] with Serializable {

  def compare(x: Int, y: Int): Int =
    if (x < y) -1 else if (x > y) 1 else 0

  override def eqv(x: Int, y: Int) = x == y
  override def neqv(x: Int, y: Int) = x != y
  override def gt(x: Int, y: Int) = x > y
  override def gteqv(x: Int, y: Int) = x >= y
  override def lt(x: Int, y: Int) = x < y
  override def lteqv(x: Int, y: Int) = x <= y

  def abs(x: Int): Int =
    if (x < 0) -x else x

  def signum(x: Int): Int =
    java.lang.Integer.signum(x)

  def zero: Int = 0
  def one: Int = 1

  def plus(x: Int, y: Int): Int = x + y
  def negate(x: Int): Int = -x
  override def minus(x: Int, y: Int): Int = x - y

  def times(x: Int, y: Int): Int = x * y
  def quot(x: Int, y: Int) = x / y
  def mod(x: Int, y: Int) = x % y

  override def pow(x: Int, y: Int): Int =
    StaticMethods.pow(x.toLong, y.toLong).toInt

  def gcd(x: Int, y: Int): Int =
    StaticMethods.gcd(x.toLong, y.toLong).toInt

  override def fromInt(n: Int): Int = n
  override def toDouble(n: Int): Double = n.toDouble
}
