package com.example.adivina

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Variable para almacenar el número aleatorio
    private var numeroAleatorio = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar componentes de la vista
        val editTextNumero = findViewById<EditText>(R.id.numero_ingresado)
        val botonAdivinar = findViewById<Button>(R.id.boton_adivinar)
        val textViewResultado = findViewById<TextView>(R.id.resultado)

        // Generar un número aleatorio entre 1 y 100
        generarNuevoNumeroAleatorio()

        // Configurar acción del botón
        botonAdivinar.setOnClickListener {
            // Leer el número ingresado por el usuario
            val numeroIngresado = editTextNumero.text.toString().toIntOrNull()

            if (numeroIngresado == null) {
                textViewResultado.text = "Por favor, ingresa un número válido."
            } else {
                // Comparar el número ingresado con el número aleatorio
                when {
                    numeroIngresado < numeroAleatorio -> {
                        textViewResultado.text = "El número es más alto. ¡Intenta de nuevo!"
                    }
                    numeroIngresado > numeroAleatorio -> {
                        textViewResultado.text = "El número es más bajo. ¡Intenta de nuevo!"
                    }
                    else -> {
                        textViewResultado.text = "¡Felicidades! Adivinaste el número."
                        // Generar un nuevo número aleatorio para jugar otra vez
                        generarNuevoNumeroAleatorio()
                    }
                }
            }

            // Limpiar el campo de texto después de presionar el botón
            editTextNumero.text.clear()
        }
    }

    // Función para generar un nuevo número aleatorio
    private fun generarNuevoNumeroAleatorio() {
        numeroAleatorio = Random.nextInt(1, 101) // Generar número entre 1 y 100
    }
}
