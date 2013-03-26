package controllers

import play.api._
import play.api.data.Forms._
import play.api.mvc._
import models.Ranking

object RankingController extends Controller {
	
  
  def ranking         			=  Action { Ok(views.html.ranking(Ranking.all())) }
   
  def newRanking      			=  TODO
   
  def deleteRanking(id: Long) 	= TODO
  
}