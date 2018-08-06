package com.sourcey.materiallogindemo.Rutinas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_registro.*

/*class RegistroActivity : AppCompatActivity() {

    lateinit var adaptador: OrdenesPendientesAdaptador
    lateinit var datosRutina: ArrayList<Rutina>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery)

        datosRutina = RutinaBD.getOrdenesList()


        val layoutManager = LinearLayoutManager(this)
        adaptador = OrdenesPendientesAdaptador(datosRutina)
        recyclerView_registro.layoutManager = layoutManager
        recyclerView_registro.itemAnimator = DefaultItemAnimator()
        recyclerView_registro.adapter = adaptador
        adaptador.notifyDataSetChanged()

        registerForContextMenu(recyclerView_registro)
    }
}*/
