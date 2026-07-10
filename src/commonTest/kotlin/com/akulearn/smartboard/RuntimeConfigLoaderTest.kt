package com.akulearn.smartboard

import kotlin.test.Test
import kotlin.test.assertEquals

class RuntimeConfigLoaderTest {
    @Test
    fun `uses defaults when environment is missing`() {
        val config = RuntimeConfigLoader.fromEnvironment(emptyMap())

        assertEquals("http://hub.local:8000", config.hubUrl)
        assertEquals("INFO", config.logLevel)
        assertEquals(":0", config.display)
        assertEquals("/home/aku/.Xauthority", config.xAuthority)
    }

    @Test
    fun `uses environment values when provided`() {
        val config = RuntimeConfigLoader.fromEnvironment(
            mapOf(
                "HUB_URL" to "http://127.0.0.1:9000",
                "LOG_LEVEL" to "DEBUG",
                "DISPLAY" to ":1",
                "XAUTHORITY" to "/tmp/custom.xauth",
            )
        )

        assertEquals("http://127.0.0.1:9000", config.hubUrl)
        assertEquals("DEBUG", config.logLevel)
        assertEquals(":1", config.display)
        assertEquals("/tmp/custom.xauth", config.xAuthority)
    }
}
