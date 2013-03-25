package models

case class Achievement(id: Long, label: String) 

object Achievement{
 
  def all(): List[Achievement] = Nil
  
  def create(label: String) {}
  
}