package com.sourcey.materiallogindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by David on 01/02/2018.
 */

class ModuloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modulos)
    }

    fun onClick(view: View) {
        var miIntent: Intent? = null
        when (view.id) {
            R.id.button5 -> miIntent = Intent(this@ModuloActivity, DietaActivity::class.java)
            R.id.button6 -> miIntent = Intent(this@ModuloActivity, EjercicioActivity::class.java)
            R.id.button7 -> miIntent = Intent(this@ModuloActivity, CaloriasActivity::class.java)
        }//hola
        startActivity(miIntent)


    }
}
