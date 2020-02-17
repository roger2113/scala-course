package core.lectures.oop

object OOBasics extends App {

  val person = new Person("Jhon", 26)
  println(person.age)
  person.greet("Daniel")
}

//constructor
class Person(name: String, val age: Int) {
  //body
  val x = 2

  //multiply constructors
  def this(name: String) = this(name, 0)
  def this() = this("Sandy", 0)

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: 'Hi, $name'")
}

//class parameters are NOT FIELDS
//name - parameter, age - filed(add val or var)
