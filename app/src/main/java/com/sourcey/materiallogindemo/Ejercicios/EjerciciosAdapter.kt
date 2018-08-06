package com.sourcey.materiallogindemo.Ejercicios

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Button
import android.widget.TextView
import com.sourcey.materiallogindemo.DetalleEjercicio.DetalleEjerciciosActivity
import com.sourcey.materiallogindemo.R
import kotlinx.android.synthetic.main.recycler_ejercicios_layout.view.*

class EjerciciosAdapter (private val ejerciciosList: List<Ejercicios>) : RecyclerView.Adapter<EjerciciosAdapter.MyViewHolder>() {

    private var position: Int = 0

    fun getPosition(): Int {
        return position
    }

    fun setPosition(position: Int) {
        this.position = position
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {

        var nombreEjercicio: TextView
        var detallesEjercicio: Button

        lateinit var ejercicio: Ejercicios

        init {
            nombreEjercicio = view.findViewById(R.id.txtEjercicioNombre) as TextView
            detallesEjercicio = view.findViewById(R.id.btnDetallesEjercicios) as Button
            view.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
           // menu?.add(Menu.NONE, R.id.item_menu_editar, Menu.NONE, "Editar")
           // menu?.add(Menu.NONE, R.id.item_menu_eliminar, Menu.NONE, "Eliminar")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_ejercicios_layout, parent, false)

        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ejercicio = ejerciciosList[position]
        holder.nombreEjercicio.text = ejercicio.tipoEjercicio
        holder.detallesEjercicio.setOnClickListener{
            v: View ->
            val intent = Intent(v.context, DetalleEjerciciosActivity::class.java)
            intent.putExtra("tipoEjercicio",ejercicio)
            v.context.startActivity(intent)
        }
        holder.itemView.setOnLongClickListener {
            setPosition(holder.adapterPosition)
            false
        }
    }

    override fun getItemCount(): Int {
        return ejerciciosList.size
    }
}