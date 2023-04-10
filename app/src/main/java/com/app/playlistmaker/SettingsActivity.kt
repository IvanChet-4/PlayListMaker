package com.app.playlistmaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val button_settings_Home = findViewById<Button>(R.id.button_settings_Home)
        val button_settings_DarkTheme = findViewById<Button>(R.id.button_settings_DarkTheme)
        val button_settings_Share = findViewById<Button>(R.id.button_settings_Share)
        val button_settings_Support = findViewById<Button>(R.id.button_settings_Support)
        val button_settings_Confirm = findViewById<Button>(R.id.button_settings_Confirm)

        button_settings_Home.setOnClickListener {
            val displayIntent = Intent(this, MainActivity::class.java)
            startActivity(displayIntent)
        }

    }
}