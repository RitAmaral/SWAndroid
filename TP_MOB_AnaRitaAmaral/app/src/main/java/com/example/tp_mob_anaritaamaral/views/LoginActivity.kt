package com.example.tp_mob_anaritaamaral.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import com.example.tp_mob_anaritaamaral.R
import com.example.tp_mob_anaritaamaral.data.DBHelper
import com.example.tp_mob_anaritaamaral.databinding.ActivityLoginBinding
import com.example.tp_mob_anaritaamaral.model.Utilizador
import java.util.ArrayList

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var listaUtilizadores: ArrayList<Utilizador>
    private var passwordVisivel = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ligação à base de dados
        val db = DBHelper(this)
        listaUtilizadores = ArrayList()
        CarregarUtilizadores(db)

        binding.buttonLogin.setOnClickListener {
            val username1 = binding.editUsername.text.toString().trim() //pede username ao utilizador
            val password1 = binding.editPassword.text.toString().trim()

            var loginValido = false //assumir que o login está errado
            //ver se o username1 e password1 fazem match a algum utilizador na base de dados
            for (utilizador in listaUtilizadores) {
                if (utilizador.username == username1 && utilizador.password == password1) {
                    loginValido = true
                    Toast.makeText(applicationContext, getString(R.string.login_correto_bem_vindo), Toast.LENGTH_SHORT).show()
                }
            }
            if (loginValido) {
                startActivity(Intent(this, MenuActivity::class.java)) //vamos para o menu ver os cursos
                finish()
            } else {
                Toast.makeText(applicationContext, getString(R.string.login_errado_tente_novamente), Toast.LENGTH_SHORT).show()
                binding.editUsername.setText("") //limpa campos
                binding.editPassword.setText("")
                }
            }

        //carregar no icon para mostrar e esconder password
        binding.imageMostrar.setOnClickListener {
            PasswordVisivel()
        }

    }

    private fun CarregarUtilizadores(db: DBHelper) {
        listaUtilizadores = db.selectAllUtilizadorLista()
    }
    //carregar no icon para ver e esconder password
    private fun PasswordVisivel() {
        passwordVisivel = !passwordVisivel
        val transformationMethod =
            if (passwordVisivel)  {
                HideReturnsTransformationMethod.getInstance()
            }
            else {
                PasswordTransformationMethod.getInstance()
            }

        binding.editPassword.transformationMethod = transformationMethod
    }
}