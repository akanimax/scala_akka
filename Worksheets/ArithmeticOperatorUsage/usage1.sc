import ArithmeticOperator.Operators.Square
import ArithmeticOperator.Performer.Performer
import ArithmeticOperator.Performer.Performer.Operation
import akka.actor.ActorSystem

/**
  * This Worksheet explains How to
  * use the Arithmetic Operator API
  * */

// Since it is an Akka system, create a new akka system first

val system = ActorSystem("ArithmeticOperationsOnNumbers")

// Create a Performer Actor:
val executor = system.actorOf(Performer.props)

// Create a temporary list for performing the operation on
val tempNumbers = List(1, 2, 3, 4, 5, 6, 7, 8)

// Create the desired Operation and send the message
// to the executor to perform the desired operation
val squareOperator = system.actorOf(Square.props)

executor ! Operation(tempNumbers, squareOperator)

// Sleep For some time in order to see the result
Thread.sleep(1000) // 1 second

// Terminate the system to free the resources
system.terminate()