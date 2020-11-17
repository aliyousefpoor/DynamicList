package com.example.dynamiclist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var profileNavHost: View
    private lateinit var moreNavHost: View
    private lateinit var listNavHost: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        navController = Navigation.findNavController(this, R.id.moreNavHostFragment)
        profileNavHost = findViewById(R.id.profileNavHostFragment)
        moreNavHost = findViewById(R.id.moreNavHostFragment)
        listNavHost = findViewById(R.id.listNavHostFragment)


        moreNavHost.visibility = View.VISIBLE
        profileNavHost.visibility = View.GONE
        listNavHost.visibility = View.GONE
        bottomNavigation.selectedItemId = R.id.moreFragment

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.moreFragment -> {
                    navController = Navigation.findNavController(this, R.id.moreNavHostFragment)
                    moreNavHost.visibility = View.VISIBLE
                    profileNavHost.visibility = View.GONE
                    listNavHost.visibility = View.GONE
                    true
                }
                R.id.listFragment -> {
                    navController = Navigation.findNavController(this, R.id.listNavHostFragment)
                    listNavHost.visibility = View.VISIBLE
                    profileNavHost.visibility = View.GONE
                    moreNavHost.visibility = View.GONE
                    true
                }
                R.id.profileFragment -> {
                    navController = Navigation.findNavController(this, R.id.profileNavHostFragment)
                    profileNavHost.visibility = View.VISIBLE
                    moreNavHost.visibility = View.GONE
                    listNavHost.visibility = View.GONE
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    override fun onBackPressed() {
        if (!navController.navigateUp()) {
            super.onBackPressed()
        }
    }
}