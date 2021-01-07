package controllers

import dao.DogDAO
import models.Dog
import play.api.libs.json.{JsError, JsSuccess, JsValue, Json}
import play.api.mvc._

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global

class DogController @Inject() (cc: ControllerComponents, dogDao: DogDAO)
  extends AbstractController(cc) {

  def index: Action[AnyContent] = Action.async {
    dogDao.all().map {
      dogs => Ok(Json.toJson(dogs))
    }
  }

  def insertDog: Action[JsValue] = Action(parse.json) { request =>
    // 現状だとidが必須。。。
    request.body.validate[Dog] match {
      case s: JsSuccess[Dog] =>
        val dog = s.value
        dogDao.insert(dog)
        Ok("Hello " + dog.name + ", color " + dog.color)
      case JsError(errors) =>
        Ok(errors.toString())
    }
  }
}
