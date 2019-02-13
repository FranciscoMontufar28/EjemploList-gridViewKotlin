package com.practice.francisco.ejemplolistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import com.practice.francisco.ejemplolistview.adapter.AdaptadorCustom
import com.practice.francisco.ejemplolistview.adapter.AdaptadorCustonGrid
import com.practice.francisco.ejemplolistview.model.FrutaGrid

class GridViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        //var frutas = ArrayList<String>()
        var frutas = ArrayList<FrutaGrid>()

        frutas.add(FrutaGrid("Manzana", R.drawable.manzana))
        frutas.add(FrutaGrid("Platano", R.drawable.platano))
        frutas.add(FrutaGrid("Sandía", R.drawable.sandia))
        frutas.add(FrutaGrid("Durazno", R.drawable.durazno))

        /*frutas.add("Platano")
        frutas.add("Sandía")
        frutas.add("Durazno")*/

        var grid:GridView = findViewById(R.id.grid)
        //var adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, frutas)
        var adaptador = AdaptadorCustonGrid(this, frutas)
        grid.adapter = adaptador

        grid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, frutas.get(position).nombre, Toast.LENGTH_SHORT).show()
        }
    }
}
