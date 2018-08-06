package com.sourcey.materiallogindemo.Nutricion

import android.os.StrictMode
import android.util.Log
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.sourcey.materiallogindemo.Ejercicios.Ejercicios
import com.sourcey.materiallogindemo.Nutricion.Dieta

class DietaDB {

    companion object {

        /* fun insertarReserva(reserva: Reservas) {
             "http://172.29.64.146:1337/Reservas".httpPost(listOf("idReserva" to reserva.idReserva,"fecha_ini" to reserva.fecha_ini, "fecha_fin" to reserva.fecha_fin, "idUsuario" to reserva.idUsuario))
                     .responseString { request, _, result ->
                         Log.d("http-ejemplo", request.toString())
                     }
         }*/

        fun getListofDieta(): ArrayList<Dieta> {
            val dietas: ArrayList<Dieta> = ArrayList()
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val (request, response, result) = "http://192.168.100.44:1337/Dieta".httpGet().responseString()
            val jsonStringDieta = result.get()

            val parser = Parser()
            val stringBuilder = StringBuilder(jsonStringDieta)
            val array = parser.parse(stringBuilder) as JsonArray<JsonObject>

            array.forEach {
                val tipoAlimento = it["tipoAlimento"] as String
                val dieta = Dieta(tipoAlimento,  0, 0)
                dietas.add(dieta)
            }
            return dietas
        }
        fun buscarAlimento(tipoAlimento:String): ArrayList<Dieta> {
            val alimentos: ArrayList<Dieta> = ArrayList()
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val (request, response, result) = "http://192.168.100.44:1337/Dieta?tipoAlimento=${tipoAlimento}".httpGet().responseString()
            val jsonStringAlimento = result.get()

            val parser = Parser()
            val stringBuilder = StringBuilder(jsonStringAlimento)
            val array = parser.parse(stringBuilder) as JsonArray<JsonObject>

            array.forEach {
                //val id = it["id"] as Int
                val tipoAlimento = it["tipoAlimento"] as String
                // val apellido = it["apellido"] as String
                // val fechaNacimiento = it["fechaNacimiento"] as String
                // val numeroMedallas = it["medallas"] as Int
                //  val campeonActual = it["campeonActual"] as Int
                val alimento = Dieta(tipoAlimento, 0, 0)
                alimentos.add(alimento)
            }
            return alimentos
        }
    }
}