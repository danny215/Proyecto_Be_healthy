package com.sourcey.materiallogindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.sourcey.materiallogindemo.Ejercicios.EjerciciosActivity
import com.sourcey.materiallogindemo.Nutricion.DietaActivity
import com.sourcey.materiallogindemo.Rutinas.NuevaRutinaActivity
import kotlinx.android.synthetic.main.activity_modulos.*



class ModuloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modulos)
        btn_ejercicios.setOnClickListener {
            v: View? -> iraEjercicios()
        }
        btn_nutricion.setOnClickListener {
            v: View? -> iraNutricion()
        }
        btn_rutinas.setOnClickListener {
            v: View? -> iraNuevaRutina()
        }
    }

    fun iraEjercicios(){
        val intent = Intent(this, BuscarEjercicioActivity::class.java)
        startActivity(intent)
    }

    fun iraNutricion(){
        val intent = Intent(this, BuscarAlimentoActivity::class.java)
        startActivity(intent)
    }

    fun iraNuevaRutina(){
        val intent = Intent(this, NuevaRutinaActivity::class.java)
        startActivity(intent)
    }

}
