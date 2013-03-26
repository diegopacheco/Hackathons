package controllers

import play.api._
import play.api.mvc._
import scravatar._

object GravatarController extends Controller {
  
  def index = Action {
    Ok(views.html.gravatar(imagem))
  }
  
  
   def imagem = Gravatar("alexandrepoletto@gmail.com").avatarUrl
  
  
}