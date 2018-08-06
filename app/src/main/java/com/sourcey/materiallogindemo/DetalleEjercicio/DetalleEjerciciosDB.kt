package com.sourcey.materiallogindemo.DetalleEjercicio

import android.os.StrictMode
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.httpGet
import com.sourcey.materiallogindemo.Ejercicios.Ejercicios

class DetalleEjerciciosDB {

    companion object {

        /* fun insertarReserva(reserva: Reservas) {
             "http://172.29.64.146:1337/Reservas".httpPost(listOf("idReserva" to reserva.idReserva,"fecha_ini" to reserva.fecha_ini, "fecha_fin" to reserva.fecha_fin, "idUsuario" to reserva.idUsuario))
                     .responseString { request, _, result ->
                         Log.d("http-ejemplo", request.toString())
                     }
         }*/

        fun getListofDetalleEjercicios(detalleejercicio: String?): ArrayList<DetalleEjercicios> {
            val detalleejercicios: ArrayList<DetalleEjercicios> = ArrayList()
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val (request, response, result) = "http://172.29.64.29:1337/DetallesEjercicios?tipoEjercicio=$detalleejercicio".httpGet().responseString()
            val jsonStringDetalleEjercicios = result.get()

            val parser = Parser()
            val stringBuilder = StringBuilder(jsonStringDetalleEjercicios)
            val array = parser.parse(stringBuilder) as JsonArray<JsonObject>

            array.forEach {
                val tipoEjercicio = it["tipoEjercicio"] as String
                val nombreEjercicio = it["nombreEjercicio"] as String
                val descripcionEjercicio = it["descripcionEjercicio"] as String
                val rutinaId = it["rutinaId"] as Int
                 val detalleejercicio = DetalleEjercicios(tipoEjercicio,nombreEjercicio,descripcionEjercicio,rutinaId,  0, 0)
                detalleejercicios.add(detalleejercicio)
            }
            return detalleejercicios
        }

    }
}