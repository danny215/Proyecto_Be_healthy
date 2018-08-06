package com.sourcey.materiallogindemo.Alimentos

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.widget.ImageView
import com.sourcey.materiallogindemo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalles_alimentos.*


class DetallesAlimentosActivity : AppCompatActivity() {

    var alimentos: Alimentos? = null
    //lateinit var myBitmapAgain:Bitmap

    //lateinit var alimentosB : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_alimentos)

        alimentos = intent.getParcelableExtra("tipoAlimento")

        /*if (alimentosB.equals("tipoAlimento=carne",true)){
            //Toast.makeText(this,"Deshabilito boton", Toast.LENGTH_SHORT).show()
            showImageViewAlimentos.visibility = View.INVISIBLE

        }else{
            imageView7.visibility = View.INVISIBLE

        }*/
        //detalleejercicio = intent.getParcelableExtra("tipoEjercicio")
        Picasso.get()
                .load("https://www.bupasalud.com/sites/default/files/html/imce/Plato_alimentos_saludable.jpg")
                //.resize(70,70)
               // .centerCrop()
                .into(showImageView)

        txtShowNombreA.text = alimentos?.nombreAlimento
        txtShowCantCal.text = alimentos?.cantCalorias.toString()
        txtShowCantProt.text = alimentos?.cantProteinas.toString()
        //txtShowPoderDos.text = alimentos?.poderDos
        //txtShowFechaC.text = alimentos?.fechaCaptura
        //txtShowNivel.text = alimentos?.nivel.toString()
       // myBitmapAgain = decodeBase64(alimentos?.imagenPokemon.toString()!!)
//        showImageViewPokemon.setImageBitmap(myBitmapAgain)

    }

    fun decodeBase64(input: String): Bitmap {
        val decodedBytes =  Base64.decode(input,0)
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    }


}
