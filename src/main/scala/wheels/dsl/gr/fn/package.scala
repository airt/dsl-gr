package wheels.dsl.gr

import env._

package object fn {

  trait SrcDirsFunction {
    def :=(srcDirs: List[String])(implicit env: LangEnv): LangEnv = {
      env.content = env.content copy (srcDirs = srcDirs)
      env
    }
  }

  trait ScalaFunction {
    def apply(scalaEnv: ScalaEnv)(implicit env: MainEnv): MainEnv = {
      env.content = env.content copy (scalaEnv = scalaEnv.dupAndRenew())
      env
    }
  }

  trait JavaFunction {
    def apply(javaEnv: JavaEnv)(implicit env: MainEnv): MainEnv = {
      env.content = env.content copy (javaEnv = javaEnv.dupAndRenew())
      env
    }
  }

  trait MainFunction {
    def apply(mainEnv: MainEnv)(implicit env: SourceSetsEnv): SourceSetsEnv = {
      env.content = env.content copy (mainEnv = mainEnv.dupAndRenew())
      env
    }
  }

  trait TestFunction {
    def apply(testEnv: TestEnv)(implicit env: SourceSetsEnv): SourceSetsEnv = {
      env.content = env.content copy (testEnv = testEnv.dupAndRenew())
      env
    }
  }

  trait SourceSetsFunction {
    def apply(sourceSetsEnv: SourceSetsEnv)(implicit env: GlobalEnv): GlobalEnv = {
      env.content = env.content copy (sourceSetsEnv = sourceSetsEnv.dupAndRenew())
      env
    }
  }

  trait MavenLocalFunction {
    def apply()(implicit env: RepositoriesEnv): RepositoriesEnv = {
      env.content = env.content copy (mavenLocal = true)
      env
    }
  }

  trait MavenCentralFunction {
    def apply()(implicit env: RepositoriesEnv): RepositoriesEnv = {
      env.content = env.content copy (mavenCentral = true)
      env
    }
  }

  trait RepositoriesFunction {
    def apply(repositoriesEnv: RepositoriesEnv)(implicit env: GlobalEnv): GlobalEnv = {
      env.content = env.content copy (repositoriesEnv = repositoriesEnv.dupAndRenew())
      env
    }
  }

}
