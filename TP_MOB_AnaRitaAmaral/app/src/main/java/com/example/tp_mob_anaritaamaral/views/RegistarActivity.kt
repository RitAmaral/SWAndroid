package com.example.tp_mob_anaritaamaral.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tp_mob_anaritaamaral.data.DBHelper
import com.example.tp_mob_anaritaamaral.adapter.UtilizadorListAdapter
import com.example.tp_mob_anaritaamaral.databinding.ActivityRegistarBinding
import com.example.tp_mob_anaritaamaral.model.Utilizador
import java.util.ArrayList

class RegistarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistarBinding
    private lateinit var listaUtilizadores: ArrayList<Utilizador>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //criar ligação à base de dados
        val db = DBHelper(this)
        listaUtilizadores = ArrayList() //inicializo a lista de utilizadores

        //binding.recyclerView.layoutManager = LinearLayoutManager(this) //não preciso mostrar esta layout

        binding.buttonRegisto.setOnClickListener {
            val username = binding.editUser.text.toString().trim() //pede user ao utilizador
            val password = binding.editPass.text.toString().trim()
            val confPassword = binding.editConfpass.text.toString().trim()

            if (username.isNotEmpty() && password == confPassword) {
                val res = db.insertUtilizador(username, password)
                Toast.makeText(this, res.toString(), Toast.LENGTH_SHORT).show()
                CarregarUtilizadores(db)
                finish() //vai para o MainActivity e leva os "dados" consigo
            }
            else if (password != confPassword) {
                Toast.makeText(applicationContext, "As Passwords não correspondem! Tente novamente.", Toast.LENGTH_SHORT)
                    .show()
                binding.editUser.setText("") //limpa os campos
                binding.editPass.setText("")
                binding.editConfpass.setText("")
            } else {
                Toast.makeText(this, "O campo de username não pode estar vazio.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun CarregarUtilizadores(db: DBHelper) {
        listaUtilizadores = db.selectAllUtilizadorLista()
        binding.recyclerView.adapter = UtilizadorListAdapter(
            listaUtilizadores, UtilizadorListAdapter.OnClickListener { utilizador ->
                Toast.makeText(applicationContext, utilizador.username, Toast.LENGTH_SHORT).show()
            })
    }
}