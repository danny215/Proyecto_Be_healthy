package com.sourcey.materiallogindemo.Alimentos

import android.os.StrictMode
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.httpGet
import com.sourcey.materiallogindemo.Alimentos.AlimentosDB

class AlimentosDB {

    companion object {

        /* fun insertarReserva(reserva: Reservas) {
             "http://172.29.64.146:1337/Reservas".httpPost(listOf("idReserva" to reserva.idReserva,"fecha_ini" to reserva.fecha_ini, "fecha_fin" to reserva.fecha_fin, "idUsuario" to reserva.idUsuario))
                     .responseString { request, _, result ->
                         Log.d("http-ejemplo", request.toString())
                     }
         }*/

        fun getListofAlimentos(alimentos: String?): ArrayList<Alimentos> {
            val detalleAlimentos: ArrayList<Alimentos> = ArrayList()
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val (request, response, result) = "http://172.29.64.29:1337/Alimentos?tipoAlimento=$alimentos".httpGet().responseString()
            val jsonStringAlimentos = result.get()

            val parser = Parser()
            val stringBuilder = StringBuilder(jsonStringAlimentos)
            val array = parser.parse(stringBuilder) as JsonArray<JsonObject>

            array.forEach {
                val tipoAlimento = it["tipoAlimento"] as String
                val nombreAlimento = it["nombreAlimento"] as String
                val cantCalorias = it["cantCalorias"] as Int
                val cantProteinas = it["cantProteinas"] as Double
                val DietaId = it["DietaId"] as Int
                val detalleAlimento = Alimentos(tipoAlimento,nombreAlimento, cantCalorias, cantProteinas, DietaId,  0, 0)
                detalleAlimentos.add(detalleAlimento)
            }
            return detalleAlimentos
        }

    }
}