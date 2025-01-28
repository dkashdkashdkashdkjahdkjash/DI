package com.example.practica3di

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Fin : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fin)

        val nombre = findViewById<TextView>(R.id.textViewNombreD)
        val telefono = findViewById<TextView>(R.id.textViewTelefonoD)
        val fecha = findViewById<TextView>(R.id.textViewFechaD)
        val tipo = findViewById<TextView>(R.id.textViewTipoD)
        val cocina = findViewById<TextView>(R.id.textViewCocinaD)
        val pesonas = findViewById<TextView>(R.id.textViewPersonasD)
        val dias = findViewById<TextView>(R.id.textViewDiasD)
        val habitaciones = findViewById<TextView>(R.id.textViewHabitacionesD)

        nombre.text = intent.getStringExtra("Nombre")
        telefono.text = intent.getStringExtra("telefono")
        fecha.text = intent.getStringExtra("fecha")
        tipo.text = intent.getStringExtra("tipo")
        cocina.text = intent.getStringExtra("cocina")
        pesonas.text = intent.getStringExtra("personas")
        dias.text = intent.getStringExtra("dias")
        habitaciones.text = intent.getStringExtra("habitaciones")
    }

}