package com.example.mhdamagecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val currentFragment = fragmentManager
            .findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val newFragment = MainFragment()
            fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, newFragment)
                .commit()
        }
    }
}