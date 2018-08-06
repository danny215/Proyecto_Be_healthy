package com.sourcey.materiallogindemo.Ejercicios

import android.os.StrictMode
import android.util.Log
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost

class EjerciciosDB {

    companion object {

       /* fun insertarReserva(reserva: Reservas) {
            "http://172.29.64.146:1337/Reservas".httpPost(listOf("idReserva" to reserva.idReserva,"fecha_ini" to reserva.fecha_ini, "fecha_fin" to reserva.fecha_fin, "idUsuario" to reserva.idUsuario))
                    .responseString { request, _, result ->
                        Log.d("http-ejemplo", request.toString())
                    }
        }*/

        fun getListofEjercicios(): ArrayList<Ejercicios> {
            val ejercicios: ArrayList<Ejercicios> = ArrayList()
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val (request, response, result) = "http://172.29.64.29:1337/Ejercicios".httpGet().responseString()
            val jsonStringEjercicios = result.get()

            val parser = Parser()
            val stringBuilder = StringBuilder(jsonStringEjercicios)
            val array = parser.parse(stringBuilder) as JsonArray<JsonObject>

            array.forEach {
                val tipoEjercicio = it["tipoEjercicio"] as String
                val ejercicio = Ejercicios(tipoEjercicio,  0, 0)
                ejercicios.add(ejercicio)
            }
            return ejercicios
        }

        fun buscarEjercicio(tipoEjercicio:String): ArrayList<Ejercicios> {
            val ejercicios: ArrayList<Ejercicios> = ArrayList()
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val (request, response, result) = "http://172.29.64.29:1337/Ejercicios?tipoEjercicio=${tipoEjercicio}".httpGet().responseString()
            val jsonStringEjercicio = result.get()

            val parser = Parser()
            val stringBuilder = StringBuilder(jsonStringEjercicio)
            val array = parser.parse(stringBuilder) as JsonArray<JsonObject>

            array.forEach {
                //val id = it["id"] as Int
                val tipoEjercicio = it["tipoEjercicio"] as String
               // val apellido = it["apellido"] as String
               // val fechaNacimiento = it["fechaNacimiento"] as String
               // val numeroMedallas = it["medallas"] as Int
              //  val campeonActual = it["campeonActual"] as Int
                val ejercicio = Ejercicios(tipoEjercicio, 0, 0)
                ejercicios.add(ejercicio)
            }
            return ejercicios
        }

    }
}