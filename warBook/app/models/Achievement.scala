package models

import anorm._
import anorm.SqlParser._

case class Achievement(id: Long, label: String) 

object Achievement{
	import play.api.db._
	import play.api.Play.current

	val achievement = {
			get[Long]("id") ~ 
			get[String]("label") map {
			case id~label => Achievement(id, label)
			}
	}

	def all(): List[Achievement] = DB.withConnection{ implicit c =>
		SQL("select * from achievement").as(achievement *)
	}

	def create(label: String) {
		DB.withTransaction { implicit c =>
		SQL("insert into achievement (label) values ({label})").on(
				'label -> label
				).executeUpdate()
		}
	}

}