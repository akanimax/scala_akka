package ArithmeticOperator.Computation

import ArithmeticOperator.Performer.PerformerRef


/** *******************************************************************************************************
  * The interface defining the way to interact with the operators.
  * This should be extended by all the Operators
  * *******************************************************************************************************/

trait Computation {
  /** The established contract to invoke the computations*/
  // The message to set the numbers state of the actor
  final case class Numbers(xs: List[Int])

  // To tell the actor to perform the computation on the list of integers currently present in it
  final case class Compute(executor: PerformerRef) // The input parameter is the actor to return the result list to
}

