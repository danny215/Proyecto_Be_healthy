package com.sourcey.materiallogindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import java.util.*

class HttpFuel1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_fuel)
        "http://172.29.64.36:1337/Datos/21"
                .httpGet()
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            Log.i("http-ejemplo", "Error ${ex.response}")
                        }
                        is Result.Success -> {
                            val jsonStringUser = result.get()
                            Log.i("http-ejemplo", "Exito ${jsonStringUser}")

                            val user: Usuario? = Klaxon()
                                    .parse<Usuario>(jsonStringUser)

                            if (user != null) {
                                val nombre = findViewById(R.id.txtNombre) as TextView
                                val apellido = findViewById(R.id.txtApellido) as TextView
                                val fechaUso = findViewById(R.id.txtFechaUso) as TextView
                                val peso = findViewById(R.id.txtPeso) as TextView
                                val altura = findViewById(R.id.txtAltura) as TextView
                                val descripcion = findViewById(R.id.txtDesc) as TextView
                                val resultado = findViewById(R.id.txtResult) as TextView
                                nombre.text = (user.nombre)
                                apellido.text = (user.apellido)
                                fechaUso.text = (user.fechaUso)
                                peso.text = (user.peso.toString())
                                altura.text = (user.altura.toString())
                                descripcion.text = (user.descripcion)
                                resultado.text = (user.resultado.toString())
                                Log.i("http-ejemplo", "Nombre: ${user.nombre}")
                                Log.i("http-ejemplo", "Apellido: ${user.apellido}")
                                Log.i("http-ejemplo", "Id: ${user.id}")
                                Log.i("http-ejemplo", "Fecha Uso: ${user.fechaUso}")
                                Log.i("http-ejemplo", "Peso: ${user.peso}")
                                Log.i("http-ejemplo", "Altura: ${user.altura}")
                                Log.i("http-ejemplo", "Altura: ${user.altura}")
                                Log.i("http-ejemplo", "descripcion: ${user.descripcion}")
                                Log.i("http-ejemplo","resultado: ${user.resultado}")
                               /* user.pokemons.forEach { pokemon: Pokemone ->
                                    Log.i("http-ejemplo", "Nombre ${pokemon.numPok}")
                                    Log.i("http-ejemplo", "Tipo ${pokemon.nombrePok}")
                                    Log.i("http-ejemplo", "Ataque1 ${pokemon.Ataque1}")
                                    Log.i("http-ejemplo", "Numero ${pokemon.Ataque2}")
                                    Log.i("http-ejemplo", "Numero ${pokemon.fechaCaptura}")
                                    Log.i("http-ejemplo", "Numero ${pokemon.nivel}")
                                }*/



                            } else {
                                Log.i("http-ejemplo", "Entrenador nulo")
                            }


                        }
                    }
                }
    }


    class Usuario(var nombre: String,
                      var apellido: String,
                      var fechaUso: String,
                      var peso: Int,
                      var altura: Int,
                      var descripcion: String,
                  var resultado:Int,
                      var createdAt: Long,
                      var updatedAt: Long,
                      var id: Int)
                 /*     var pokemons: List<Pokemone>) {
        var createdAtDate = Date(updatedAt)
        var updatedAtDate = Date(createdAt)


    }

    class Pokemone(var numPok: Int,
                   var nombrePok: Int,
                   var Ataque1: String,
                   var Ataque2: String,
                   var fechaCaptura:String,
                   var nivel:Int,
                   var updatedAt: Long,
                   var createdAt: Long,
                   var id: Int,
                   var entrenadorId: Int) {
        var createdAtDate = Date(updatedAt)
        var updatedAtDate = Date(createdAt)
    }*/



}
