plugins {
	kotlin("jvm") version "1.7.20"
	id("com.utopia-rise.godot-kotlin-jvm") version "0.6.0-3.5.2"
}

repositories {
	mavenCentral()
}

sourceSets.main {
	java.srcDirs("scripts/java", "scripts/kotlin")
}