package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.util.Arrays.ArrayList
import models.War

object WarController extends Controller {

  val warForm = Form(
    "label" -> nonEmptyText)

  def wars = Action {
    Ok(views.html.war(War.all(), warForm))
  }

  def newWar = Action {
    implicit request =>
      warForm.bindFromRequest.fold(
        errors => BadRequest(views.html.war(War.all(), errors)),
        label => {
          War.create(label)
          Redirect(routes.WarController.wars)
        })
  }

  def deleteWar(id: Long) = Action {
    War.delete(id)
    Redirect(routes.WarController.wars)
  }

}