//#full-example
package Hello

import Hello.Greeter._
import Hello.Printer._
import akka.actor.ActorSystem
import akka.testkit.{TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, Matchers}

import scala.concurrent.duration._

//#test-classes
class AkkaQuickstartSpec(_system: ActorSystem)
  extends TestKit(_system)
  with Matchers
  with FlatSpecLike
  with BeforeAndAfterAll {
  //#test-classes

  /** this constructor is important to make this class a suite*/
  def this() = this(ActorSystem("AkkaQuickstartSpec")) // Basically The suite creates an object of this
  // directly by calling the no-arg constructor.

  // The system used here comes from the TestKit extension.
  override def afterAll: Unit = {
    shutdown(system)
  }

  //#first-test
  //#specification-example
  "A Greeter Actor" should "pass on a greeting message when instructed to" in {

    //#specification-example
    val testProbe = TestProbe()
    val helloGreetingMessage = "hello"
    val helloGreeter = system.actorOf(Greeter.props(helloGreetingMessage, testProbe.ref))
    val greetPerson = "Akka"
    helloGreeter ! WhoToGreet(greetPerson)
    helloGreeter ! Greet
    testProbe.expectMsg(500 millis, Greeting(s"$helloGreetingMessage, $greetPerson"))
  }
  //#first-test
}
//#full-example
