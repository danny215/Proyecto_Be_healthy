package com.sourcey.materiallogindemo.Ejercicios

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
import com.sourcey.materiallogindemo.R
import kotlinx.android.synthetic.main.activity_dieta.*
import kotlinx.android.synthetic.main.activity_ejercicios.*
import kotlinx.android.synthetic.main.recycler_ejercicios_layout.*
import java.util.*
import kotlin.collections.ArrayList

class EjerciciosActivity : AppCompatActivity() {
    var ejercicio: Ejercicios? = null
    lateinit var ejercicios: ArrayList<Ejercicios>
    lateinit var adaptador: EjerciciosAdapter
    var detalle_ejercicios: Ejercicios? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios)
        ejercicios = EjerciciosDB.getListofEjercicios()

        val layoutManager = LinearLayoutManager(this)
        adaptador = EjerciciosAdapter(ejercicios)
        recycler_detalle_ejercicio.layoutManager = layoutManager
        recycler_detalle_ejercicio.itemAnimator = DefaultItemAnimator()
        recycler_detalle_ejercicio.adapter = adaptador
        adaptador.notifyDataSetChanged()


    }


}
