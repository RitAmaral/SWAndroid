package com.example.tp_mob_anaritaamaral.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp_mob_anaritaamaral.R
import com.example.tp_mob_anaritaamaral.databinding.ActivityImagemSelecionarBinding

class ImagemSelecionarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImagemSelecionarBinding
    private lateinit var i: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagemSelecionarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        i = intent

        binding.imagemSwp.setOnClickListener { sendID(R.drawable.swp)  }
        binding.imagemSwl.setOnClickListener { sendID(R.drawable.swl) }
        binding.imagemDap.setOnClickListener { sendID(R.drawable.dap) }
        binding.imagemDal.setOnClickListener { sendID(R.drawable.dal) }
        binding.imagemCsp.setOnClickListener { sendID(R.drawable.csp) }
        binding.imagemCsl.setOnClickListener { sendID(R.drawable.csl) }
        binding.imagemFedl.setOnClickListener { sendID(R.drawable.fedl) }
        binding.btnRemoverImagem.setOnClickListener { sendID(R.drawable.iconcesae) }
    }

    private fun sendID(imagemId: Int) {
        i.putExtra("id", imagemId)
        setResult(1, i)
        finish()
    }
}