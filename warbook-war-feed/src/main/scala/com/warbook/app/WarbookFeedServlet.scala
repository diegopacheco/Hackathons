package com.warbook.app

import org.scalatra._
import scalate.ScalateSupport
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._

class WarbookFeedServlet extends WarbookWarFeedStack with JacksonJsonSupport{
  
  protected implicit val jsonFormats: Formats = DefaultFormats
  
  var all = List(War("Ape do Pilar", "Rua Ten. Cel. Fabricio Pilar, 27", "Porto Alegre"),
				 War("100 Dias Medicina", "Clube Hebraica", "Porto Alegre"))
  
  before() {
    contentType = formats("json")
  }
  
  get("/") {
    <html>
      <body>
        <h1>Hello, world! Rafael eh foda!!!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
  get("/wars") {
	all
  }  
  
}
