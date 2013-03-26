import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "warBook"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "com.andersen-gott" %% "scravatar" % "1.0.2",
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // cookers      
  )

}
