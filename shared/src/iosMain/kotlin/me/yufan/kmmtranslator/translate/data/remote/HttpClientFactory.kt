package me.yufan.kmmtranslator.translate.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

actual class HttpClientFactory {
    actual fun create(): HttpClient {
        // Darwin
        return HttpClient() {
            install(ContentNegotiation) {
                json()
            }
        }
    }
}