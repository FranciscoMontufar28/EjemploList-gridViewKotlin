package com.practice.francisco.ejemplolistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.practice.francisco.ejemplolistview.adapter.AdaptadorCustom
import com.practice.francisco.ejemplolistview.model.Fruta

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var frutas : ArrayList<Fruta> = ArrayList()
            frutas.add(Fruta("Manzana", R.drawable.ic_launcher_background))
            frutas.add(Fruta("Durazno", R.drawable.ic_launcher_background))
            frutas.add(Fruta("Platano", R.drawable.ic_launcher_background))
            frutas.add(Fruta("Sandia", R.drawable.ic_launcher_background))

        val lista = findViewById<ListView>(R.id.lista)
        // val adaptador = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, frutas)

        val adaptador = AdaptadorCustom(this, frutas)
        lista.adapter = adaptador

        lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, frutas.get(position).nombre, Toast.LENGTH_SHORT).show()
        }
    }
}
