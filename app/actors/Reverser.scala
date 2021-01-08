package actors

import akka.actor.{Actor, ActorRef, Props}

class Reverser(out: ActorRef) extends Actor {
  def receive = {
    case s:String => out!(s.reverse)
    case _ => println("Sorry, didn't quite understantd that. I can only process a String")
  }
}

object Reverser {
  def props(out: ActorRef) = Props(new Reverser(out))
}
