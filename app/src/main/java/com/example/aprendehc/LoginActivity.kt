package com.example.aprendehc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth=Firebase.auth
        val registerText:TextView=findViewById(R.id.textView_register_now);
        registerText.setOnClickListener{
            val intent=Intent(this,RegisterActivity::class.java);
            startActivity(intent);
        }
        val botonLogin=findViewById<Button>(R.id.btnLogin)
        botonLogin.setOnClickListener {
            Login()
        }
    }

    private fun Login(){
        val inputEmail=findViewById<EditText>(R.id.editText_email_login)
        val inputPassword=findViewById<EditText>(R.id.editText_password_login)
        if(inputEmail.text.isEmpty()||inputPassword.text.isEmpty()){
            Toast.makeText(this,"LLena los campos porfavor",Toast.LENGTH_SHORT).show()
            return
        }
        val textEmail=inputEmail.text.toString()
        val textPassword=inputPassword.text.toString()
        auth.signInWithEmailAndPassword(textEmail,textPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this, InicioActivity::class.java)
                    intent.putExtra("textEmail",textEmail)
                    intent.putExtra("textPassword",textPassword)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Inicio de sesion exitoso", Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Ocurrio un error al iniciar sesion", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener{
                Toast.makeText(this, "Error ocurred ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
            }


    }



}