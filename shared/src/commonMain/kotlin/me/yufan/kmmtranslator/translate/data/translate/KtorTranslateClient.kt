package me.yufan.kmmtranslator.translate.data.translate

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.utils.io.errors.IOException
import me.yufan.kmmtranslator.NetworkConstants
import me.yufan.kmmtranslator.core.domain.language.Language
import me.yufan.kmmtranslator.translate.domain.translate.TranslateClient
import me.yufan.kmmtranslator.translate.domain.translate.TranslateError
import me.yufan.kmmtranslator.translate.domain.translate.TranslateException

class KtorTranslateClient(
    private val httpClient: HttpClient
) : TranslateClient {

    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String {
        val result = try {
            httpClient.post {
                url(NetworkConstants.BASE_URL + "/translate")
                contentType(ContentType.Application.Json)
                setBody(
                    TranslateDto(
                        textToTranslate = fromText,
                        sourceLanguageCode = fromLanguage.langCode,
                        targetLanguage = toLanguage.langCode
                    )
                )
            }

        } catch (e: IOException) {
            throw TranslateException(TranslateError.SERVICE_UNAVAILABLE)
        }

        when (result.status.value) {
            in 200..299 -> Unit
            500 -> throw TranslateException(TranslateError.SERVER_ERROR)
            in 400..499 -> throw TranslateException(TranslateError.CLIENT_ERROR)
            else -> throw TranslateException(TranslateError.UNKNOWN_ERROR)
        }

        return try {
            result.body<TranslatedDto>().translatedText
        } catch (e: Exception) {
            throw TranslateException(TranslateError.SERVER_ERROR)
        }
    }
}