package com.sourcey.materiallogindemo.Rutinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sourcey.materiallogindemo.R
//import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_rutina_datos.*


class RutinaDatosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var rutina: Rutina? = null


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutina_datos)

        rutina = intent.getParcelableExtra("detallesOrden")

        txtShowNombreE.text = rutina?.fechaRegistro
        txtShowDetalles.text = rutina?.peso.toString()
        //txtShowApellido.text = rutina?.apellido
       // txtShowEdad.text = rutina?.edad.toString()
       // txtShowSector.text = rutina?.sector
       // txtShowIdPokemon.text = rutina?.idPokemon.toString()

        /*btnGuardarDatosOrden.setOnClickListener { v: View? ->
            guardarDatosOrdenDetalles()

        }*/



    }

    /*fun guardarDatosOrdenDetalles(){
        val fechaEnvio = txtFechaEnvio.text.toString()
        val costoPokemon = txtPrecioPokemon.text.toString().toInt()
        val idPokemon = txtShowIdPokemon.text.toString().toInt()
        val ordenDetalles = OrdenDetalles(0,fechaEnvio,costoPokemon,idPokemon)
        OrdenCompraDB.insertarOrdenDetalles(ordenDetalles)
        Alerter.create(this)
                .setTitle("Orden enviada a Cliente")
                .setText("La solicitud fue enviada correctamente")
                .enableSwipeToDismiss()
                .show()
    }*/


}
