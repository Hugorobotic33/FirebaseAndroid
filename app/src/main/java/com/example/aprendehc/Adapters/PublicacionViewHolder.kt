package com.example.aprendehc.Adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendehc.Modelos.Publicacion
import com.example.aprendehc.R
class PublicacionViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val titulo=view.findViewById<TextView>(R.id.tvtitulo)
    val sitio=view.findViewById<TextView>(R.id.tvsitio)
    val descripcion=view.findViewById<TextView>(R.id.tvdescripcion)

    fun render(publicacion:Publicacion){
        titulo.text=publicacion.titulo
        sitio.text=publicacion.sitio
        descripcion.text=publicacion.descripcion
    }
}