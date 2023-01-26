package com.example.ej9pantallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.ej9pantallaresumen.databinding.ActivityPersonajeBinding
import kotlin.random.Random

class Personaje : AppCompatActivity() {
    private lateinit var binding: ActivityPersonajeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonajeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val raza = intent.getStringExtra("raza")
        val imagenR = intent.getIntExtra("imagenR", 0)
        val clase = intent.getStringExtra("clase")
        val imagenC = intent.getIntExtra("imagenC", 0)

        binding.textView2.text = "Raza: $raza"
        binding.imageView3.setImageResource(imagenR)
        binding.textView.text = "Clase: $clase"
        binding.imageView2.setImageResource(imagenC)
        binding.textView3.text = "Fuerza: ${Random.nextInt(10, 15)}\nDefensa: ${
            Random.nextInt(
                1,
                5
            )
        }\nTamaño de la mochila: 100\nVida: 200\nMonedero: Vacio"

        binding.editTextTextPersonName.addTextChangedListener {
            if (binding.editTextTextPersonName.text.isNotEmpty()) {
                binding.button7.isEnabled = true
            }
        }

        binding.button6.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.button7.setOnClickListener {
            Intent(this, MainActivity2::class.java).also {
                startActivity(it)
            }
        }
    }
}