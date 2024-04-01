package me.yufan.kmmtranslator.translate.domain.history

import me.yufan.kmmtranslator.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}