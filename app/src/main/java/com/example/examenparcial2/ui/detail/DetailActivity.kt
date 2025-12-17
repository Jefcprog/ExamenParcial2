package com.example.examenparcial2.ui.detail

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.examenparcial2.R
import com.example.examenparcial2.data.model.Libro
import com.example.examenparcial2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var binding: ActivityDetailBinding
    private var libro: Libro? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.lifecycleOwner = this // Buena práctica

        libro = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("EXTRA_LIBRO", Libro::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("EXTRA_LIBRO")
        }

        libro?.let { libroActual ->
            binding.libro = libroActual

            configurarBoton(libroActual)
        }
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