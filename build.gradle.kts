import org.gradle.api.tasks.Copy

plugins {
    kotlin("multiplatform") version "2.2.0"
}

repositories {
    mavenCentral()
}

kotlin {
    linuxX64 {
        binaries {
            executable {
                entryPoint = "com.akulearn.smartboard.main"
                baseName = "akulearn-smartboard"
            }
        }
    }

    sourceSets {
        getByName("commonTest").dependencies {
            implementation(kotlin("test"))
        }
    }
}

tasks.register<Copy>("packageSystemdBinary") {
    dependsOn("linkReleaseExecutableLinuxX64")
    from(layout.buildDirectory.file("bin/linuxX64/releaseExecutable/akulearn-smartboard.kexe"))
    into(layout.buildDirectory.dir("packaging/usr/local/bin"))
    rename { "akulearn-smartboard" }
}
