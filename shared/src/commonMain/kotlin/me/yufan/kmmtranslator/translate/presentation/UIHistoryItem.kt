package me.yufan.kmmtranslator.translate.presentation

import me.yufan.kmmtranslator.core.presentation.UILanguage

data class UIHistoryItem(
    val id: Long,
    val fromText: String,
    val toText: String,
    val fromLanguage: UILanguage,
    val toLanguage: UILanguage
)