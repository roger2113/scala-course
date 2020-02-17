package core.lectures.oop

object Objects extends App {

  //SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY (static)

  object Person {
    //static level functionality
    val N_EYES = 2

    def canFly: Boolean = true

    def from(father: Person, mother: Person): Person = new Person("Bobbie")
  }

  class Person(name: String) {
    //instance level functionality

  }

  //class nd object with the same name are COMPANIONS

  println(Person.N_EYES)

  //Scala object = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) //false

  val mary1 = Person
  val john1 = Person
  println(mary == john) //true

  val bobbie = Person.from(john, mary)

  //Scala Applications = Scala object with
  //def main(args: Array[String]): Unit


}
