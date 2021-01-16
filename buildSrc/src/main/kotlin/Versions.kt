object Minecraft {
    const val version = "1.16.5"
    const val configVersion = "1.16.5"
}

object Jetbrains {

    object Kotlin {
        const val version = "1.4.21"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    }
}

object Fabric {

    object Loader {
        const val version = "0.11.1"
    }

    object Loom {
        const val version = "0.5-SNAPSHOT"
    }

    object Yarn {
        const val version = "${Minecraft.version}+build.1"
    }
}