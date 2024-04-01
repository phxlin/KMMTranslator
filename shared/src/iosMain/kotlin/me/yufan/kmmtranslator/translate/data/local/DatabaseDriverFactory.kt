package me.yufan.kmmtranslator.translate.data.local

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlCursor
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.db.SqlPreparedStatement

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
//        return NativeSqliteDriver(
//            TranslateDatabase.Schema,
//            "translate.db"
//        )

        return Driver()
    }

    class Driver() : SqlDriver {
        override fun currentTransaction(): Transacter.Transaction? {
            TODO("Not yet implemented")
        }

        override fun execute(
            identifier: Int?,
            sql: String,
            parameters: Int,
            binders: (SqlPreparedStatement.() -> Unit)?
        ) {
            TODO("Not yet implemented")
        }

        override fun executeQuery(
            identifier: Int?,
            sql: String,
            parameters: Int,
            binders: (SqlPreparedStatement.() -> Unit)?
        ): SqlCursor {
            TODO("Not yet implemented")
        }

        override fun newTransaction(): Transacter.Transaction {
            TODO("Not yet implemented")
        }

        override fun close() {
            TODO("Not yet implemented")
        }
    }
}