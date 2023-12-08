plugins {
    id("me.champeau.jmh") version "0.7.2"
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
