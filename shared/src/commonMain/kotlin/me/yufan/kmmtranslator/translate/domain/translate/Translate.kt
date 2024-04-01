package me.yufan.kmmtranslator.translate.domain.translate

import me.yufan.kmmtranslator.core.domain.language.Language
import me.yufan.kmmtranslator.core.domain.util.Resource
import me.yufan.kmmtranslator.translate.domain.history.HistoryDataSource
import me.yufan.kmmtranslator.translate.domain.history.HistoryItem

class Translate(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {

    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> {
        return try {
            val translateText = client.translate(
                fromLanguage,
                fromText,
                toLanguage
            )

            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translateText
                )
            )

            Resource.Success(translateText)

        } catch (e: TranslateException) {
            e.printStackTrace()

            Resource.Error(e)
        }
    }
}