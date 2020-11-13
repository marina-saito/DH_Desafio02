package com.example.desafio02

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    private lateinit var cma: ContractMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        cma.opaqueActionBar()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_login, container, false)

        view.btnLogin.setOnClickListener {
            cma.removeArrow()
            findNavController().navigate(R.id.action_loginFragment_to_restaurantsFragment)
        }

        view.btnRegister.setOnClickListener {
            findNavController().navigate((R.id.action_loginFragment_to_registerFragment))
        }


        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractMainActivity) cma = context
    }

}