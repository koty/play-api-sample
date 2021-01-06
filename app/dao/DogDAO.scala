package dao

import scala.concurrent.Future
import javax.inject.Inject
import models.Dog
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider

import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
// import play.api.libs.concurrent.Execution.Implicits.defaultContext
// import play.api.libs.streams.Execution.Implicits.trampoline
import slick.driver.JdbcProfile

class DogDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._

  private val Dogs = TableQuery[DogsTable]

  def all(): Future[Seq[Dog]] = db.run(Dogs.result)

  def insert(dog: Dog): Future[Unit] = db.run(Dogs += dog).map { _ => () }

  private class DogsTable(tag: Tag) extends Table[Dog](tag, "dogs") {

    def id = column[UUID]("id", O.PrimaryKey)
    def name = column[String]("name")
    def color = column[String]("color")

    def * = (id, name, color) <> (Dog.tupled, Dog.unapply)
  }
}