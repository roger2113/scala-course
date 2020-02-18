package core.lectures.functionalp

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))
  println(list.filter(_ % 2 == 0))
  list.foreach(println)

  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  println(chars.flatMap(char => numbers.map(number => char.toString + number)))

  //for comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
  } yield c.toString + n
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  //syntax overload
  list.map { x =>
    x * 2
  }


}
