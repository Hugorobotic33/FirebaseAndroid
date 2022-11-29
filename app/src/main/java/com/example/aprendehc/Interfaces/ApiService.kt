package com.example.aprendehc.Interfaces

import com.example.aprendehc.Modelos.Publicacion
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET("publicaciones")
    fun getPublicaciones():Call<List<Publicacion>>
}