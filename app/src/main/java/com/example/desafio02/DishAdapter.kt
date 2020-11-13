package com.example.desafio02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Essa classe adapter recebe uma lista e popula o RecyclerView
// Recebe também um listener que quando houver click irá chamar a interface que fará a conexão com a main activity
class DishAdapter (private val listDish: ArrayList<Dish>, val listener: OnClickDishListener): RecyclerView.Adapter<DishAdapter.DishViewHolder>() {

    // Metodo que infla o layout do item_dish.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        return DishViewHolder(itemView)
    }

    // Retorna o tamanho da lista passada no construtor (listaAlunos)
    override fun getItemCount() = listDish.size

    // Repete o que foi criado no onCreateViewHolder X vezes, sendo X o valor que o getItemCount pegou
    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        var dish: Dish = listDish.get(position)
//        holder.ivDishaurant.setImageResource(restaurant.img)
//        holder.tvDishaurantName.text = restaurant.name
//        holder.tvDishaurantAddress.text = restaurant.address
//        holder.tvDishaurantWkgHrs.text = restaurant.wkgHrs
    }

    interface OnClickDishListener {
        fun onClickDish(position: Int)
    }

    // Classe interna. Essa classe vai inflar o layout através do onCreateViewHolder
    // O inner pega tudo da classe pai (nesse caso, queremos acessar o listener do construtor do DishAdapter)
    inner class DishViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
//        var ivDishaurant: ImageView = itemView.findViewById(R.id.ivDishaurant)
//        var tvDishaurantName: TextView = itemView.findViewById(R.id.tvDishaurantName)
//        var tvDishaurantAddress: TextView = itemView.findViewById(R.id.tvDishaurantAddress)
//        var tvDishaurantWkgHrs: TextView = itemView.findViewById(R.id.tvDishaurantWkgHrs)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition // posição do item que será clicado -> "automatico"
            if(position != RecyclerView.NO_POSITION) // esse if garante que estamos clicando em um item existente no RecyclerView, pois pode acontecer de a parte grafica não atualizar e o usuario vê um item que não está mais lá e clica nele
                listener.onClickDish(position)
        }


    }

}