package me.yufan.kmmtranslator.translate.data.history

import database.HistoryEntity
import me.yufan.kmmtranslator.translate.domain.history.HistoryItem

fun HistoryEntity.toHistoryItem(): HistoryItem {
    return HistoryItem(
        id = id,
        fromLanguageCode = fromLanguageCode,
        fromText = fromText,
        toLanguageCode = toLanguageCode,
        toText = toText
    )
}