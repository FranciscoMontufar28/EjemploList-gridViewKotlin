package com.practice.francisco.ejemplolistview.adapter

import android.content.Context
import android.support.v4.widget.ViewDragHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.practice.francisco.ejemplolistview.R
import com.practice.francisco.ejemplolistview.model.FrutaGrid
import kotlinx.android.synthetic.main.template_frutas_grid.view.*

class AdaptadorCustonGrid(var context: Context, items:ArrayList<FrutaGrid>): BaseAdapter() {

    var items:ArrayList<FrutaGrid>? = null

    init {
        this.items = items
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        var holder:viewHolder? = null

        if (vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.template_frutas_grid, null)
            holder = viewHolder(vista)
            vista.tag = holder
        }else{
            holder = vista.tag as? viewHolder
        }

        val item = items?.get(position) as? FrutaGrid
        holder?.nombre?.text = item?.nombre
        holder?.imagen?.setImageResource(item?.imagen!!)

        return vista!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    private class viewHolder(vista:View){
        var nombre:TextView? = null
        var imagen:ImageView? = null

        init {
            nombre = vista.findViewById(R.id.nombreGrid)
            imagen = vista.findViewById(R.id.imagenGrid)

        }
    }
}