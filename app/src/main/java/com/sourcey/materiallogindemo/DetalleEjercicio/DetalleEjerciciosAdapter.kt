package com.sourcey.materiallogindemo.DetalleEjercicio

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.sourcey.materiallogindemo.Alimentos.DetallesAlimentosActivity
import com.sourcey.materiallogindemo.R


class DetalleEjerciciosAdapter (private val detalleejerciciosList: List<DetalleEjercicios>) : RecyclerView.Adapter<DetalleEjerciciosAdapter.MyViewHolder>() {

    private var position: Int = 0

    fun getPosition(): Int {
        return position
    }

    fun setPosition(position: Int) {
        this.position = position
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {

        var nombreEjercicio: TextView
        var descripcionEjercicios: Button
        // var rutinaId: TextView

        lateinit var detalleejercicio: DetalleEjercicios

        init {
            nombreEjercicio = view.findViewById(R.id.txtNombreEjercicio) as TextView
            descripcionEjercicios = view.findViewById(R.id.btn_detalles_ejer) as Button
            // rutinaId = view.findViewById(R.id.txtRutinaId) as TextView
            view.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
            // menu?.add(Menu.NONE, R.id.item_menu_editar, Menu.NONE, "Editar")
            // menu?.add(Menu.NONE, R.id.item_menu_eliminar, Menu.NONE, "Eliminar")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_detalle_ejercicios_layout, parent, false)

        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val detalleejercicio = detalleejerciciosList[position]
        holder.nombreEjercicio.text = detalleejercicio.nombreEjercicio
        holder.descripcionEjercicios.setOnClickListener{
            v: View ->
            val intent = Intent(v.context, DetallesEjercicioBActivity::class.java)
            intent.putExtra("tipoEjercicio",detalleejercicio)
            v.context.startActivity(intent)
        }
        holder.itemView.setOnLongClickListener {
            setPosition(holder.adapterPosition)
            false
        }
    }

    override fun getItemCount(): Int {
        return detalleejerciciosList.size
    }

}