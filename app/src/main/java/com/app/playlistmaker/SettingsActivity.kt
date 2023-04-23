package com.app.playlistmaker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val settingsHome = findViewById<Button>(R.id.button_settings_Home)

        val settingsConfirm = findViewById<Button>(R.id.button_settings_Confirm)

        settingsHome.setOnClickListener {
            val displayIntent = Intent(this, MainActivity::class.java)
            startActivity(displayIntent)
            finish()
        }

        settingsConfirm.setOnClickListener {
            val urlConfirm = "https://yandex.ru/legal/practicum_offer/"
            val openSite = Intent(Intent.ACTION_VIEW);
            openSite.setData(Uri.parse(urlConfirm));
            startActivity(openSite);
            finish()
        }
    }
}