package com.sourcey.materiallogindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_imc_ca.*
import org.json.JSONObject

class ImcCaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_ca)
        var imc: Int
        imc = 0
        val btCalc0ular = findViewById(R.id.btnCalcular) as Button
        btnCalcular.setOnClickListener {
            val nombre = findViewById(R.id.editTextNombre) as TextView
            val apellido = findViewById(R.id.editTextApellido) as TextView
            val fechaUso = findViewById(R.id.editTextFecha) as TextView
            val editPeso = findViewById(R.id.editTextPeso) as TextView
            val editAltura = findViewById(R.id.editTextAltura) as TextView
            var tvResultado = findViewById(R.id.editText) as TextView
            val tvDescripcion = findViewById(R.id.editText2) as TextView
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
                tvDescripcion.text = "Desnutricion:!NECESITA COMER MÁS PERO SALUDABLE Y HACER EJERCICIO PARA SUBIR DE PESO!"
                json.put("descripcion", "Desnutricion:!NECESITA COMER MÁS PERO SALUDABLE Y HACER EJERCICIO PARA SUBIR DE PESO!")

                json.put("resultado", tvResultado.text.toString().toInt())

                val httpRequest = Fuel.post("http://172.29.64.29:1337/Datos").body(json.toString())
                httpRequest.headers["Content-Type"] = "application/json"
                httpRequest.response{request, response, result ->
                    Log.i("mensaje", request.toString())
                    Log.i("mensaje", response.toString())
                    Log.i("mensaje", result.toString())
                }
            } else {
                if (imc < 25) {
                    tvDescripcion.text = "Peso adecuado:!SIGA COMIENDO Y HACIENDO EJERCICIO ADECUADAMENTE!"
                    json.put("descripcion", "Peso adecuado:!SIGA COMIENDO Y HACIENDO EJERCICIO ADECUADAMENTE!")

                    json.put("resultado", tvResultado.text.toString().toInt())
                    val httpRequest = Fuel.post("http://172.29.64.29:1337/Datos").body(json.toString())
                    httpRequest.headers["Content-Type"] = "application/json"
                    httpRequest.response{request, response, result ->
                        Log.i("mensaje", request.toString())
                        Log.i("mensaje", response.toString())
                        Log.i("mensaje", result.toString())
                    }
                } else {
                    if (imc < 30) {
                        tvDescripcion.text = "Sobrepeso:!ALIMENTATE SALUDABLE Y REALIZA EJERCICIOS PARA BAJAR DE PESO!"
                        json.put("descripcion", "Sobrepeso:!ALIMENTATE SALUDABLE Y REALIZA EJERCICIOS PARA BAJAR DE PESO!")

                        json.put("resultado", tvResultado.text.toString().toInt())
                        val httpRequest = Fuel.post("http://172.29.64.29:1337/Datos").body(json.toString())
                        httpRequest.headers["Content-Type"] = "application/json"
                        httpRequest.response{request, response, result ->
                            Log.i("mensaje", request.toString())
                            Log.i("mensaje", response.toString())
                            Log.i("mensaje", result.toString())
                        }
                    } else {
                        tvDescripcion.text = "OBESIDAD: ADEMÁS DE QUE TIENES QUE COMER SALUDABLE Y REALIZAR EJERCICIOS PARA HAJAR DE PESO, ACUDE A TU MÉDICO DE CABECERA PARA QUE TE AYUDE A CONTROLAR ALGÚN PROBLEMA DEL CORAZÓN "
                        json.put("descripcion", "OBESIDAD: ADEMÁS DE QUE TIENES QUE COMER SALUDABLE Y REALIZAR EJERCICIOS PARA HAJAR DE PESO, ACUDE A TU MÉDICO DE CABECERA PARA QUE TE AYUDE A CONTROLAR ALGÚN PROBLEMA DEL CORAZÓN ")

                        json.put("resultado", tvResultado.text.toString().toInt())
                        val httpRequest = Fuel.post("http://172.29.64.29:1337/Datos").body(json.toString())
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
      btnRegistrar.setOnClickListener{
            v: View? ->
        }
    }
    /*fun irAActividadHTTP() {
        val intent = Intent(this, HttpFuel1Activity::class.java)
        startActivity(intent)
    }*/
}
