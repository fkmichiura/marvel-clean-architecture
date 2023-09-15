package com.michiura.presentation.commons

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

object FragmentExt {
    fun AppCompatActivity.replaceFragment(containerId: Int, fragment: Fragment) {
        this.supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }
}
