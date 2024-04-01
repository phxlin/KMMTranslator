package me.yufan.kmmtranslator.android.translate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import me.yufan.kmmtranslator.translate.domain.history.HistoryDataSource
import me.yufan.kmmtranslator.translate.domain.translate.Translate
import me.yufan.kmmtranslator.translate.presentation.TranslateEvent
import me.yufan.kmmtranslator.translate.presentation.TranslateViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidTranslateViewModel @Inject constructor(
    private val translate: Translate,
    private val historyDataSource: HistoryDataSource
) : ViewModel() {

    private val viewModel by lazy {
        TranslateViewModel(
            translate = translate,
            historyDataSource = historyDataSource,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: TranslateEvent) {
        viewModel.onEvent(event)
    }
}