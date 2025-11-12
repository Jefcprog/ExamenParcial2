package com.example.examenparcial2.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Libro(
    val titulo: String,
    val autor: String,
    val anio: Int
) : Parcelable