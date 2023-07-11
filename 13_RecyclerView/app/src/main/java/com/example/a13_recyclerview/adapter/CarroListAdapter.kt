package com.example.a13_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a13_recyclerview.R
import com.example.a13_recyclerview.model.Carro

class CarroListAdapter (val listaCarros: ArrayList<Carro>, val onClickListener: OnClickListener) :
    RecyclerView.Adapter<CarroListAdapter.CarroViewHolder>() {
    //qnd passar o adapter já temos a lista de carros como parametro (?)

    //classe dentro de uma classe
    class CarroViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) { //vai buscar a linha da recycler view:
        //referenciar todos os elementos que colocamos na row_carro_list:
        val textView: TextView = itemView.findViewById(R.id.text_modelo)
    }

    class OnClickListener(val clickListener: (carro: Carro) -> Unit) { //Unit adiciona funcionalidades ao carro
        fun onClick(carro: Carro) = clickListener(carro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_carro_list, parent, false)
        return CarroViewHolder(view)
    } //isto é receita, colocar quase igual sempre que necessitar

    override fun getItemCount(): Int { //diz quantos elementos tenho na minha lista de carros
        return listaCarros.size
    }

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
        val carro = listaCarros[position] //posição específica: 1, 2, 3, ...
        holder.textView.text = carro.modelo //vai colocar o modelo na linha respetiva da recycler view
        holder.itemView.setOnClickListener{
            onClickListener.onClick(carro)
        }
    }
} //estrutura necessária que um adapter precisa