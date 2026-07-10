package com.akulearn.smartboard

data class RuntimeConfig(
    val hubUrl: String,
    val logLevel: String,
    val display: String,
    val xAuthority: String,
)

object RuntimeConfigLoader {
    private const val DEFAULT_HUB_URL = "http://hub.local:8000"
    private const val DEFAULT_LOG_LEVEL = "INFO"
    private const val DEFAULT_DISPLAY = ":0"
    private const val DEFAULT_XAUTHORITY = "/home/aku/.Xauthority"

    fun fromEnvironment(environment: Map<String, String>): RuntimeConfig = RuntimeConfig(
        hubUrl = environment["HUB_URL"].orEmpty().ifBlank { DEFAULT_HUB_URL },
        logLevel = environment["LOG_LEVEL"].orEmpty().ifBlank { DEFAULT_LOG_LEVEL },
        display = environment["DISPLAY"].orEmpty().ifBlank { DEFAULT_DISPLAY },
        xAuthority = environment["XAUTHORITY"].orEmpty().ifBlank { DEFAULT_XAUTHORITY },
    )
}
