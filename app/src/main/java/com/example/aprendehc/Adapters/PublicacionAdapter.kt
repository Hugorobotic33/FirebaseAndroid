package com.example.aprendehc.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendehc.Modelos.Publicacion
import com.example.aprendehc.R

class PublicacionAdapter(private val listaPublicaciones:List<Publicacion>):RecyclerView.Adapter<PublicacionViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicacionViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return PublicacionViewHolder(layoutInflater.inflate(R.layout.item_publicacion,parent,false))
    }

    override fun onBindViewHolder(holder: PublicacionViewHolder, position: Int) {
        val item=listaPublicaciones[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
          return listaPublicaciones.size
    }


}