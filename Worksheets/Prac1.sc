import Hello.{Greeter, Printer}
import akka.actor.ActorSystem
import Hello.Greeter._

import scala.io.StdIn

val system = ActorSystem("HelloAkka")

val myGreeter = system.actorOf(
  Greeter.props(
    "Hello",
    system.actorOf(Printer.props, "PrinterActor") // create a Printer actor
  )
)

myGreeter ! WhoToGreet("Animesh")
myGreeter ! Greet

/** This is required to wait for the output to appear. */
println(">>> Press ENTER to exit <<<")
StdIn.readLine()
/** Since the Actor operation is asynchronous, if readLine
  * is removed, the output won't get printed on the screen **/
