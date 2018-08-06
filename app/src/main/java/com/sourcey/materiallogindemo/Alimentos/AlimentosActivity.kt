package com.sourcey.materiallogindemo.Alimentos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.sourcey.materiallogindemo.DetalleEjercicio.DetalleEjercicios
import com.sourcey.materiallogindemo.Alimentos.AlimentosAdapter
import com.sourcey.materiallogindemo.DetalleEjercicio.DetalleEjerciciosDB
import com.sourcey.materiallogindemo.Nutricion.Dieta
import com.sourcey.materiallogindemo.R
import kotlinx.android.synthetic.main.activity_alimentos.*
import kotlinx.android.synthetic.main.activity_detalle_ejercicios.*
import java.util.*

class AlimentosActivity : AppCompatActivity() {
    var detallealimento : Dieta? = null
    lateinit var detallesalimentos: ArrayList<Alimentos>
    lateinit var adaptador: AlimentosAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alimentos)
        detallealimento = intent.getParcelableExtra("tipoAlimento")
        detallesalimentos = AlimentosDB.getListofAlimentos(detallealimento?.tipoAlimento!!)
        val layoutManager = LinearLayoutManager(this)
        adaptador = AlimentosAdapter(detallesalimentos)
        recycler_detalle_alimentos.layoutManager = layoutManager
        recycler_detalle_alimentos.itemAnimator = DefaultItemAnimator()
        recycler_detalle_alimentos.adapter = adaptador
        adaptador.notifyDataSetChanged()

        registerForContextMenu(recycler_detalle_alimentos)
    }
}
