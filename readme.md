# dsl-gr

[![Build Status][build-badge]][build-status]
[![Test Coverage][coverage-badge]][coverage-result]

## usage

```scala
import wheels.dsl.gr._

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

println(globalEnv)
println(globalEnv.show)
```

## license

MIT

[build-badge]: https://img.shields.io/travis/airt/dsl-gr.svg
[build-status]: https://travis-ci.org/airt/dsl-gr
[coverage-badge]: https://img.shields.io/coveralls/airt/dsl-gr.svg
[coverage-result]: https://coveralls.io/github/airt/dsl-gr
