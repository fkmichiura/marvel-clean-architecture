package com.michiura.marvelcleanarchitecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.michiura.presentation.view.fragment.CharactersListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerView, CharactersListFragment())
            .commit()
    }
}
