package com.michiura.marvelcleanarchitecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.michiura.presentation.characterdetails.view.CharacterDetailsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerView, CharacterDetailsFragment())
            .commit()
    }
}
