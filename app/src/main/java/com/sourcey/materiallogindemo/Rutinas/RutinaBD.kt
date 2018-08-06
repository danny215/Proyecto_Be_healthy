package com.sourcey.materiallogindemo.Rutinas

import android.os.StrictMode
import android.util.Log
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost

class RutinaBD{
    companion object {
        fun insertarOrden(rutinaClass: Rutina){
            "http://192.168.100.44:1337/Rutinas".httpPost(listOf("fechaRegistro" to rutinaClass.fechaRegistro, "peso" to rutinaClass.peso))
                    .responseString { request, _, result ->
                        Log.d("http-ejemplo", request.toString())
                    }
        }



        fun getOrdenesList(): ArrayList<Rutina> {
            val rutinaRegistro: ArrayList<Rutina> = ArrayList()
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val (request, response, result) = "http://192.168.100.44:1337/Rutinas".httpGet().responseString()
            val jsonStringRutinas = result.get()

            val parser = Parser()
            val stringBuilder = StringBuilder(jsonStringRutinas)
            val array = parser.parse(stringBuilder) as JsonArray<JsonObject>

            array.forEach {
                val fechaRegistro = it["fechaRegistro"] as String
                val peso = it["peso"] as Int
                //val apellidoC = it["apellido"] as String
               // val edadC = it["edad"] as Int
               // val sector = it["sector"] as String
               // val idPokemon = it["idPokemon"] as Int
                //val latitud = it["latitud"] as Double
                // val longitud = it["longitud"] as Double
                val registro = Rutina(fechaRegistro,peso)
                rutinaRegistro.add(registro)
            }
            return rutinaRegistro
        }
    }



}