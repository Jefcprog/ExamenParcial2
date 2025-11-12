package com.example.examenparcial2.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenparcial2.databinding.ActivityMainBinding
import com.example.examenparcial2.ui.detail.DetailActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: LibroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observarViewModel()
    }

    override fun onResume() {
        super.onResume()

        viewModel.cargarDatos()
    }

    private fun setupRecyclerView() {
        adapter = LibroAdapter { libro ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("EXTRA_LIBRO", libro)
            }
            startActivity(intent)
        }

        binding.recyclerViewLibros.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewLibros.adapter = adapter
    }

    private fun observarViewModel() {
        viewModel.uiState.observe(this) { state ->
            adapter.actualizarDatos(state.libros, state.libroDestacadoTitulo)
        }
    }
}