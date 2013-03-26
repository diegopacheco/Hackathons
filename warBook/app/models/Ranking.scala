package models

case class Ranking(
  id: Long, 
  warrior: String,
  wars: List[String]
)

object Ranking {
  
  def all(): List[Ranking] = List( new Ranking(1, "Cuervo", List("opiniao", "farms", "preto ze"))
		  						 , new Ranking(2, "CaoPeao", List("pinguim"))
  								 , new Ranking(3, "Borges", List("alternativo"))
  								 , new Ranking(4, "Pacheco", List("farms"))
                                 , new Ranking(5, "Jeff Koala", List("preto ze"))
		  						 ) 
  
  def create(name: String) {}
  
  def delete(id: Long) {}
  
}