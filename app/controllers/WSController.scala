package controllers

import actors.Reverser
import play.api.mvc._
import play.api.libs.streams.ActorFlow

import javax.inject.Inject
import akka.actor.ActorSystem
import akka.stream.Materializer

import javax.sound.midi.Receiver

class WSController @Inject() (cc: ControllerComponents)(implicit system: ActorSystem, mat: Materializer)
  extends AbstractController(cc) {

  def socket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef { out =>
      Reverser.props(out)
    }
  }
}
