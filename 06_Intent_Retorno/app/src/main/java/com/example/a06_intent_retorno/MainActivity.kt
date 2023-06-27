package com.example.a06_intent_retorno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a06_intent_retorno.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var result: ActivityResultLauncher<Intent>
    private var nome = "" //variavel nome vazia, vai aparecer o campo vazio no outro lado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMudarNome.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("nome", nome) //envia o nome para outro lado
            //startActivity(i)
            result.launch(i)
        }

        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            //quando eu voltar isto vai acontecer:
            if (it.resultCode == 1 && it.data != null){
                nome = it.data!!.extras?.getString("nome").toString() //isto puxa o nome (novoNome)
                // !! = garantir que tem algo associado ao data, que ele não é nulo, mas extras pode ser nulo
                // o data é o i que vem do outro lado
                binding.textNome.text = "Olá ${nome}"
            } else if (it.resultCode == 2 && it.data != null) {
                Toast.makeText(applicationContext, "Operação cancelada", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, "Erro", Toast.LENGTH_SHORT).show()
            } //este aparece quando não tenho um result, ou seja, quando voltar para trás
        }
    }
}