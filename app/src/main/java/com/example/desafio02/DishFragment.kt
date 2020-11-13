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

class DishFragment : Fragment() {

    private lateinit var cma: ContractMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        cma.transpActionBar()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_dish, container, false)

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


}