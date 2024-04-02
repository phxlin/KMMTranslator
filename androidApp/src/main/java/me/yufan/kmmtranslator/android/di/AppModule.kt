package me.yufan.kmmtranslator.android.di

import android.app.Application
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import me.yufan.kmmtranslator.database.TranslateDatabase
import me.yufan.kmmtranslator.translate.data.history.SqlDelightHistoryDataSource
import me.yufan.kmmtranslator.translate.data.local.DatabaseDriverFactory
import me.yufan.kmmtranslator.translate.data.remote.HttpClientFactory
import me.yufan.kmmtranslator.translate.data.translate.KtorTranslateClient
import me.yufan.kmmtranslator.translate.domain.history.HistoryDataSource
import me.yufan.kmmtranslator.translate.domain.translate.Translate
import me.yufan.kmmtranslator.translate.domain.translate.TranslateClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return SqlDelightHistoryDataSource(TranslateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): Translate {
        return Translate(client, dataSource)
    }
}