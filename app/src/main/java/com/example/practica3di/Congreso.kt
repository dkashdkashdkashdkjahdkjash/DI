package com.example.practica3di

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Congreso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.congreso)

        var dias = 1
        var diasText = findViewById<TextView>(R.id.textViewDias)
        var habitacionesText = findViewById<TextView>(R.id.textViewHabitaciones)
        var habitaciones = 1
        val botonSiguiente = findViewById<Button>(R.id.button2)

        val seekBarDias = findViewById<SeekBar>(R.id.seekBar2)
        val seekBarHabitaciones = findViewById<SeekBar>(R.id.seekBar3)

        seekBarDias.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Actualiza el TextView mientras se mueve la SeekBar
                diasText.text = progress.toString()
                dias = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No se necesita implementación en este caso
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No se necesita implementación en este caso
            }
        })

        seekBarHabitaciones.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Actualiza el TextView mientras se mueve la SeekBar
                habitacionesText.text = progress.toString()
                habitaciones = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No se necesita implementación en este caso
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No se necesita implementación en este caso
            }
        })

        botonSiguiente.setOnClickListener{
            val intent3 = Intent(this, Fin::class.java)
            intent3.putExtra("Nombre",intent.getStringExtra("Nombre"))
            intent3.putExtra("telefono",intent.getStringExtra("telefono"))
            intent3.putExtra("fecha",intent.getStringExtra("fecha"))
            intent3.putExtra("tipo",intent.getStringExtra("tipo"))
            intent3.putExtra("cocina",intent.getStringExtra("cocina"))
            intent3.putExtra("personas",intent.getStringExtra("personas"))
            intent3.putExtra("dias",dias.toString())
            intent3.putExtra("habitaciones", habitaciones.toString())
            startActivity(intent3)
        }

    }
}