import Hello.Greeter._
import Hello.{Greeter, Printer}
import akka.actor.ActorSystem

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
Thread.sleep(1000)
/** Since the Actor operation is asynchronous, if the thread.sleep
  * is removed, the output won't get printed on the screen **/

/** Finally terminate the actor system in running*/
system.terminate()