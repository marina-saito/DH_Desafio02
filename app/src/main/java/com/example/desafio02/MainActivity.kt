package com.example.desafio02

import android.graphics.Matrix
import android.graphics.Matrix.ScaleToFit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_restaurante.*

class MainActivity : AppCompatActivity(), RestAdapter.OnClickRestListener {

    var listRests = getAllRests()
    val adapterRest = RestAdapter(listRests, this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ivRestaurante.imageMatrix = Matrix().apply {
//
//        }

        rvRestaurantes.adapter = adapterRest
        rvRestaurantes.layoutManager = LinearLayoutManager(this)
        rvRestaurantes.setHasFixedSize(true)

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