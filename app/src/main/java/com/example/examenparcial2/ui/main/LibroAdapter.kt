package com.example.examenparcial2.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenparcial2.data.model.Libro
import com.example.examenparcial2.databinding.ItemLibroBinding

class LibroAdapter(
    private val onClick: (Libro) -> Unit
) : RecyclerView.Adapter<LibroAdapter.LibroViewHolder>() {

    private var libros: List<Libro> = emptyList()
    private var libroFavoritoTitulo: String? = null

    @SuppressLint("NotifyDataSetChanged")
    fun actualizarDatos(nuevosLibros: List<Libro>, favorito: String?) {
        this.libros = nuevosLibros
        this.libroFavoritoTitulo = favorito
        notifyDataSetChanged()
    }

    inner class LibroViewHolder(val binding: ItemLibroBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(libro: Libro) {
            binding.libro = libro

            binding.esFavorito = (libro.titulo == libroFavoritoTitulo)

            binding.root.setOnClickListener {
                onClick(libro)
            }

            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val binding = ItemLibroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LibroViewHolder(binding)
    }

    override fun getItemCount(): Int = libros.size

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        holder.bind(libros[position])
    }
}