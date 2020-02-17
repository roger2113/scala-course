package core.lectures.functionalp

object WhatsAFunction extends App {

  //DREAM: use a functions as a first class elements
  //problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  //function types = Function1[A, B]
  val stringToIntConverter: (String => Int) = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("43"))

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  //ALL SCALA FUNCTIONS ARE OBJECTS


  val superAdder: Int => (Int => Int) = new Function[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val superAdder1 = (x: Int) => (y: Int) => x + y

  val adder3 = superAdder(3)
  println(adder3(4)) // 7
  println(superAdder(3)(4)) // curried function
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
