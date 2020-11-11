package com.example.desafio02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_restaurante.*
import kotlinx.android.synthetic.main.item_restaurante.view.*

// Essa classe adapter recebe uma lista e popula o RecyclerView
// Recebe também um listener que quando houver click irá chamar a interface que fará a conexão com a main activity
class RestAdapter (private val listRest: ArrayList<Restaurant>, val listener: OnClickRestListener): RecyclerView.Adapter<RestAdapter.RestViewHolder>() {

    // Metodo que infla o layout do item_aluno.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurante, parent, false)
        return RestViewHolder(itemView)
    }

    // Retorna o tamanho da lista passada no construtor (listaAlunos)
    override fun getItemCount() = listRest.size

    // Repete o que foi criado no onCreateViewHolder X vezes, sendo X o valor que o getItemCount pegou
    override fun onBindViewHolder(holder: RestViewHolder, position: Int) {
        var restaurant: Restaurant = listRest.get(position)
        holder.ivRestaurant.setImageResource(restaurant.img)
        holder.tvRestaurantName.text = restaurant.name
        holder.tvRestaurantAddress.text = restaurant.address
        holder.tvRestaurantWkgHrs.text = restaurant.wkgHrs
    }

    interface OnClickRestListener {
        fun onClickRest(position: Int)
    }

    // Classe interna. Essa classe vai inflar o layout através do onCreateViewHolder
    // O inner pega tudo da classe pai (nesse caso, queremos acessar o listener do construtor do RestAdapter)
    inner class RestViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var ivRestaurant: ImageView = itemView.findViewById(R.id.ivRestaurant)
        var tvRestaurantName: TextView = itemView.findViewById(R.id.tvRestaurantName)
        var tvRestaurantAddress: TextView = itemView.findViewById(R.id.tvRestaurantAddress)
        var tvRestaurantWkgHrs: TextView = itemView.findViewById(R.id.tvRestaurantWkgHrs)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition // posição do item que será clicado -> "automatico"
            if(position != RecyclerView.NO_POSITION) // esse if garante que estamos clicando em um item existente no RecyclerView, pois pode acontecer de a parte grafica não atualizar e o usuario vê um item que não está mais lá e clica nele
                listener.onClickRest(position)
        }


    }

}