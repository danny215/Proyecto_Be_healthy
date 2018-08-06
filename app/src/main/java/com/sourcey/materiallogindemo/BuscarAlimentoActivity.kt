package com.sourcey.materiallogindemo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.sourcey.materiallogindemo.Nutricion.Dieta
import com.sourcey.materiallogindemo.Nutricion.DietaActivity
import com.sourcey.materiallogindemo.Nutricion.DietaAdapter
import com.sourcey.materiallogindemo.Nutricion.DietaDB
import kotlinx.android.synthetic.main.activity_buscar_alimento.*
import java.util.*

class BuscarAlimentoActivity : AppCompatActivity() {

    lateinit var adaptador: DietaAdapter
    lateinit var dietas: ArrayList<Dieta>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_alimento)




        // registerForContextMenu(recycler_detalle_ejercicio)
        btn_escucharVoz.setOnClickListener {
            v: View? -> getSpeechInput(v)
        }
        btn_listaA.setOnClickListener {
            v: View? -> detallesDieta()
        }

    }

    fun getSpeechInput (view: View?){
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        if (intent.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(intent,10)
        }
        else{
            Toast.makeText(this,"\n" +
                    "Su dispositivo no es compatible con la entrada de voz", Toast.LENGTH_SHORT ).show()
        }
    }

    override fun onActivityResult(requestCode:Int, resultCode:Int, data: Intent){
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            10 -> if (resultCode == Activity.RESULT_OK){
                val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                txtBuscarAlimento.setText(result.get(0))
                consultarDatos()

            }
        }
    }


    fun detallesDieta(){
        val intent = Intent(this, DietaActivity::class.java)
        startActivity(intent)
    }

    fun consultarDatos(){
        if (txtBuscarAlimento.equals("")){
            Toast.makeText(this,"Ingrese parametro de busqueda", Toast.LENGTH_SHORT).show()
        }else{
            var datoBusqueda:String = txtBuscarAlimento.text.toString()

            btnBuscarEntrenadorServer.setOnClickListener { v: View? ->
                consultarDatos()
            }

            dietas = DietaDB.buscarAlimento(datoBusqueda)

            //Toast.makeText(this,datoBusqueda,Toast.LENGTH_SHORT).show()

            val layoutManager = LinearLayoutManager(this)
            adaptador = DietaAdapter(dietas)
            recyclerView_Resultados_Alimento.layoutManager = layoutManager
            recyclerView_Resultados_Alimento.itemAnimator = DefaultItemAnimator()
            recyclerView_Resultados_Alimento.adapter = adaptador
            adaptador.notifyDataSetChanged()

            registerForContextMenu(recyclerView_Resultados_Alimento)

        }
    }
}
