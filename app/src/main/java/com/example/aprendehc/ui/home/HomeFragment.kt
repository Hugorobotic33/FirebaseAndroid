package com.example.aprendehc.ui.home

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendehc.Adapters.PublicacionAdapter
import com.example.aprendehc.Interfaces.ApiService
import com.example.aprendehc.Modelos.Publicacion
import com.example.aprendehc.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import com.example.aprendehc.R
import java.util.logging.Logger

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //val homeViewModel=ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

       // val textView: TextView = binding.textHome
        /*homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        //initRecyclerView()
        //obtener()
        return root
    }

    /*private fun initRecyclerView(){
        var recyclerView=activity?.findViewById<RecyclerView>(R.id.rvPublicaciones)
        recyclerView?.layoutManager=LinearLayoutManager(context)
        recyclerView?.adapter=PublicacionAdapter(listOf(Publicacion("post","hugo.com","hola","hugo.jpg","hugo")))

    }*/

    /*private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://aprendehc-production.up.railway.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun obtener(){
        CoroutineScope(Dispatchers.IO).launch {
            val call=getRetrofit().create(ApiService::class.java).getPublicaciones("publicaciones")
            var publicacionesutvt=call.body()

            activity?.runOnUiThread {
                if(call.isSuccessful){
                    if (publicacionesutvt != null) {
                        publicaciones.addAll(publicacionesutvt)
                    }else{
                        publicaciones= mutableListOf(Publicacion("hola","hugo.com","dfgg","imagen.jpg","hugo"))
                    }

                }else{
                    Toast.makeText(context,"Fallo la peticion",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}