package ArithmeticOperator.Operators

import ArithmeticOperator.Computation.Computation
import akka.actor.{Actor, ActorRef}

/** *******************************************************************************************************
  * The Operators trait. Extends Actor and Computation. Every operator mentioned here is
  * indeed an Actor
  * *******************************************************************************************************/
trait Operator extends Actor with Computation

// Companion object for defining the type OperatorRef
object Operator {
  type OperatorRef = ActorRef
}
