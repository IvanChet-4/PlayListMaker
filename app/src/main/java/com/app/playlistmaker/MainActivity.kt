package com.app.playlistmaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val main_activity_button_Find = findViewById<Button>(R.id.button_Find)
        val main_activity_button_Settings = findViewById<Button>(R.id.button_Settings)
        val main_activity_button_Media = findViewById<Button>(R.id.button_Media)

        main_activity_button_Find.setOnClickListener {
            val displayIntent = Intent(this, FinderActivity::class.java)
            startActivity(displayIntent)
        }

        main_activity_button_Settings.setOnClickListener {
            val displayIntent = Intent(this, SettingsActivity::class.java)
            startActivity(displayIntent)
        }

        main_activity_button_Media.setOnClickListener {
            val displayIntent = Intent(this, MediatekaActivity::class.java)
            startActivity(displayIntent)
        }
    }
}