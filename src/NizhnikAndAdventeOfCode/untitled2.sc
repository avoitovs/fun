/**
  * Напишите функцию flatten(options: List[Option[Int]]): List[Int],
  * возвращающую список из всех не-None элементов списка.
  * Пользуйтесь частичными функциями.
  * *
  * Ничего считывать и выводить не нужно, просто реализуйте функцию */

/*
def magic: PartialFunction[Option[Int], Int] = {
  case Some(x) => x
}

def flatten(options: List[Option[Int]]): List[Int] = options.collect(magic)



val list = List(0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0)

val x: (List[Int], List[Int]) = list.sorted.splitAt(list.count(_ == 0))

print(x._1.mkString(","))
println(x._2.mkString(","))

def iter(list: List[Int]): Unit = {
  list match {
    case a :: Nil => print(s"$a")
    case Nil => print("")
    case a :: tail => {
      print(s"$a, ")
      iter(tail)
    }
  }
}

iter(x._1)
iter(x._2)

val jdg = List(3, 8, 1, 12, 23)

def kOrder(list: List[Int], k: Int): Int = {
  val x = list.sorted
  x(k - 1)
}

kOrder(jdg, 4)
*/
/**
  * Взять все числа меньше 100 (список может быть большим)
  * Выбрать все числа, которые делятся на 4
  * Поделить их на 4
  * Вывести на экран в отдельной строке каждый элемент, кроме последнего
  */

/*
val list1 = List(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150)

list1.takeWhile(_ < 100).filter(_ % 4 == 0).map(_ / 4).dropRight(1)
*/













