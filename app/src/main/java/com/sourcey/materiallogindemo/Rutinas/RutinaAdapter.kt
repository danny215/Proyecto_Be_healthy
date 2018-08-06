package com.sourcey.materiallogindemo.Rutinas

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Button
import android.widget.TextView
import com.sourcey.materiallogindemo.Alimentos.AlimentosActivity
import com.sourcey.materiallogindemo.DetalleEjercicio.DetalleEjerciciosActivity
import com.sourcey.materiallogindemo.Nutricion.Dieta
import com.sourcey.materiallogindemo.R

/*class RutinaAdapter (private val dietaList: List<Rutina>) : RecyclerView.Adapter<RutinaAdapter.MyViewHolder>() {

    private var position: Int = 0

    fun getPosition(): Int {
        return position
    }

    fun setPosition(position: Int) {
        this.position = position
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {

        var fechaR: TextView
        var detallesDieta: Button

        lateinit var dieta: Dieta

        init {
            fechaR = view.findViewById(R.id.txtTipoAlimento) as TextView
            detallesDieta = view.findViewById(R.id.btnDieta) as Button
            view.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
            // menu?.add(Menu.NONE, R.id.item_menu_editar, Menu.NONE, "Editar")
            // menu?.add(Menu.NONE, R.id.item_menu_eliminar, Menu.NONE, "Eliminar")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_registro, parent, false)

        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dieta = dietaList[position]
        holder.fecha.text = dieta.tipoAlimento
        holder.detallesDieta.setOnClickListener{
            v: View ->
            val intent = Intent(v.context, AlimentosActivity::class.java)
            intent.putExtra("tipoAlimento",dieta)
            v.context.startActivity(intent)
        }
        holder.itemView.setOnLongClickListener {
            setPosition(holder.adapterPosition)
            false
        }
    }

    override fun getItemCount(): Int {
        return dietaList.size
    }
}*/