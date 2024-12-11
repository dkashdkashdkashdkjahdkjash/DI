package com.example.practica3di

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroupTipo: RadioGroup
    private lateinit var radioGroupCocina: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val personas = findViewById<TextView>(R.id.textViewPersonas)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        seekBar.min = 1
        seekBar.max = 99
        val nombre = findViewById<TextView>(R.id.editTextNombre)
        val telefono = findViewById<TextView>(R.id.editTextTelefono)
        var tipo = ""
        var cocina = ""
        var contador = 0

        val boton = findViewById<Button>(R.id.button)

        radioGroupTipo = findViewById(R.id.radioGroupTipo)
        radioGroupCocina = findViewById(R.id.radioGroupCocina)

        radioGroupTipo.setOnCheckedChangeListener { _, selectedRadioButtonId ->
            if (selectedRadioButtonId == R.id.radioButton3){
                tipo = "Banquete"
            }
            if (selectedRadioButtonId == R.id.radioButton2){
                tipo = "Jornada"
            }
            if (selectedRadioButtonId == R.id.radioButton){
                tipo = "Congreso"
                contador = 1
            }else{
                contador = 0
            }
        }

        radioGroupCocina.setOnCheckedChangeListener { _, selectedRadioButtonId ->
            if(selectedRadioButtonId == R.id.radioButton7){
                cocina = "Bufé"
            }
            if(selectedRadioButtonId == R.id.radioButton6){
                cocina = "Carta"
            }
            if(selectedRadioButtonId == R.id.radioButton5){
                cocina = "Cita con el chef"
            }
            if(selectedRadioButtonId == R.id.radioButton4){
                cocina = "No precisa"
            }
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            /**
             * Método que se llama cada vez que cambio el progreso
             * seekBar contiene la referencia a la seekBar
             * progress contiene el valor actual de la seekbar
             * fromUser indica si el cambio lo ha producido el usuario al arastar la barra
             */
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Actualiza el TextView mientras se mueve la SeekBar
                personas.text = progress.toString()
            }

            /**
             * Se llama caundo el usuario comienza a tocar la seekbar
             */
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No se necesita implementación en este caso
            }

            /**
             * Se llama cuando el usuario deja de tocarla
             */
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No se necesita implementación en este caso
            }
        })

        boton.setOnClickListener{
            if(contador == 1){
                val intent1 = Intent(this, Congreso::class.java)
                intent1.putExtra("Nombre",nombre.text.toString())
                intent1.putExtra("telefono",telefono.text.toString())
                intent1.putExtra("tipo",tipo.toString())
                intent1.putExtra("cocina",cocina.toString())
                intent1.putExtra("personas",personas.text.toString())
                startActivity(intent1)
            }else{
                val intent2 = Intent(this, Fin::class.java)
                intent2.putExtra("Nombre",nombre.text.toString())
                intent2.putExtra("telefono",telefono.text.toString())
                intent2.putExtra("tipo",tipo.toString())
                intent2.putExtra("cocina",cocina.toString())
                intent2.putExtra("personas",personas.text.toString())
                startActivity(intent2)
            }
        }
    }
}