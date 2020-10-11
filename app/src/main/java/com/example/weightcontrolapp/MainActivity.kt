package com.example.weightcontrolapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
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

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        //findViewById<NavigationView>(R.id.navigation_view).setupWithNavController(navController)
        navigation_view.setupWithNavController(navController)
        navigation_view.setNavigationItemSelectedListener(this)

        appBarConfiguration = AppBarConfiguration(navController.graph, drawer_layout)

        setupActionBarWithNavController(navController, appBarConfiguration)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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
            R.id.menu_nav_weight_record_fragment -> {
                fragment = WeightRecordFragment()
            }
            R.id.menu_nav_my_page_fragment, R.id.menu_nav_record_fragment -> {
                return true
            }
            R.id.menu_nav_history_fragment -> {
                fragment = HistoryFragment()
            }
        }

        if (fragment != null) {
            val frag = supportFragmentManager.beginTransaction()
            frag.replace(R.id.nav_host_fragment, fragment)
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
            R.id.action_top -> true
            R.id.menu_nav_my_page_fragment -> true
            R.id.menu_nav_record_fragment -> true
            R.id.action_history -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
