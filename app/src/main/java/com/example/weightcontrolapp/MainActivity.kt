package com.example.weightcontrolapp

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.weightcontrolapp.data.local.db.AppDatabase
import com.example.weightcontrolapp.ui.history.HistoryFragment
import com.example.weightcontrolapp.ui.weightrecord.WeightRecordFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    companion object {
        lateinit var db: AppDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(false)

        val toggle = ActionBarDrawerToggle(
            Activity(), drawer_layout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        navigation_view.setNavigationItemSelectedListener(this)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null

        when (item.itemId) {
            R.id.menu_nav_top_fragment, R.id.menu_nav_my_page_fragment -> {
                return true
            }
            R.id.menu_nav_weight_record_fragment -> {
                fragment = WeightRecordFragment()
            }
            R.id.menu_nav_history_fragment -> {
                fragment = HistoryFragment()
            }
        }

        if (fragment != null) {
            val frag = supportFragmentManager.beginTransaction()
            frag.replace(R.id.content, fragment)
            frag.commit()
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_nav_top_fragment -> true
            R.id.menu_nav_my_page_fragment -> true
            R.id.menu_nav_weight_record_fragment -> true
            R.id.menu_nav_history_fragment -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
