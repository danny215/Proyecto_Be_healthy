package com.sourcey.materiallogindemo

import android.content.Intent
import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_imc1.*
import org.json.JSONObject

class Imc1Activity : AppCompatActivity() {

    internal var button2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        }

}



