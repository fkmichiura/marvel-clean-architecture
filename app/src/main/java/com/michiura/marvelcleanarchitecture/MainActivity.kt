package com.michiura.marvelcleanarchitecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.michiura.presentation.characterslist.view.CharactersListFragment
import com.michiura.presentation.commons.FragmentExt.replaceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        this.replaceFragment(
            containerId = R.id.containerView,
            CharactersListFragment()
        )
    }
}
