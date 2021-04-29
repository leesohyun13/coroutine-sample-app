package com.sohyun.coroutinesampleapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.sohyun.coroutinesampleapp.R
import com.sohyun.coroutinesampleapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).let {
            binding.bottomNavigation.setupWithNavController(it.navController)
            binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
                NavigationUI.onNavDestinationSelected(item, it.navController)
            }
        }
    }
}