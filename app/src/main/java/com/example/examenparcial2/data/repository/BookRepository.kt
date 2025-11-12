package com.example.examenparcial2.data.repository

import com.example.examenparcial2.data.model.Libro

object BookRepository {

    fun getLibros(): List<Libro> {
        return listOf(
            Libro("Cien años de soledad", "Gabriel García Márquez", 1967),
            Libro("El señor de los anillos", "J.R.R. Tolkien", 1954),
            Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605),
            Libro("1984", "George Orwell", 1949),
            Libro("Un mundo feliz", "Aldous Huxley", 1932),
            Libro("Orgullo y prejuicio", "Jane Austen", 1813),
            Libro("Crimen y castigo", "Fiódor Dostoyevski", 1866),
            Libro("La Odisea", "Homero", -800),
            Libro("El gran Gatsby", "F. Scott Fitzgerald", 1925),
            Libro("Moby Dick", "Herman Melville", 1851),
            Libro("En busca del tiempo perdido", "Marcel Proust", 1913)
        )
    }
}