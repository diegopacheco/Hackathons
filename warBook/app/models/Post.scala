package models

import java.util.Date

case class Post (id: Long, date: Date, text: String)

object Post {
  
  def all(): List[Post] = Nil
  
  def create(name: String, date:Date, text: String) {}
  
  def delete(id: Long) {}
  
}
