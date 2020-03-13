


abstract class her

















abstract class DiffList[A](listFunc: List[A] => List[A]) {
  def prepend(s: List[A]): DiffList[A]

  def append(s: List[A]): DiffList[A]

  def result: List[A]
}


final class DiffListImpl[A](listFunc: List[A] => List[A])
  extends DiffList[A](listFunc) {

  def prepend(s: List[A]) = {
    val x = listFunc andThen (s ::: _)
    new DiffListImpl[A](listFunc andThen (s ::: _))
  }

  def append(s: List[A]) = new DiffListImpl[A](((l: List[A]) => l ::: s) andThen listFunc)

  def result = listFunc(Nil)

}


val l1 = List(1, 2, 3)
val l2 = List(4, 5, 6)
val dl = new DiffListImpl[Int](l => l.map(_ * 2))

val result = dl.append(l2).prepend(l1).result





























































/**
  * Ваша задача - спроектировать и реализовать класс официанта.
  * Официант умеет принимать блюдо в заказ и в конце повторять, что было заказано.
  * Также он вежлив и представляется.
  *
  * Требования
  *
  * имя класса Waiter
  * метод для заказа блюда giveMe, принимает название блюда
  * метод complete, возвращает список того, что было заказано
  * при своем появлении официант здоровается с гостем
  * необходимо, чтобы была возможна следующая запись
  * val positions = waiter.giveMe("борщ").giveMe("хлеб").complete()
  *
  * Sample Input:
  * иван борщ хлеб
  * Sample Output:
  * My name иван
  * Order: борщ,хлеб
  */

abstract class WaiterAbstract(name: String, order: List[String]) {
  if (order.isEmpty) println(s"My name $name")

  def giveMe(food: String): WaiterAbstract

  def complete: List[String]
}

class Waiter(name: String, order: List[String]) extends WaiterAbstract(name,order) {

  def giveMe(food: String) = new Waiter(name, food :: order)

  def complete = order.reverse
}

val waiter = new Waiter("Ivan",Nil)

val positions = waiter.giveMe("борщ").giveMe("хлеб").complete




/*

val list1 = List(1, 3, 5, 7)
val list2 = List(2, 4, 6, 8)
val list3 = List(1, 3, 5, 8, 10, 12, 14)



(for {
  x <- list1
  y <- list2
  z <- list3
  checks = x != y && z == x * y
  res = (x, y) if checks
} yield res).foreach(println)



/**
  * Первый, второй и четвертый возвращают Either с ошибкой слева или результатом справа.
  * service2 должен получить на вход результат работы первого сервиса,
  * а четвертый - трех предыдущих.
  * Используя только for-comprehension реализуйте функцию result,
  * которая возвращает результат работы четвертого сервиса.
  *
  */

def service1: Either[String, Double]
def service2(res1: Double): Either[String, Int]
def service3: String
def service4(res1: Double, res2: Int, res3: String): Either[String, String]

def result = for {
  s1<- service1
  s2<- service2(s1)
  s4<- service4(s1,s2,service3)
} yield s4

for{
  x<- Some(1)
  y <- List(1,2,3)
}yield x+y
*/


