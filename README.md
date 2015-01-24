# gradle-java-plugin-example01

gradle java plugin example that uses the meta-plugin 'java-gradle-plugin' (from the build.gradle).

The plugin-consumer sub-project uses the plugin

Plugin archive is published to localMaven

build.gradle to bootstrap plugin project

```groovy
plugins {
  id 'java-gradle-plugin'
  id 'maven'
}

group = 'griffio.gradle'
version = '1.0-SNAPSHOT'

uploadArchives {

  return repositories() {
    mavenLocal()
  }

}
```

