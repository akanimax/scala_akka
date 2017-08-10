package ArithmeticOperator

import ArithmeticOperator.Computation.Computation
import ArithmeticOperator.Operators.Square
import ArithmeticOperator.Performer.Performer.Result
import akka.actor.ActorSystem
import akka.testkit.{TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, Matchers}

class ArithmeticOperatorSpec(_system: ActorSystem)
  extends TestKit(_system)
  with Matchers with FlatSpecLike with BeforeAndAfterAll with Computation {

  // create a no-argument constructor for the class and initiate a default Actor System
  def this() = this(ActorSystem("ArithmeticOperatorSpecActorSystem"))

  // override the afterAll method
  override protected def afterAll(): Unit = {
    // Terminate the actor system
    system.terminate() // This system comes from the TestKit.
    // It is basically same as the one that we passed to the constructor
  }

  // First test case:
  "A SquareOperator" should "Properly Square all the numbers in the list" in {

    // create a testProbe
    val testProbe = TestProbe()

    // create a fake list of numbers:
    val numbers = List(1, 2, 3, 4, 5)

    // Create the Operator Actor:
    val squareOperator = system.actorOf(Square.props)

    // Send the operation messages to the squareOperator
    squareOperator ! Numbers(numbers)
    squareOperator ! Compute(testProbe.ref)

    // Check if the result reverted by the squareOperator has properly computed all the squares
    testProbe.expectMsg(Result(List(1, 4, 12, 16, 25))) // This test should fail
    // Obviously! Duh!
    // Correct it at your own comfort!

  }
}
