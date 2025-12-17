package com.example.examenparcial2.data.repository

import android.content.Context
import android.content.SharedPreferences

object Prefs {
    private const val PREFS_NAME = "LibrosAppPrefs"
    private const val KEY_LIBRO_DESTACADO = "libro_destacado"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun guardarLibroDestacado(context: Context, titulo: String) {
        val editor = getPrefs(context).edit()
        editor.putString(KEY_LIBRO_DESTACADO, titulo)
        editor.apply()
    }

    fun getLibroDestacado(context: Context): String? {
        return getPrefs(context).getString(KEY_LIBRO_DESTACADO, null)
    }
}