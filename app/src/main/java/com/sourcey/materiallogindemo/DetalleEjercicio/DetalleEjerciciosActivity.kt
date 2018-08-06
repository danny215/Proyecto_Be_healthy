package com.sourcey.materiallogindemo.DetalleEjercicio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.sourcey.materiallogindemo.Ejercicios.Ejercicios
import com.sourcey.materiallogindemo.R
import kotlinx.android.synthetic.main.activity_detalle_ejercicios.*
import java.util.*

class DetalleEjerciciosActivity : AppCompatActivity() {
    var detalleejercicio : Ejercicios? = null
    lateinit var detallesejercicios: ArrayList<DetalleEjercicios>
    lateinit var adaptador: DetalleEjerciciosAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_ejercicios)
        detalleejercicio = intent.getParcelableExtra("tipoEjercicio")
        detallesejercicios = DetalleEjerciciosDB.getListofDetalleEjercicios(detalleejercicio?.tipoEjercicio!!)
        val layoutManager = LinearLayoutManager(this)
        adaptador = DetalleEjerciciosAdapter(detallesejercicios)
        recycler_detalle_ejercicios.layoutManager = layoutManager
        recycler_detalle_ejercicios.itemAnimator = DefaultItemAnimator()
        recycler_detalle_ejercicios.adapter = adaptador
        adaptador.notifyDataSetChanged()

        registerForContextMenu(recycler_detalle_ejercicios)
    }
}
