package com.example.tp_mob_anaritaamaral

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tp_mob_anaritaamaral.adapter.UtilizadorListAdapter
import com.example.tp_mob_anaritaamaral.data.UtilizadorMock
import com.example.tp_mob_anaritaamaral.databinding.ActivityLoginBinding
import com.example.tp_mob_anaritaamaral.model.Utilizador
import java.util.ArrayList

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var listaUtilizadores: ArrayList<Utilizador>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ligação à base de dados, nota: username = teste3 ; password = 123
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
                    Toast.makeText(applicationContext, "Login correto! Bem-vindo $username1!", Toast.LENGTH_SHORT).show()
                }
            }
            if (loginValido) {
                startActivity(Intent(this, MenuActivity::class.java)) //vamos para o menu ver os cursos
                finish()
            } else {
                Toast.makeText(applicationContext, "Login errado! Tente novamente.", Toast.LENGTH_SHORT).show()
                binding.editUsername.setText("") //limpa campos
                binding.editPassword.setText("")
            }
        }
    }

    private fun CarregarUtilizadores(db: DBHelper) {
        listaUtilizadores = db.selectAllUtilizadorLista()
    }
}