package com.example.examenparcial2.ui.main

import com.example.examenparcial2.data.model.Libro

data class MainUiState(
    val libros: List<Libro> = emptyList(),
    val libroDestacadoTitulo: String? = null
)