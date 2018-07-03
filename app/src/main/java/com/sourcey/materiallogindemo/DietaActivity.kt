package com.sourcey.materiallogindemo

import android.app.ProgressDialog
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TabHost
import android.widget.TextView
import android.widget.Toast

import butterknife.ButterKnife
import butterknife.Bind
import android.widget.ListView
import android.widget.ArrayAdapter

class DietaActivity : AppCompatActivity() {

    private val lvItems: ListView? = null

    internal lateinit var opciones: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dietas)

      /*  val res = resources


        val tabs = findViewById(android.R.id.tabhost) as TabHost
        tabs.setup()

        var spec: TabHost.TabSpec = tabs.newTabSpec("mitab1")
        spec.setContent(R.id.tab1)
        spec.setIndicator("DIETAS SALUDABLES",
                res.getDrawable(android.R.drawable.ic_btn_speak_now))
        tabs.addTab(spec)

        spec = tabs.newTabSpec("mitab2")
        spec.setContent(R.id.tab2)
        spec.setIndicator("NUTRIENTRES-ALIMENTOS",
                res.getDrawable(android.R.drawable.ic_dialog_map))
        tabs.addTab(spec)

        spec = tabs.newTabSpec("mitab3")
        spec.setContent(R.id.tab3)
        spec.setIndicator("CONSEJOS",
                res.getDrawable(android.R.drawable.ic_dialog_map))
        tabs.addTab(spec)
        opciones = findViewById(R.id.lv01) as ListView
        val adapter = ArrayAdapter.createFromResource(this, R.array.listado, android.R.layout.simple_list_item_1)
        adapter.setDropDownViewResource(android.R.layout.preference_category)
        opciones.adapter = adapter

        tabs.currentTab = 1
    */}
}