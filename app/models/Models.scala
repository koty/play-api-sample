package models

import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json.{JsObject, Json, Reads, Writes, __}

import java.util.UUID

case class Dog(id: UUID, name: String, color: String)

object Dog extends((UUID, String, String) => Dog) {
  implicit val rds: Reads[Dog] = (
    (__ \ Symbol("id")).read[UUID] and
      (__ \ Symbol("name")).read[String] and
      (__ \ Symbol("color")).read[String]
    )(Dog.apply _)

  implicit val wrs: Writes[Dog] = (dog: Dog) => Json.obj(
    "id" -> dog.id,
    "name" -> dog.name,
    "color" -> dog.color,
  )
}