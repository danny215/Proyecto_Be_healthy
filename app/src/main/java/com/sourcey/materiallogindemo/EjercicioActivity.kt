package com.sourcey.materiallogindemo

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import butterknife.ButterKnife
import butterknife.Bind
import kotlinx.android.synthetic.main.activity_ejerciciomuj.*


class EjercicioActivity : AppCompatActivity() {
    //hola a todos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejerciciomuj)
        //        Intent i = new Intent(ImcActivity.this,MainActivity.class);
        //      startActivity(i);

        btn_voz.setOnClickListener{
            v:View? -> irAActividadVoz()
        }
    }

    fun onClick(view: View) {
        var miIntent: Intent? = null
        when (view.id) {
            R.id.button8 -> miIntent = Intent(this, SubirPesoActivity::class.java)
            R.id.button9 -> miIntent = Intent(this, MostrarejerActivity::class.java)
            R.id.button10 -> miIntent = Intent(this, BajarPesoActivity::class.java)
        }//hola
        startActivity(miIntent)


    }

    fun irAActividadVoz() {
        val intent = Intent(this, VozActivity::class.java)
        startActivity(intent)
    }
}