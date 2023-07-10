package com.example.a13_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarroListAdapter : RecyclerView.Adapter<CarroListAdapter.CarroViewHolder>() {

    //classe dentro de uma classe
    class CarroViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) { //vai buscar a linha da recycler view:
        //referenciar todos os elementos que colocamos na row_carro_list:
        val textView: TextView = ItemView.findViewById(R.id.text_modelo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_carro_list, parent, false)
        return CarroViewHolder(view)
    } //isto é receita, colocar quase igual sempre que necessitar

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
} //estrutura necessária que um adapter precisa