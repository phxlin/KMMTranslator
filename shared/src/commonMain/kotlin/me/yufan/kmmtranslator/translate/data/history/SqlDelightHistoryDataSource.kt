package me.yufan.kmmtranslator.translate.data.history

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import me.yufan.kmmtranslator.core.domain.util.CommonFlow
import me.yufan.kmmtranslator.core.domain.util.toCommonFlow
import me.yufan.kmmtranslator.database.TranslateDatabase
import me.yufan.kmmtranslator.translate.domain.history.HistoryDataSource
import me.yufan.kmmtranslator.translate.domain.history.HistoryItem

class SqlDelightHistoryDataSource(
    db: TranslateDatabase
) : HistoryDataSource {

    private val queries = db.translateQueries

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList()
            .map { historyList ->
                historyList.map { history ->
                    history.toHistoryItem()
                }
            }.toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}