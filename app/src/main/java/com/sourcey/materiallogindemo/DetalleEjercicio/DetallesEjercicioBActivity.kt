package com.sourcey.materiallogindemo.DetalleEjercicio

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.widget.ImageView
import com.sourcey.materiallogindemo.BuscarEjercicioActivity
import com.sourcey.materiallogindemo.R
import com.sourcey.materiallogindemo.Rutinas.DatosRutinaActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalle_ejercicio_b.*
import kotlinx.android.synthetic.main.activity_modulos.*


class DetallesEjercicioBActivity : AppCompatActivity() {

    var ejercicios: DetalleEjercicios? = null
    //lateinit var myBitmapAgain:Bitmap

    //lateinit var alimentosB : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_ejercicio_b)

        ejercicios = intent.getParcelableExtra("tipoEjercicio")

        /*if (alimentosB.equals("tipoAlimento=carne",true)){
            //Toast.makeText(this,"Deshabilito boton", Toast.LENGTH_SHORT).show()
            showImageViewAlimentos.visibility = View.INVISIBLE

        }else{
            imageView7.visibility = View.INVISIBLE

        }*/
        //detalleejercicio = intent.getParcelableExtra("tipoEjercicio")
        Picasso.get()
                .load("https://as.com/deporteyvida/imagenes/2017/07/06/portada/1499359420_888140_1499359874_sumario_grande.jpg")
                //.resize(70,70)
                //.centerCrop()
                .into(showImageViewDesc)

        txtShowNombreE.text = ejercicios?.nombreEjercicio
        txtShowDescripcion.text = ejercicios?.descripcionEjercicio
        //txtShowCantProt.text = alimentos?.cantProteinas.toString()
        //txtShowPoderDos.text = alimentos?.poderDos
        //txtShowFechaC.text = alimentos?.fechaCaptura
        //txtShowNivel.text = alimentos?.nivel.toString()
        // myBitmapAgain = decodeBase64(alimentos?.imagenPokemon.toString()!!)
//        showImageViewPokemon.setImageBitmap(myBitmapAgain)
        btn_anadirEjercicios.setOnClickListener {
            v: View? -> iraDatosEjercicio()
        }

    }

    fun decodeBase64(input: String): Bitmap {
        val decodedBytes =  Base64.decode(input,0)
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    }

    fun iraDatosEjercicio(){
        val intent = Intent(this, DatosRutinaActivity::class.java)
        startActivity(intent)
    }
}
