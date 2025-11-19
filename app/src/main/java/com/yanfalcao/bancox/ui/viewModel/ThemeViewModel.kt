package com.yanfalcao.bancox.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.yanfalcao.bancox.model.ColorThemeOptions
import com.yanfalcao.bancox.persistence.DataStoreInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeViewModel(application: Application) : AndroidViewModel(application) {
    private val _themeState = MutableStateFlow(ColorThemeOptions.System)
    val themeState: StateFlow<ColorThemeOptions> = _themeState

    init {
        getTheme()
    }

    private fun getTheme() {
        viewModelScope.launch {
            DataStoreInstance.getThemeOptionPreferences(
                getApplication(),
                DataStoreInstance.THEME_OPTION_KEY
            ).collect { themeTitle ->
                themeTitle?.let {
                    _themeState.value = ColorThemeOptions.fromTitle(it)
                }
            }
        }
    }

    fun saveTheme(theme: ColorThemeOptions) {
        viewModelScope.launch {
            DataStoreInstance.saveThemeOptionPreferences(
                getApplication(),
                DataStoreInstance.THEME_OPTION_KEY,
                theme.title
            )
        }
    }
}