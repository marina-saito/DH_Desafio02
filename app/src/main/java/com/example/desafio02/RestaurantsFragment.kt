package com.example.desafio02

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_restaurants.*
import kotlinx.android.synthetic.main.fragment_restaurants.view.*

class RestaurantsFragment : Fragment(), RestAdapter.OnClickRestListener {

    private lateinit var cma: ContractMainActivity

    var listRests = getAllRests()
    val adapterRest = RestAdapter(listRests, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cma.removeArrow()
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
        var aluno = listRests.get(position)
        //aluno.nome = "Pedro" // Altera o nome apenas nos dados, ou seja, na lista de alunos
        //adapterAlunos.notifyItemChanged(position) // Altera a visualização do adapter. Sem essa linha, o nome do alunp é alterado mas não é mostrado no app
        //Toast.makeText(this, aluno.nome, Toast.LENGTH_SHORT).show()
    }
}