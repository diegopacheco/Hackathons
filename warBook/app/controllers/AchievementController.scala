package controllers

import play.api._
import play.api.mvc._

object AchievementController extends Controller {

  import play.api.data._
  import play.api.data.Forms._
  import models.Achievement

  val achievementForm = Form(
		  "label" -> nonEmptyText
  )

  def list = Action {
    Ok(views.html.achievements(Achievement.all(), achievementForm))
  }
  
  def newAchievement = Action{ implicit request =>
    achievementForm.bindFromRequest.fold(
    		errors => BadRequest(views.html.achievements(Achievement.all(), errors)),
    		label => {
    			Achievement.create(label)
    			Redirect(routes.AchievementController.list)
    		}
    )
  }
}