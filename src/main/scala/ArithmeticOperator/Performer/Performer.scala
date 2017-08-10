package ArithmeticOperator.Performer

import ArithmeticOperator.Computation.Computation
import ArithmeticOperator.Operators.Operator.OperatorRef
import akka.actor.{Actor, ActorLogging, Props}


object Performer {

  /** The props method to instantiate this Actor */
  def props: Props = Props[Performer]

  /** The messages received by this executor */

  // Message to perform the operation on the given list of Numbers
  case class Operation(xs: List[Int], operator: OperatorRef)

  // Message to get the result back from the operation
  case class Result(xs: List[Int])
}

/** This actor performs the computation specified and then also prints the information to the console*/
class Performer extends Computation with Actor with ActorLogging {

  import Performer._

  override def receive: Receive = {
    case Operation(values, operator) =>

      // Print the values before invoking the operation
      log.info("Values before transformation: " + (values mkString " "))

      // send the messages to the operator for performing the
      operator ! Numbers(values)
      operator ! Compute(self)

    case Result(values) =>

      // Print the values returned by the
      log.info("Values after  transformation: " + (values mkString " "))
  }

}
