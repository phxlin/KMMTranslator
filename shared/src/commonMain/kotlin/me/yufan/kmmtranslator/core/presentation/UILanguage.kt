package me.yufan.kmmtranslator.core.presentation

import me.yufan.kmmtranslator.core.domain.language.Language

expect class UILanguage {
    val language: Language

    companion object {
        fun byCode(langCode: String): UILanguage
        val allLanguages: List<UILanguage>
    }
}