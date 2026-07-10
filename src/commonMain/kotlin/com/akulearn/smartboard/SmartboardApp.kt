package com.akulearn.smartboard

enum class SmartboardScreen {
    HOME,
    CLASSES,
    SETTINGS,
}

class SmartboardApp(private val config: RuntimeConfig) {
    private var currentScreen: SmartboardScreen = SmartboardScreen.HOME

    fun navigateTo(screen: SmartboardScreen) {
        currentScreen = screen
    }

    fun render(): String = buildString {
        appendLine("Aku SmartBoard")
        appendLine("============")
        appendLine("Active screen: ${currentScreen.name}")
        appendLine()
        appendLine("Hub: ${config.hubUrl}")
        appendLine("Log Level: ${config.logLevel}")
        appendLine("Display: ${config.display}")
        appendLine("XAuthority: ${config.xAuthority}")
        appendLine()
        appendLine("Commands: [home] [classes] [settings] [status] [quit]")
    }
}
