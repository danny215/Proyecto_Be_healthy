package com.sourcey.materiallogindemo

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

import butterknife.ButterKnife
import butterknife.Bind
import android.content.res.Resources
import android.view.Menu
import android.view.MenuItem
import android.widget.TabHost

class SubirPesoActivity : AppCompatActivity() {
    //hola a todos
    private val lvItems: ListView? = null

    internal lateinit var opciones: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aumentarpeso_activity)
        //        Intent i = new Intent(ImcActivity.this,MainActivity.class);
        //      startActivity(i);
        val res = resources

        val tabs = findViewById(android.R.id.tabhost) as TabHost
        tabs.setup()

        var spec: TabHost.TabSpec = tabs.newTabSpec("mitab1")
        spec.setContent(R.id.tab1)
        spec.setIndicator("RUTINA 1",
                res.getDrawable(android.R.drawable.ic_btn_speak_now))
        tabs.addTab(spec)
        opciones = findViewById(R.id.lv03) as ListView
        val adapter8 = ArrayAdapter.createFromResource(this, R.array.listado2, android.R.layout.simple_list_item_1)
        adapter8.setDropDownViewResource(android.R.layout.preference_category)
        opciones.adapter = adapter8
        spec = tabs.newTabSpec("mitab2")
        spec.setContent(R.id.tab2)
        spec.setIndicator("RUTINA 2",
                res.getDrawable(android.R.drawable.ic_dialog_map))
        tabs.addTab(spec)
        opciones = findViewById(R.id.lv02) as ListView
        val adapter3 = ArrayAdapter.createFromResource(this, R.array.listado3, android.R.layout.simple_list_item_1)
        adapter3.setDropDownViewResource(android.R.layout.preference_category)
        opciones.adapter = adapter3
        spec = tabs.newTabSpec("mitab3")
        spec.setContent(R.id.tab3)
        spec.setIndicator("RUTINA 3",
                res.getDrawable(android.R.drawable.ic_dialog_map))
        tabs.addTab(spec)
        opciones = findViewById(R.id.lv01) as ListView
        val adapter2 = ArrayAdapter.createFromResource(this, R.array.listado, android.R.layout.simple_list_item_1)
        adapter2.setDropDownViewResource(android.R.layout.preference_category)
        opciones.adapter = adapter2
        tabs.currentTab = 1
    }
}