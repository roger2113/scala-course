package core.lectures.oop

object Generics extends App {

  class MyList[+A] {

    //See COVARIANCE question
    def add[B  >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Dog
     */


    val listOfIntegers = new MyList[Int]
    val listOfStrings = new MyList[String]
  }

  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //YES List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //If add Dog List[Cat] turns to List[Animal]

  //2. NO Invariant
  class InvariantList[A]

  //  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]

  //3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]

  val contrVarianceList: Trainer[Cat] = new Trainer[Animal]

  //bounded types
  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)

  class Car
//  val carCage = new Cage(new Car)


}
