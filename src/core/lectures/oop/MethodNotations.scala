package core.lectures.oop

object MethodNotations extends App {

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  //infix notation = operator notation
  println(mary likes "Inception")





  class Person(val name: String, favouriteMovie: String) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(movie: String): String = s"$name hang out $movie"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and i like movie $favouriteMovie"
  }


  //ALL OPERATORS ARE METHODS
  println(1 + 2)
  println(1.+(2))
  println(mary + "Inception")

  //PREFIX NOTATION
  val x = -1
  val y = 1.unary_-
  //unary operator works only with +, -, ~, !
  println(!mary)

  //postfix notation
//  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary())


}
