package models

case class War(id: Long, label: String)

object War {
  
  def all(): List[War] = Nil
  
  def create(label: String) {}
  
  def delete(id: Long) {}
  
}