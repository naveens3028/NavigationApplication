package com.example.navigationapplication

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationapplication.databinding.ActivityMainBinding
import com.example.navigationapplication.sealed.Example
import com.example.navigationapplication.sealed.MySealedClass
import com.example.navigationapplication.sealed.NonSealedClass
import com.example.navigationapplication.ui.details.DetailsFragment

open class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

       val d = Example()
        d.myDemo()

    }

    override fun onPassData() {
        Log.e("passsed","data")
        val bundle = Bundle()
        bundle.putString("inputText", "HI")
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTwo = DetailsFragment()
        fragmentTwo.arguments = bundle
        transaction.replace(R.id.nav_host_fragment_activity_main, fragmentTwo)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}

interface Communicator{
    fun onPassData()
}