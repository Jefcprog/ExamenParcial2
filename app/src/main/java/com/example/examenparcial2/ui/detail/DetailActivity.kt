package com.example.examenparcial2.ui.detail

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.examenparcial2.data.model.Libro
import com.example.examenparcial2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var binding: ActivityDetailBinding
    private var libro: Libro? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        libro = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("EXTRA_LIBRO", Libro::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("EXTRA_LIBRO")
        }

        libro?.let {
            mostrarDatos(it)
            configurarBoton(it)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun mostrarDatos(libro: Libro) {
        binding.tvDetalleTitulo.text = libro.titulo
        binding.tvDetalleAutor.text = libro.autor
        binding.tvDetalleAnio.text = "Año: ${libro.anio}"
    }

    private fun configurarBoton(libro: Libro) {
        binding.btnGuardarPreferencias.setOnClickListener {
            viewModel.guardarComoDestacado(libro.titulo)

            Toast.makeText(
                this,
                "'${libro.titulo}' guardado como destacado",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}