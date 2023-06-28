package com.example.a06_ex4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex4.databinding.ActivityMainBinding
import com.example.a06_ex4.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        val qtnsal = i.extras?.getInt("qtnsal")!!.toDouble()
        val qtnvit = i.extras?.getInt("qtnvit")!!.toDouble()
        val qtnlim = i.extras?.getInt("qtnlim")!!.toDouble()
        val qtnagua = i.extras?.getInt("qtnagua")!!.toDouble()

        val precovit : Double = 10.00
        val precosal : Double = 11.00
        val precolim : Double = 2.50
        val precoagua : Double = 1.00

        val precovittot : Double = qtnvit * precovit
        val precosaltot : Double = qtnsal * precosal
        val precolimtot : Double = qtnlim * precolim
        val precoagtot : Double = qtnagua * precoagua

        var texto = ""

        if(qtnsal > 0) {
            texto = " Pedido: Salmão \n Quantidade: ${qtnsal} \n Preço total: ${precosaltot}€"
        }
        if(qtnvit > 0) {
            texto = " Pedido: Vitela \n Quantidade: ${qtnvit} \n Preço total: ${precovittot}€"
        }
        if(qtnlim > 0) {
            texto = " Pedido: Limonada \n Quantidade: ${qtnlim} \n Preço total: ${precolimtot}€"
        }
        if(qtnagua > 0) {
            texto = " Pedido: Água \n Quantidade: ${qtnagua} \n Preço total: ${precoagtot}€"
        }
        if(qtnsal > 0 && qtnagua > 0) {
            val total = precosaltot + precoagtot
            texto = " Pedido: Salmão e Água \n Quantidade: ${qtnsal} e ${qtnagua} respetivamente \n Preço Total: ${total}"
        }
        if(qtnsal > 0 && qtnlim > 0) {
            val total = precosaltot + precolimtot
            texto = " Pedido: Salmão e Limonada \n Quantidade: ${qtnsal} e ${qtnlim} respetivamente \n Preço Total: ${total}"
        }
        if(qtnvit > 0 && qtnagua > 0) {
            val total = precovittot + precoagtot
            texto = " Pedido: Vitela e Água \n Quantidade: ${qtnvit} e ${qtnagua} respetivamente \n Preço Total: ${total}"
        }
        if(qtnvit > 0 && qtnlim > 0) {
            val total = precovittot + precolimtot
            texto = " Pedido: Vitela e Limonada \n Quantidade: ${qtnvit} e ${qtnlim} respetivamente \n Preço Total: ${total}"
        }

        binding.textRes.text = texto
    }
}