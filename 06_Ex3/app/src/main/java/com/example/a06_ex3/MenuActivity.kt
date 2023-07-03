package com.example.a06_ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a06_ex3.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var result: ActivityResultLauncher<Intent>
    var username = ""
    var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegisto.setOnClickListener {
            val i = Intent(this, RegistoActivity::class.java)
            result.launch(i)
        } //vai para registo activity

        binding.buttonLogin.setOnClickListener {
            val i = Intent (this, LoginActivity::class.java)
            i.putExtra("username", username)
            i.putExtra("password", password)
            startActivity(i)
        } //vai para login activity

        binding.buttonSobre.setOnClickListener {
            startActivity(Intent(this, SobreActivity::class.java))
        }//vai para sobre activity

        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.data != null && it.resultCode == 1){
                username = it.data?.extras?.getString("username").toString()
                password = it.data?.extras?.getString("password").toString()
                Toast.makeText(applicationContext, "Dados de registo atualizados", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Erro ao atualizar dados de registo", Toast.LENGTH_SHORT).show()
            }
        }
    }
}