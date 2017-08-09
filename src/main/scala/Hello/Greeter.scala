package Hello

import akka.actor.{Actor, ActorRef, Props}

//#greeter-companion
//#greeter-messages
object Greeter {

  //#greeter-messages
  def props(message: String, printerActor: ActorRef): Props = Props(new Greeter(message, printerActor))

  //#greeter-messages
  final case class WhoToGreet(who: String)
  case object Greet

}

//#greeter-actor
class Greeter(message: String, printerActor: ActorRef) extends Actor {
  import Greeter._
  import Printer._

  var greeting = ""

  def receive: PartialFunction[Any, Unit] = {

    case WhoToGreet(who) =>
      greeting = s"$message, $who"

    case Greet           =>
      //#greeter-send-message
      printerActor ! Greeting(greeting)
      //#greeter-send-message

  }
}