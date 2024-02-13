plugins {
    kotlin("jvm") version "1.9.22"
}

group = "xandeel.hachis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/") // Repositorio Maven de PaperMC
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Spigot 1.8.8
    implementation("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")

    // Lombok
    implementation("org.projectlombok:lombok:1.18.24")

    // LuckPerms
    implementation("me.lucko:helper:5.6.13")
    implementation("com.mojang:authlib:1.5.25") // Dependencia para com.mojang.authlib.properties
    implementation("commons-codec:commons-codec:1.15") // Dependencia para org.apache.commons.codec.binary
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(19)
}