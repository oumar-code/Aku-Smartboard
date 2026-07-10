package com.akulearn.smartboard

import kotlinx.cinterop.toKString
import platform.posix.getenv

private fun env(name: String): String? = getenv(name)?.toKString()

private fun currentEnvironment(): Map<String, String> {
    val keys = listOf("HUB_URL", "LOG_LEVEL", "DISPLAY", "XAUTHORITY")
    return keys.mapNotNull { key -> env(key)?.let { key to it } }.toMap()
}

fun main() {
    val config = RuntimeConfigLoader.fromEnvironment(currentEnvironment())
    val app = SmartboardApp(config)

    println("Starting Aku SmartBoard client...")
    println(app.render())

    while (true) {
        print("> ")
        val command = readlnOrNull()?.trim()?.lowercase() ?: break
        when (command) {
            "home" -> app.navigateTo(SmartboardScreen.HOME)
            "classes" -> app.navigateTo(SmartboardScreen.CLASSES)
            "settings" -> app.navigateTo(SmartboardScreen.SETTINGS)
            "status" -> println("SmartBoard is running.")
            "quit", "exit" -> {
                println("Shutting down Aku SmartBoard.")
                return
            }
            else -> {
                println("Unknown command: $command")
                continue
            }
        }
        println(app.render())
    }
}
