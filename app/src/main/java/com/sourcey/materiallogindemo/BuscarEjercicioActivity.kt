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
import com.sourcey.materiallogindemo.Ejercicios.Ejercicios
import com.sourcey.materiallogindemo.Ejercicios.EjerciciosActivity
import com.sourcey.materiallogindemo.Ejercicios.EjerciciosAdapter
import com.sourcey.materiallogindemo.Ejercicios.EjerciciosDB
import kotlinx.android.synthetic.main.activity_buscar_ejercicio.*
import java.util.*

class BuscarEjercicioActivity : AppCompatActivity() {

    lateinit var adaptador: EjerciciosAdapter
    lateinit var ejercicios: ArrayList<Ejercicios>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_ejercicio)




       // registerForContextMenu(recycler_detalle_ejercicio)
        btn_escucharV.setOnClickListener {
            v: View? -> getSpeechInput(v)
        }
        btn_listaE.setOnClickListener {
            v: View? -> detallesEjercicios()
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
                txtBuscarEjercicioV.setText(result.get(0))
                consultarDatos()

            }
        }
    }


    fun detallesEjercicios(){
        val intent = Intent(this, EjerciciosActivity::class.java)
        startActivity(intent)
    }

    fun consultarDatos(){
        if (txtBuscarEjercicioV.equals("")){
            Toast.makeText(this,"Ingrese parametro de busqueda", Toast.LENGTH_SHORT).show()
        }else{
            var datoBusqueda:String = txtBuscarEjercicioV.text.toString()

            btnBuscarEntrenadorServer.setOnClickListener { v: View? ->
                consultarDatos()
            }

            ejercicios = EjerciciosDB.buscarEjercicio(datoBusqueda)

            //Toast.makeText(this,datoBusqueda,Toast.LENGTH_SHORT).show()

            val layoutManager = LinearLayoutManager(this)
            adaptador = EjerciciosAdapter(ejercicios)
            recyclerView_Resultados_Alimento.layoutManager = layoutManager
            recyclerView_Resultados_Alimento.itemAnimator = DefaultItemAnimator()
            recyclerView_Resultados_Alimento.adapter = adaptador
            adaptador.notifyDataSetChanged()

            registerForContextMenu(recyclerView_Resultados_Alimento)

        }
    }
}
