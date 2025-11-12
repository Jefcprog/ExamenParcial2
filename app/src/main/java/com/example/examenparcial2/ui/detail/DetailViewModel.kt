package com.example.examenparcial2.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.examenparcial2.data.repository.Prefs

class DetailViewModel(app: Application) : AndroidViewModel(app) {

    private val prefs = Prefs

    fun guardarComoDestacado(titulo: String) {
        prefs.guardarLibroDestacado(getApplication(), titulo)
    }
}