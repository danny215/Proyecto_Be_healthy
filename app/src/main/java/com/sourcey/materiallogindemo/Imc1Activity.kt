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
import org.json.JSONObject

class Imc1Activity : AppCompatActivity() {

    internal var button2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc1)
        var imc: Int
        imc = 0
        val btCalc0ular = findViewById(R.id.btCalcular) as Button
        btCalc0ular.setOnClickListener {
            val nombre = findViewById(R.id.editNombre) as TextView
            val apellido = findViewById(R.id.editApellido) as TextView
            val fechaUso = findViewById(R.id.editFecha) as TextView
            val editPeso = findViewById(R.id.editPeso) as TextView
            val editAltura = findViewById(R.id.editAltura) as TextView
            var tvResultado = findViewById(R.id.tvResultado) as TextView
            val tvDescripcion = findViewById(R.id.tvDescripcion) as TextView
            val peso = Integer.parseInt(editPeso.text.toString())
            val altura = java.lang.Float.parseFloat(editAltura.text.toString())

            val json = JSONObject()

            json.put("nombre", nombre.text)

            json.put("apellido", apellido.text)

            json.put("fechaUso", fechaUso.text)

            json.put("peso", peso)

            json.put("altura", altura)


            imc = (peso / (altura * altura)).toInt()
            tvResultado.text = imc.toString()

            if (imc < 18.5) {
               // tvDescripcion.text = "Desnutricion:!NECESITA COMER MÁS PERO SALUDABLE Y HACER EJERCICIO PARA SUBIR DE PESO!"
                json.put("descripcion", "Desnutricion:!NECESITA COMER MÁS PERO SALUDABLE Y HACER EJERCICIO PARA SUBIR DE PESO!")

                json.put("resultado", tvResultado.text.toString().toInt())

                val httpRequest = Fuel.post("http://172.29.64.36:1337/Datos").body(json.toString())
                httpRequest.headers["Content-Type"] = "application/json"
                httpRequest.response{request, response, result ->
                    Log.i("mensaje", request.toString())
                    Log.i("mensaje", response.toString())
                    Log.i("mensaje", result.toString())
                }
            } else {
                if (imc < 25) {
                   // tvDescripcion.text = "Peso adecuado:!SIGA COMIENDO Y HACIENDO EJERCICIO ADECUADAMENTE!"
                    json.put("descripcion", "Peso adecuado:!SIGA COMIENDO Y HACIENDO EJERCICIO ADECUADAMENTE!")

                    json.put("resultado", tvResultado.text.toString().toInt())
                    val httpRequest = Fuel.post("http://172.29.64.36:1337/Datos").body(json.toString())
                    httpRequest.headers["Content-Type"] = "application/json"
                    httpRequest.response{request, response, result ->
                        Log.i("mensaje", request.toString())
                        Log.i("mensaje", response.toString())
                        Log.i("mensaje", result.toString())
                    }
                } else {
                    if (imc < 30) {
                        //tvDescripcion.text = "Sobrepeso:!ALIMENTATE SALUDABLE Y REALIZA EJERCICIOS PARA BAJAR DE PESO!"
                        json.put("descripcion", "Sobrepeso:!ALIMENTATE SALUDABLE Y REALIZA EJERCICIOS PARA BAJAR DE PESO!")

                        json.put("resultado", tvResultado.text.toString().toInt())
                        val httpRequest = Fuel.post("http://172.29.64.36:1337/Datos").body(json.toString())
                        httpRequest.headers["Content-Type"] = "application/json"
                        httpRequest.response{request, response, result ->
                            Log.i("mensaje", request.toString())
                            Log.i("mensaje", response.toString())
                            Log.i("mensaje", result.toString())
                        }
                    } else {
                        //tvDescripcion.text = "OBESIDAD: ADEMÁS DE QUE TIENES QUE COMER SALUDABLE Y REALIZAR EJERCICIOS PARA HAJAR DE PESO, ACUDE A TU MÉDICO DE CABECERA PARA QUE TE AYUDE A CONTROLAR ALGÚN PROBLEMA DEL CORAZÓN "
                        json.put("descripcion", "OBESIDAD: ADEMÁS DE QUE TIENES QUE COMER SALUDABLE Y REALIZAR EJERCICIOS PARA HAJAR DE PESO, ACUDE A TU MÉDICO DE CABECERA PARA QUE TE AYUDE A CONTROLAR ALGÚN PROBLEMA DEL CORAZÓN ")

                        json.put("resultado", tvResultado.text.toString().toInt())
                        val httpRequest = Fuel.post("http://172.29.64.36:1337/Datos").body(json.toString())
                        httpRequest.headers["Content-Type"] = "application/json"
                        httpRequest.response{request, response, result ->
                            Log.i("mensaje", request.toString())
                            Log.i("mensaje", response.toString())
                            Log.i("mensaje", result.toString())
                        }
                    }


                }

            }


        }
        registro.setOnClickListener{
            v:View? -> irAActividadHTTP()
        }
    }
    fun irAActividadHTTP() {
        val intent = Intent(this, HttpFuel1Activity::class.java)
        startActivity(intent)
    }
}



