package controllers

import play.api.libs.json.Json
import play.api.mvc._

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future



class HelloController @Inject() (cc: ControllerComponents)
  extends AbstractController(cc) {

  def hello: Action[AnyContent] = Action.async {
    Future {
      Ok("Hello World")
    }
  }

  def helloJson: Action[AnyContent] = Action {
    val json = Json.obj("hello" -> "world", "language" -> "scala")
    Ok(json)
  }
}
