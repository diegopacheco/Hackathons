package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import models.Guerreiro

object GuerreiroController extends Controller {
	
  val taskForm = Form(
     "name" -> nonEmptyText
  )
  
  def guerreiro       	=  Action { Ok(views.html.guerreiro(Guerreiro.all(), taskForm)) }
   
  def newGuerreiro      =  Action { implicit request => 
    taskForm.bindFromRequest.fold(
    	errors => BadRequest(views.html.guerreiro(Guerreiro.all(), errors)),
    	name   => {
    		Guerreiro.create(name)
    		Redirect(routes.GuerreiroController.guerreiro)
    	}
    ) 
  }
   
  def deleteGuerreiro(id: Long) = TODO
  
}