plugins {
	kotlin("jvm") version "1.7.20"
	kotlin("plugin.serialization") version "1.7.20"
	id("com.utopia-rise.godot-kotlin-jvm") version "0.6.0-3.5.2"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
}

sourceSets.main {
	java.srcDirs("scripts/", "scripts/")
}