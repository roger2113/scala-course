package core.lectures.patternmatching

import scala.util.Random

object PatternMatching extends App {

  //switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the One"
    case 2 => "double or nothing"
    case 3 => "third time is a charm"
    case _ => "something else" // _ = WILDCARD
  }

  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 20)

  //cases match in order
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I am $a years old and I can't drink in USA"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I dont know who I am"
  }

  println(greeting)


  // PM on sealed hierarchies
  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra nova")
  animal match {
    case Dog(someBreed) => println("Matched a dog")
  }


  //match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  } //WHY?!


  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr


}
