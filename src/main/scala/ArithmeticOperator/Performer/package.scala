package ArithmeticOperator

import akka.actor.ActorRef

package object Performer {

  // Redefine all the types where an ActorRef to something meaningful
  type PerformerRef = ActorRef

}
