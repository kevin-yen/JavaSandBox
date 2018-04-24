# JavaSandBox

I use this this repository to experiment with random pieces of Java code

This branch is used to demonstrate the use of Java, Selenium, and Cucumber

## Basic Usage

Download and start a Liferay Portal bundle

Then run `./gradlew test`

## Advanced Usage

### Specifying Browser

You can specify the browser used by the option `-Pbrowser=[browser]`

### Changing Versions

To change the Selenium version or web driver versions, first copy gradle.properties and name it gradle-local.properties

Then you can change the versions inside gradle-local.properties to your desired version