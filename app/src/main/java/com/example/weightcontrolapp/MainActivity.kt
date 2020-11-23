package com.example.weightcontrolapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.weightcontrolapp.data.local.db.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var db: AppDatabase
    }

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.navHostFragment)

        navigationView.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navWeightRecordFragment,
                R.id.navHistoryFragment,
                R.id.navMyPageFragment
            ), drawer_layout
        )

        toolbar.setupWithNavController(navController, appBarConfiguration)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }
}
