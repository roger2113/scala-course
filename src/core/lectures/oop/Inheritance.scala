package core.lectures.oop

object Inheritance extends App {

  //only single class inheritance
  class Animal {
    val creatureType = "wild"
    protected def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch: Unit = {
      eat
      println("crunch")
    }
  }

  def cat = new Cat

  //cat.eat
  cat.crunch


  //constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overriding
  class Dog(override val creatureType: String) extends Animal {
    //can be passed in constructor
//    override val creatureType: String = "domestic"
    override def eat = println("crunch crunch")
  }

  val dog = new Dog("some")
  dog.eat
  println(dog.creatureType)

  //type substitution
  val unknownAnimal: Animal = new Dog("Nemec")
  //unknownAnimal.eat - dog's "crunch crunch"

  //super

  //preventing ovverides
  // 1 - final
  // 2 - sealed - using only in this file
}
