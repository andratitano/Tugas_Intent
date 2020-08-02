package com.andra.tugas_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) { }

        loadFragment(FragmentBundle())
        btn_nav.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(page.id, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.bundle -> fragment = FragmentBundle()
            R.id.serializable -> fragment = FragmentSerializable()
            R.id.parcelable -> fragment = FragmentParcelable()
            R.id.implicit_dial -> fragment = FragmentImplicitDial()
            R.id.implicit_whatsapp -> fragment = FragmentWhatsapp()
        }
        return loadFragment(fragment!!)
    }

}