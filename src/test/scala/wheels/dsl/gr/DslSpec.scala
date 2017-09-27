package wheels.dsl.gr

import org.scalatest._

class DslSpec extends FreeSpec with Matchers {

  "dsl" - {
    "should work correctly" in {
      def run(): GlobalEnv = {

        sourceSets {
          main {
            scala {
              srcDirs := List("src/main/scala", "src/main/java")
            }
            java {
              srcDirs := List()
            }
          }
          test {
            scala {
              srcDirs := List("src/test/scala", "src/test/java")
            }
            java {
              srcDirs := List()
            }
          }
        }

        repositories {
          mavenLocal()
          mavenCentral()
        }

      }

      val expected =
        """
          |sourceSets {
          |  main {
          |    scala {
          |      srcDirs = ['src/main/scala', 'src/main/java']
          |    }
          |    java {
          |      srcDirs = []
          |    }
          |  }
          |  test {
          |    scala {
          |      srcDirs = ['src/test/scala', 'src/test/java']
          |    }
          |    java {
          |      srcDirs = []
          |    }
          |  }
          |}
          |repositories {
          |  mavenLocal()
          |  mavenCentral()
          |}
        """.stripMargin.trim

      run()

      globalEnv.show shouldBe expected
    }
  }

}
