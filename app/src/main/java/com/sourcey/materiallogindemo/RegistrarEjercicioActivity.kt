package com.sourcey.materiallogindemo

import android.content.Intent
import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_imc1.*
import kotlinx.android.synthetic.main.activity_registrar_ejercicio.*
import org.json.JSONObject

class RegistrarEjercicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_ejercicio)

        val btnGuardar = findViewById(R.id.btn_guardar) as Button
        btnGuardar.setOnClickListener {
            val tipo = findViewById(R.id.editTipoE) as TextView
            val nombreE = findViewById(R.id.editNombreE) as TextView
            val descripcion = findViewById(R.id.editDescripcion) as TextView


            val json = JSONObject()

            json.put("tipo", tipo.text)

            json.put("nombre", nombreE.text)

            json.put("descripcion", descripcion.text)

            val httpRequest = Fuel.post("http://192.168.100.11:1337/Ejercicios").body(json.toString())
            httpRequest.headers["Content-Type"] = "application/json"
            httpRequest.response{request, response, result ->
                Log.i("mensaje", request.toString())
                Log.i("mensaje", response.toString())
                Log.i("mensaje", result.toString())
            }

        }

        btn_rutina.setOnClickListener{
            v:View? -> irAActividadRutina()
        }
    }
    fun irAActividadRutina() {
        val intent = Intent(this, RutinasActivity::class.java)
        startActivity(intent)
    }
}