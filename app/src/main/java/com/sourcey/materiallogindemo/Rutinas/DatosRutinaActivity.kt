package com.sourcey.materiallogindemo.Rutinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sourcey.materiallogindemo.BuscarEjercicioActivity
import com.sourcey.materiallogindemo.Ejercicios.Ejercicios
import com.sourcey.materiallogindemo.R
import kotlinx.android.synthetic.main.activity_datos_rutina.*

class DatosRutinaActivity : AppCompatActivity() {

    var tipoEjercicio : Ejercicios? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_rutina)

        tipoEjercicio = intent.getParcelableExtra("tipoEjercicio")

        //Toast.makeText(this,idPokemonn,Toast.LENGTH_SHORT).show()

        btnEnviarDatosRutina.setOnClickListener { v: View? ->
            crearOreden()
        }


    }

    fun crearOreden(){
        var fecha = txtFechaRutina.text.toString()
        var peso = txtPeso.text.toString().toInt()
        //var nombre = txtNombre.text.toString()
        //var idPokemon = idPokemonn.toString().toInt()

        var oredenCompra = Rutina(fecha, peso)
        RutinaBD.insertarOrden(oredenCompra)
        val intent = Intent(this, BuscarEjercicioActivity::class.java)
        startActivity(intent)
       /* Alerter.create(this)
                .setTitle("Datos Enviados a Delivery")
                .setText("Su peticion ha sido enviada correctamente")
                .setDuration(10000)
                .enableSwipeToDismiss()
                .setOnClickListener(View.OnClickListener {
                    irAbuscarEntrenador()
                }).show()*/


    }

   /* fun irAbuscarEntrenador(){
        txtCedulaComprador.setText("")
        txtSector.setText("")
        val intent = Intent(this,BuscarEntrenadorActivity::class.java)
        startActivity(intent)
    }*/


}

