package com.sourcey.materiallogindemo.Nutricion

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.sourcey.materiallogindemo.Alimentos.AlimentosActivity
import com.sourcey.materiallogindemo.DetalleEjercicio.DetalleEjercicios
import com.sourcey.materiallogindemo.DetalleEjercicio.DetalleEjerciciosActivity
import com.sourcey.materiallogindemo.DetalleEjercicio.DetalleEjerciciosDB
import com.sourcey.materiallogindemo.Ejercicios.Ejercicios
import com.sourcey.materiallogindemo.Ejercicios.EjerciciosAdapter
import com.sourcey.materiallogindemo.Ejercicios.EjerciciosDB
import com.sourcey.materiallogindemo.R
import kotlinx.android.synthetic.main.activity_dieta.*
import kotlinx.android.synthetic.main.recycler_ejercicios_layout.*
import java.util.*
import kotlin.collections.ArrayList

class DietaActivity : AppCompatActivity() {
    var dieta: Dieta? = null
    lateinit var dietas: ArrayList<Dieta>
    lateinit var adaptador: DietaAdapter
    var detalle_dieta: Dieta? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dieta)
        dietas = DietaDB.getListofDieta()

        val layoutManager = LinearLayoutManager(this)
        adaptador = DietaAdapter(dietas)
        recycler_dieta.layoutManager = layoutManager
        recycler_dieta.itemAnimator = DefaultItemAnimator()
        recycler_dieta.adapter = adaptador
        adaptador.notifyDataSetChanged()


    }


}

