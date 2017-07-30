package wheels.airt.dsl

package object gr {

  import wheels.airt.dsl.gr.env._
  import wheels.airt.dsl.gr.fn._

  implicit object implicitLangEnv extends LangEnv

  implicit object implicitMainEnv extends MainEnv

  implicit object implicitSourceSetsEnv extends SourceSetsEnv

  implicit object implicitRepositoriesEnv extends RepositoriesEnv

  implicit object implicitGlobalEnv extends GlobalEnv

  object srcDirs extends SrcDirsFunction

  object scala extends ScalaFunction

  object java extends JavaFunction

  object main extends MainFunction

  object test extends TestFunction

  object sourceSets extends SourceSetsFunction

  object mavenLocal extends MavenLocalFunction

  object mavenCentral extends MavenCentralFunction

  object repositories extends RepositoriesFunction

  type GlobalEnv = env.GlobalEnv

  def globalEnv: GlobalEnv = implicitly[GlobalEnv]

}
