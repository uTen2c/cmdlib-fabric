object Minecraft {
    const val version = "1.17"
    const val configVersion = "1.17"
}

object Jetbrains {

    object Kotlin {
        const val version = "1.5.10"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    }
}

object Fabric {

    object Loader {
        const val version = "0.11.5"
    }

    object Loom {
        const val version = "0.8-SNAPSHOT"
    }

    object Yarn {
        const val version = "${Minecraft.version}+build.10"
    }
}