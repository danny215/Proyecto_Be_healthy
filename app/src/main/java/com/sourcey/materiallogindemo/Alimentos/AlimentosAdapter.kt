package com.sourcey.materiallogindemo.Alimentos

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Button
import android.widget.TextView
import com.sourcey.materiallogindemo.DetalleEjercicio.DetalleEjercicios
import com.sourcey.materiallogindemo.R

class AlimentosAdapter (private val detallealimentosList: List<Alimentos>) : RecyclerView.Adapter<AlimentosAdapter.MyViewHolder>() {

    private var position: Int = 0

    fun getPosition(): Int {
        return position
    }

    fun setPosition(position: Int) {
        this.position = position
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {

        var nombreAlimento: TextView
        var btnAlimentoD: Button
        // var rutinaId: TextView

        lateinit var detallealimentos: Alimentos

        init {
            nombreAlimento = view.findViewById(R.id.txtNombreAlimento) as TextView
            btnAlimentoD = view.findViewById(R.id.btn_detallesAlimento) as Button
            // rutinaId = view.findViewById(R.id.txtRutinaId) as TextView
            view.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
             menu?.add(Menu.NONE, R.id.navigation_home, Menu.NONE, "Ir Home")
                menu?.add(Menu.NONE, R.id.navigation_dashboard, Menu.NONE, "Ir Módulos")
            menu?.add(Menu.NONE, R.id.navigation_notifications, Menu.NONE, "Enviar por correo")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_alimentos, parent, false)

        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val detallealimentos = detallealimentosList[position]
        holder.nombreAlimento.text = detallealimentos.nombreAlimento
        holder.btnAlimentoD.setOnClickListener{
            v: View ->
            val intent = Intent(v.context, DetallesAlimentosActivity::class.java)
            intent.putExtra("tipoAlimento",detallealimentos)
            v.context.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener {
            setPosition(holder.adapterPosition)
            false
        }
    }

    override fun getItemCount(): Int {
        return detallealimentosList.size
    }

}