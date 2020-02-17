package core.lectures.oop

object AbstractDataType extends App {

  abstract class Animal {
    val creatureType: String

    protected def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override protected def eat = println("crunch crunch")
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "croc"
    def eat = println("nom nom")
    def eat(animal: Animal) = println("eating $animal")
  }

  //traits vs abstract classes
  // 1 - traits have no constructor parameters
  // 2 - multiply traits may be inherited by single class
  // 3 - trait = behavior, class = type of thing



}
