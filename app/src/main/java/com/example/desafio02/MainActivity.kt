package com.example.desafio02

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity(), ContractMainActivity {

    private lateinit var navController : NavController
    private lateinit var appBarConfiguration : AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.mainToolbar))

        navController = findNavController(R.id.navHostfragment) // Container dos fragments
        appBarConfiguration = AppBarConfiguration(navController.graph) // Pega o graph do controller
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun removeArrow() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun showArrow() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun transpActionBar() {
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun opaqueActionBar() {
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.colorPrimary)))
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val navHostFrag = supportFragmentManager.findFragmentById(R.id.navHostfragment)
        val currFrag = navHostFrag?.findNavController()?.currentDestination?.id

        if (currFrag == R.id.registerFragment)
            findNavController(R.id.navHostfragment).popBackStack(R.id.loginFragment, false)

    }

}