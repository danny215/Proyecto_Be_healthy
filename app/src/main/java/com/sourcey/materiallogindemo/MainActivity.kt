package com.sourcey.materiallogindemo

import android.content.Intent
import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    internal var button2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onClick(view: View) {
        var miIntent: Intent? = null
        when (view.id) {
            R.id.button2 -> miIntent = Intent(this@MainActivity, ImcActivity::class.java)
            R.id.button3 -> miIntent = Intent(this@MainActivity, Imc1Activity::class.java)


            R.id.button4 -> miIntent = Intent(this@MainActivity, ModuloActivity::class.java)
        }
        startActivity(miIntent)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
