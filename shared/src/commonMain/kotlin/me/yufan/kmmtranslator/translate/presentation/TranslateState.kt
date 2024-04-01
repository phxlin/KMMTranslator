package me.yufan.kmmtranslator.translate.presentation

import me.yufan.kmmtranslator.core.presentation.UILanguage
import me.yufan.kmmtranslator.translate.domain.translate.TranslateError

data class TranslateState(
    val fromText: String = "",
    val toText: String? = null,
    val isTranslating: Boolean = false,
    val fromLanguage: UILanguage = UILanguage.byCode("en"),
    val toLanguage: UILanguage = UILanguage.byCode("zh"),
    val isChoosingFromLanguage: Boolean = false,
    val isChoosingToLanguage: Boolean = false,
    val error: TranslateError? = null,
    val historyItemList: List<UIHistoryItem> = emptyList()
)
