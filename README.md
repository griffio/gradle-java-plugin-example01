# gradle-java-plugin-example01


A Gradle Java plugin example that uses the meta-plugin 'java-gradle-plugin' (applied to the build.gradle).

The plugin-consumer/build.gradle sub-project uses the plugin and can execute the taksk.

Plugin archive is published to localMaven.

---

Reference build.gradle to bootstrap plugin project

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

