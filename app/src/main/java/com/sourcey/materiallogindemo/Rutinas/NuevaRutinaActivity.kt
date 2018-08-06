package com.sourcey.materiallogindemo.Rutinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sourcey.materiallogindemo.BuscarAlimentoActivity
import com.sourcey.materiallogindemo.Ejercicios.EjerciciosActivity
import com.sourcey.materiallogindemo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalle_ejercicio_b.*
import kotlinx.android.synthetic.main.activity_modulos.*
import kotlinx.android.synthetic.main.activity_nueva_rutina.*

class NuevaRutinaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_rutina)

        Picasso.get()
                .load("https://image.freepik.com/vector-gratis/logo-club-de-fitness_23-2147494937.jpg")
                //.resize(70,70)
                //.centerCrop()
                .into(showImageViewN)
        btn_nuevaRutina.setOnClickListener {
            v: View? -> iraEjerciciosR()
        }
    }

    fun iraEjerciciosR(){
        val intent = Intent(this, EjerciciosActivity::class.java)
        startActivity(intent)
    }
}
