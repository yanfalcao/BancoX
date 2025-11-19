package com.yanfalcao.bancox.persistence

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object DataStoreInstance {

    private val Context.dataStore: DataStore<Preferences>
            by preferencesDataStore(name = "settings")

    val THEME_OPTION_KEY = stringPreferencesKey("theme_option_key")


    suspend fun saveThemeOptionPreferences(
        context: Context, key:
        Preferences.Key<String>, value: String
    ) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    fun getThemeOptionPreferences(
        context: Context, key:
        Preferences.Key<String>
    ): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[key]
        }
    }
}