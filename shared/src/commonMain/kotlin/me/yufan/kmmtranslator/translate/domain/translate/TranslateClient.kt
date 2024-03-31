package me.yufan.kmmtranslator.translate.domain.translate

import me.yufan.kmmtranslator.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}