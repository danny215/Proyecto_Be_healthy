package com.sourcey.materiallogindemo

import android.app.ProgressDialog
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TabHost
import android.widget.TextView
import android.widget.Toast

import butterknife.ButterKnife
import butterknife.Bind


class BajarPesoActivity : AppCompatActivity() {
    //hola a todos
    private val lvItems: ListView? = null

    internal lateinit var opciones: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bajarpeso_activity)
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
        val adapter10 = ArrayAdapter.createFromResource(this, R.array.listado6, android.R.layout.simple_list_item_1)
        adapter10.setDropDownViewResource(android.R.layout.preference_category)
        opciones.adapter = adapter10
        spec = tabs.newTabSpec("mitab2")
        spec.setContent(R.id.tab2)
        spec.setIndicator("RUTINA 2",
                res.getDrawable(android.R.drawable.ic_dialog_map))
        tabs.addTab(spec)
        opciones = findViewById(R.id.lv02) as ListView
        val adapter31 = ArrayAdapter.createFromResource(this, R.array.listado4, android.R.layout.simple_list_item_1)
        adapter31.setDropDownViewResource(android.R.layout.preference_category)
        opciones.adapter = adapter31
        spec = tabs.newTabSpec("mitab3")
        spec.setContent(R.id.tab3)
        spec.setIndicator("RUTINA 3",
                res.getDrawable(android.R.drawable.ic_dialog_map))
        tabs.addTab(spec)
        opciones = findViewById(R.id.lv01) as ListView
        val adapter22 = ArrayAdapter.createFromResource(this, R.array.listado5, android.R.layout.simple_list_item_1)
        adapter22.setDropDownViewResource(android.R.layout.preference_category)
        opciones.adapter = adapter22
        tabs.currentTab = 1
    }
}