package models

case class Guerreiro(id: Long, name: String, posts: List[Post])

object Guerreiro {
  
  def all(): List[Guerreiro] = Nil
  
  def create(name: String) {}
  
  def delete(id: Long) {}
  
}