package com.example.desafio02

import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Matrix.ScaleToFit
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_restaurante.*

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

}