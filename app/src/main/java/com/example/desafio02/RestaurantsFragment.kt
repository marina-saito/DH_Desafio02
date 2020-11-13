package com.example.desafio02

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_restaurants.*
import kotlinx.android.synthetic.main.fragment_restaurants.view.*

class RestaurantsFragment : Fragment(), RestAdapter.OnClickRestListener {

    private lateinit var cma: ContractMainActivity

    var listRests = getAllRests()
    val adapterRest = RestAdapter(listRests, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        cma.removeArrow()
        cma.opaqueActionBar()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_restaurants, container, false)
        view.rvRestaurantes.adapter = adapterRest
        view.rvRestaurantes.layoutManager = LinearLayoutManager(context)
        view.rvRestaurantes.setHasFixedSize(true)


        return view
    }

    override fun onResume() {
        cma.removeArrow()
        cma.opaqueActionBar()
        super.onResume()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractMainActivity) cma = context

    }

    fun getAllRests() = arrayListOf(
        Restaurant(
            "Tony Roma's",
            "Av. Lavandisca, 717 - Indianópolis, São Paulo",
            "Fecha às 22:00",
            R.drawable.tony_romas
        ),
        Restaurant(
            "Aoyama - Moema",
            "Alameda dos Arapanés, 532 - Moema",
            "Fecha às 00:00",
            R.drawable.aoyama
        ),
        Restaurant(
            "Outback - Moema",
            "Av. Moaci, 187, 187 - Moema, São Paulo",
            "Fecha às 00:00",
            R.drawable.outback
        ),
        Restaurant(
            "Sí Señor!",
            "Alameda Jauaperi, 626 - Moema",
            "Fecha às 01:00",
            R.drawable.si_senor
        )
    )

    override fun onClickRest(position: Int) {
        var restaurant = listRests.get(position)
        cma.showArrow()
        findNavController().navigate(R.id.action_restaurantsFragment_to_restMenuFragment2)

    }
}