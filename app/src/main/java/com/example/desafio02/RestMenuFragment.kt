package com.example.desafio02

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_restaurants.*
import kotlinx.android.synthetic.main.fragment_restaurants.view.*
import kotlinx.android.synthetic.main.fragment_restmenu.*
import kotlinx.android.synthetic.main.fragment_restmenu.view.*

class RestMenuFragment : Fragment(), DishAdapter.OnClickDishListener {

    private lateinit var cma: ContractMainActivity

    var listDishes = getAllDishes()
    val adapterDish = DishAdapter(listDishes, this)
    //val layoutManager = GridLayoutManager(context, 2)

    override fun onCreate(savedInstanceState: Bundle?) {
        cma.transpActionBar()
        super.onCreate(savedInstanceState)
//        cma.transpActionBar()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_restmenu, container, false)
        view.rvDishes.adapter = adapterDish
        view.rvDishes.layoutManager = GridLayoutManager(context, 2)
        view.rvDishes.setHasFixedSize(true)

        return view
    }

    override fun onResume() {
        cma.transpActionBar()
        super.onResume()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractMainActivity) cma = context
    }

    fun getAllDishes(): ArrayList<Dish> {
        var arrayListOfDishes : ArrayList<Dish> = ArrayList()

        for (i in 0..9)
            arrayListOfDishes.add(Dish("Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.mipmap.aoyama))

        return arrayListOfDishes
    }


    override fun onClickDish(position: Int) {
        var dish = listDishes.get(position)
        findNavController().navigate(R.id.action_restMenuFragment_to_dishFragment)
    }

}