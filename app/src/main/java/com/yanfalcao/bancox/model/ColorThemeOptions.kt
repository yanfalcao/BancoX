package com.yanfalcao.bancox.model

import android.os.Build

enum class ColorThemeOptions(val title: String) {
    Light("Tema Claro"),
    Dark("Tema Escuro"),
    System("Automático"),
    Dynamic("Dynamic Color");

    companion object {
        fun fromTitle(title: String): ColorThemeOptions {
            return entries.firstOrNull { it.title == title } ?: System
        }

        /***
         * Returns a list of available theme options, excluding Dynamic Color on devices
         * running Android versions lower than S (API 31).
         */
        fun getOptions(): List<ColorThemeOptions> {
            return entries.toList().filter {
                if ((it == Dynamic) && (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S))
                    true
                else
                    it != Dynamic
            }
        }
    }
}