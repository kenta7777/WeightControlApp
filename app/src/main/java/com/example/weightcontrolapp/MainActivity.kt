package com.example.weightcontrolapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.weightcontrolapp.data.local.db.AppDatabase

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var db: AppDatabase
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_top -> true
            R.id.action_my_page -> true
            R.id.action_register -> true
            R.id.action_history -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
