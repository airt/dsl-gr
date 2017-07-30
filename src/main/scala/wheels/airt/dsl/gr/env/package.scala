package wheels.airt.dsl.gr

package object env {

  case class LangEnvContent(srcDirs: List[String] = Nil)

  class LangEnv extends EnvLike {
    override type Env = LangEnv
    override type EnvContent = LangEnvContent

    override def newContent: EnvContent = new EnvContent

    override def showLines: Seq[String] =
      Seq(s"srcDirs = ${content.srcDirs.map(s => s"'$s'").mkString("[", ", ", "]")}")
  }

  type ScalaEnv = LangEnv

  type JavaEnv = LangEnv

  case class MainEnvContent(scalaEnv: ScalaEnv = new ScalaEnv, javaEnv: JavaEnv = new JavaEnv)

  class MainEnv extends EnvLike {
    override type Env = MainEnv
    override type EnvContent = MainEnvContent

    override def newContent: EnvContent = new EnvContent

    def showLines: Seq[String] = showContents(
      "scala" -> content.scalaEnv,
      "java" -> content.javaEnv,
    )
  }

  type TestEnv = MainEnv

  case class SourceSetsEnvContent(mainEnv: MainEnv = new MainEnv, testEnv: TestEnv = new TestEnv)

  class SourceSetsEnv extends EnvLike {
    override type Env = SourceSetsEnv
    override type EnvContent = SourceSetsEnvContent

    override def newContent: EnvContent = new EnvContent

    def showLines: Seq[String] = showContents(
      "main" -> content.mainEnv,
      "test" -> content.testEnv,
    )
  }

  case class RepositoriesEnvContent(mavenLocal: Boolean = false, mavenCentral: Boolean = false)

  class RepositoriesEnv extends EnvLike {
    override type Env = RepositoriesEnv
    override type EnvContent = RepositoriesEnvContent

    override def newContent: EnvContent = new EnvContent

    def showLines: Seq[String] = {
      val attemptConsMavenLocal: List[String] => List[String] =
        if (content.mavenLocal) (::.apply[String] _).curried("mavenLocal()") else identity
      val attemptConsMavenCentral: List[String] => List[String] =
        if (content.mavenCentral) (::.apply[String] _).curried("mavenCentral()") else identity
      attemptConsMavenLocal compose attemptConsMavenCentral apply Nil
    }
  }

  case class GlobalEnvContent(
    sourceSetsEnv: SourceSetsEnv = new SourceSetsEnv,
    repositoriesEnv: RepositoriesEnv = new RepositoriesEnv,
  )

  class GlobalEnv extends EnvLike {
    override type Env = GlobalEnv
    override type EnvContent = GlobalEnvContent

    override def newContent: EnvContent = new EnvContent

    def showLines: Seq[String] = showContents(
      "sourceSets" -> content.sourceSetsEnv,
      "repositories" -> content.repositoriesEnv,
    )
  }

}
