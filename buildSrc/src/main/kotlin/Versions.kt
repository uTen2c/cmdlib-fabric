object Minecraft {
    const val version = "20w51a"
    const val configVersion = "1.17-alpha.20.51.a"
}

object Jetbrains {

    object Kotlin {
        const val version = "1.4.21"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    }
}

object Fabric {

    object Loader {
        const val version = "0.10.8"
    }

    object Loom {
        const val version = "0.5-SNAPSHOT"
    }

    object Yarn {
        const val version = "${Minecraft.version}+build.5"
    }
}