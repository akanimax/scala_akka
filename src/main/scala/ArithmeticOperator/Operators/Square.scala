package ArithmeticOperator.Operators

import ArithmeticOperator.Performer.Performer.Result
import akka.actor.Props

/**********************************************************************************************************/

/** The Operator that squares the numbers in a message:*/
class Square extends Operator {

  var operands: List[Int] = List[Int]() // The state variable currently initialized to Empty List

  override def receive: Receive = {
    case Numbers(xs) => operands = xs // update the state of the variable

    case Compute(destination) =>
      // first perform the squaring of all the elements of the current List
      val squared = operands.map(x => x * x)

      // send the squared list to the destination
      destination ! Result(squared)
  }

}

/** The companion object to show the public interface to this actor*/
object Square {

  /** Props method for instantiating this actor */
  def props: Props = Props[Square] // this is pretty simple

}

/**********************************************************************************************************/
