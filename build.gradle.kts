import net.fabricmc.loom.task.RemapJarTask
import net.fabricmc.loom.task.RemapSourcesJarTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Jetbrains.Kotlin.version
    id("fabric-loom") version Fabric.Loom.version
    `maven-publish`
}

base {
    archivesBaseName = "cmdlib-fabric"
    project.group = "dev.uten2c"
    version = Project.version
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.getByName<ProcessResources>("processResources") {
    filesMatching("fabric.mod.json") {
        expand(mutableMapOf("version" to Project.version))
    }
}

repositories {
    maven("http://maven.fabricmc.net") {
        name = "Fabric"
    }
    maven("https://libraries.minecraft.net/") {
        name = "Mojang"
    }
    maven("https://kotlin.bintray.com/kotlinx/") {
        name = "KotlinX"
    }
    jcenter()
    mavenLocal()
}

fun DependencyHandlerScope.includeAndExpose(dep: Any) {
    modApi(dep)
    include(dep)
}

dependencies {
    minecraft(group = "com.mojang", name = "minecraft", version = Minecraft.version)
    mappings(group = "net.fabricmc", name = "yarn", version = Fabric.Yarn.version, classifier = "v2")

    modImplementation("net.fabricmc:fabric-loader:${Fabric.Loader.version}")

    includeAndExpose(kotlin("stdlib", Jetbrains.Kotlin.version))
}

val remapJar = tasks.getByName<RemapJarTask>("remapJar")
val remapSourcesJar = tasks.getByName<RemapSourcesJarTask>("remapSourcesJar")

val sourcesJar = tasks.create<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.base.archivesBaseName
            version = project.version.toString()

            artifact(remapJar) {
                builtBy(remapJar)
            }
            artifact(sourcesJar) {
                builtBy(remapSourcesJar)
            }
        }
    }
    repositories {
        maven {
            url = uri("${System.getProperty("user.home")}/maven-repo")
        }
    }
}