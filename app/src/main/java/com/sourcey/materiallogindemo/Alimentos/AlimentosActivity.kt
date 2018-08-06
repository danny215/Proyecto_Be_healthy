package com.sourcey.materiallogindemo.Alimentos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.sourcey.materiallogindemo.DetalleEjercicio.DetalleEjercicios
import com.sourcey.materiallogindemo.Alimentos.AlimentosAdapter
import com.sourcey.materiallogindemo.DetalleEjercicio.DetalleEjerciciosDB
import com.sourcey.materiallogindemo.MainActivity
import com.sourcey.materiallogindemo.ModuloActivity
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


    override fun onContextItemSelected(item: MenuItem): Boolean {
        var position = adaptador.getPosition()
        var alimento = detallesalimentos[position]

        when (item.itemId) {

            R.id.navigation_home -> {
                irPantallaPrincipal()
                return true
            }
            R.id.navigation_dashboard -> {
               irModulo()
                return true
            }
            R.id.navigation_notifications -> {
                enviarCorreo()
                return true
            }
            else -> {
                Log.i("menu", "Todos los demas")
                return super.onOptionsItemSelected(item)
            }
        }
    }

    fun enviarCorreo() {
        val addressees = arrayOf("danny.alvarez@epn.edu.ec")
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/html"
        intent.putExtra(Intent.EXTRA_EMAIL, addressees)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Alimento Recomendado")
        intent.putExtra(Intent.EXTRA_TEXT, "Te recomiendo  consumir este alimento ${detallesalimentos[0].tipoAlimento} te hará crecer grande y fuerte..")
        startActivity(intent)
        finish()
    }

    fun irPantallaPrincipal(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun irModulo(){
        val intent = Intent(this, ModuloActivity::class.java)
        startActivity(intent)
    }

}
