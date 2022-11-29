package com.example.aprendehc

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendehc.Adapters.PublicacionAdapter
import com.example.aprendehc.Interfaces.ApiService
import com.example.aprendehc.Modelos.Publicacion
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class InicioActivity : AppCompatActivity() {

    val user = Firebase.auth.currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        //consumirApi()
        manageDataUser()
    }

    private fun manageDataUser(){
        var currentUser=findViewById<TextView>(R.id.currentuser)
        var currentPassword=findViewById<EditText>(R.id.currentPassword)
        var newPasswordx=findViewById<EditText>(R.id.newPassword)
        var btnChangePassword=findViewById<Button>(R.id.btnChancePassword)
        var btnCerrarSesion=findViewById<Button>(R.id.btnLogout)
        var cerrarCuenta=findViewById<TextView>(R.id.eliminarCuenta)
        var contra=intent.getStringExtra("textPassword")

        currentUser.text=intent.getStringExtra("textEmail")
        btnCerrarSesion.setOnClickListener {
            cerrarSesion()
        }
        cerrarCuenta.setOnClickListener{
            eliminarCuenta()
        }
        btnChangePassword.setOnClickListener {
            if(currentPassword.text.isEmpty() || newPasswordx.text.isEmpty()){
                Toast.makeText(baseContext,"escribe tu contraseña actual y/o escriba una nueva contraseña",Toast.LENGTH_SHORT).show()
            }else{
                if(currentPassword.text.toString()==contra){
                    user!!.updatePassword(newPasswordx.text.toString())
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(baseContext,"contraseña actualizada correctamente",Toast.LENGTH_SHORT).show()

                            }else{
                                Toast.makeText(baseContext,"su contraseña no se actualizo",Toast.LENGTH_SHORT).show()
                            }
                        }

                }else{
                    Toast.makeText(baseContext,"contraseña actual incorrecta",Toast.LENGTH_SHORT).show()
                }

            }

        }







    }
    private fun cerrarSesion(){
        Firebase.auth.signOut()
        finish()
    }
    private fun eliminarCuenta(){
        user!!.delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    finish()
                    Toast.makeText(baseContext,"Cuenta eliminida exitosamente",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(baseContext,"Hubo un error al eliminar la cuenta",Toast.LENGTH_SHORT).show()
                }
            }
    }















    /*private fun initRecyclerView(){
       var recyclerView=findViewById<RecyclerView>(R.id.rvPublicaciones)
       recyclerView.layoutManager=LinearLayoutManager(this)
       recyclerView.adapter= PublicacionAdapter(listOf())

    }*/




       private fun consumirApi(){
           val retrofit:Retrofit= Retrofit.Builder()
               .baseUrl("https://aprendehc-production.up.railway.app/")
               .addConverterFactory(GsonConverterFactory.create())
               .build()
           val service=retrofit.create<ApiService>(ApiService::class.java)
           service.getPublicaciones().enqueue(object : Callback<List<Publicacion>> {
               override fun onResponse(
                   call: Call<List<Publicacion>>?,
                   response: Response<List<Publicacion>>
               ) {
                   if (response.isSuccessful){

                       val body=response.body()
                       Log.d("mainactivity","count:${body?.size}")

                   }else{
                       Toast.makeText(baseContext,"Error mijo no le sabes",Toast.LENGTH_SHORT).show()
                   }



               }

               override fun onFailure(call: Call<List<Publicacion>>, t: Throwable) {
                   t?.printStackTrace()
               }
           })
       }


}