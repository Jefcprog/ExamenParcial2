package com.example.examenparcial2.ui.main
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.examenparcial2.R
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
            binding.tvTitulo.text = libro.titulo
            binding.tvAutor.text = libro.autor

            if (libro.titulo == libroFavoritoTitulo) {
                binding.itemContainer.setBackgroundColor(
                    ContextCompat.getColor(binding.root.context, R.color.color_destacado)
                )
            } else {
                binding.itemContainer.setBackgroundColor(
                    ContextCompat.getColor(binding.root.context, R.color.color_transparente)
                )
            }

            binding.root.setOnClickListener {
                onClick(libro)
            }
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