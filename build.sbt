name := "Liftweb_VUE"
organization := "com.besterdesigns"
version := "0.0.1"

scalaVersion := "2.12.8"

resolvers ++= Seq(
  "Maven Repo" at "http://repo1.maven.org/maven2",
  "repo2_maven_org" at "http://repo2.maven.org/maven2",
  "Scala-Tools Dependencies Repository for Releases" at "http://scala-tools.org/repo-releases"
)

scalacOptions := "-deprecation" :: "-unchecked" :: "-feature" :: "-language:postfixOps" :: "-language:implicitConversions" :: Nil
libraryDependencies ++= {
  val liftVersion = "3.3.0"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "ch.qos.logback"    % "logback-classic"     % "1.2.3",
    "org.eclipse.jetty" % "jetty-webapp"        % "9.4.18.v20190429"  % "container,test",
    "org.eclipse.jetty" % "jetty-plus"          % "9.4.18.v20190429"  % "container,test", // For Jetty Config
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar")    
  )
}

enablePlugins(JettyPlugin)
containerPort := 8080
