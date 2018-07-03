package com.sourcey.materiallogindemo

import android.content.Intent
import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView

class CaloriasActivity : AppCompatActivity() {

    internal var button2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorias)
        val imc = FloatArray(1)
        val btCalc0ular = findViewById(R.id.btCalcular) as Button

        btCalc0ular.setOnClickListener {
            val editPeso = findViewById(R.id.editPeso) as TextView
            val editAltura = findViewById(R.id.editAltura) as TextView
            val tvResultado = findViewById(R.id.tvResultado) as TextView
            val tvDescripcion = findViewById(R.id.tvDescripcion) as TextView
            //Integer.parseInt(editPeso.getText().toString());
            val altura = Integer.parseInt(editAltura.text.toString())

            imc[0] = imc[0] + altura
            if (imc != null) {

                tvResultado.text = imc[0].toString() + ""
                tvDescripcion.text = "AÑADE MÁS ALIMENTOS CALORICOS SI QUIERES"


            } else {
                tvDescripcion.text = "GRACIAS!"


            }
        }

    }
}