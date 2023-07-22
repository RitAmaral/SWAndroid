package com.example.tp_mob_anaritaamaral.views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tp_mob_anaritaamaral.R
import com.example.tp_mob_anaritaamaral.data.DBHelper
import com.example.tp_mob_anaritaamaral.databinding.ActivityAddCursoBinding
import java.text.SimpleDateFormat
import java.util.Date

class AddCursoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCursoBinding
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private var id: Int? = -1

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHelper(this)

        //ler os valores e registar curso
        binding.buttonAdicionar.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val local = binding.editLocal.text.toString()
            val inicio = binding.editInicio.text.toString()
            val fim = binding.editFim.text.toString()
            val preco = binding.editPreco.text.toString().toInt()
            val duracao = binding.editDuracao.text.toString().toInt()
            val edicao = binding.editEdicao.text.toString()
            val imagemID = -1

            //val formatoData = SimpleDateFormat("dd-MM-yyyy")
            //val dataInicial: Date? = formatoData.parse(inicio)
            //val dataFinal: Date? = formatoData.parse(fim)

            if (nome.isNotEmpty() && local.isNotEmpty() && inicio.isNotEmpty() && fim.isNotEmpty()
                && preco != null && duracao != null && edicao.isNotEmpty() && imagemID != null)
            {
                val res = db.insertCurso(
                    nome,
                    local,
                    inicio,
                    fim,
                    preco,
                    duracao.toInt(),
                    edicao,
                    imagemID.toInt()
                )

                if (res > 0) {
                    Toast.makeText(applicationContext, getString(R.string.curso_adicionado), Toast.LENGTH_SHORT)
                        .show()
                    setResult(1, intent)
                    finish()
                    //db.close()
                } else {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.erro_curso_nao_adicionado),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
        //selecionar imagem que quero que apareça
        binding.imagem.setOnClickListener {
            launcher.launch(Intent(applicationContext, ImagemSelecionarActivity::class.java))
        }
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null && it.resultCode == 1) {
                id = it.data?.extras?.getInt("id")
                binding.imagem.setImageDrawable(resources.getDrawable(id!!))
            } else {
                id = -1
                binding.imagem.setImageResource(R.drawable.iconcesae)
            }
        }
    }
}
