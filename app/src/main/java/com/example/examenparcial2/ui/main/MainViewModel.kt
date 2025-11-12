package com.example.examenparcial2.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.examenparcial2.data.repository.BookRepository
import com.example.examenparcial2.data.repository.Prefs

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val bookRepository = BookRepository
    private val prefs = Prefs

    private val _uiState = MutableLiveData<MainUiState>()

    val uiState: LiveData<MainUiState> = _uiState

    fun cargarDatos() {
        val libros = bookRepository.getLibros()
        val favorito = prefs.getLibroDestacado(getApplication())

        _uiState.value = MainUiState(libros = libros, libroDestacadoTitulo = favorito)
    }
}