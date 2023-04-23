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

        val shareToOtherApp = findViewById<Button>(R.id.button_settings_Share)

        val writeToSupport = findViewById<Button>(R.id.button_settings_Support)

        val settingsConfirm = findViewById<Button>(R.id.button_settings_Confirm)

        settingsHome.setOnClickListener {
            val displayIntent = Intent(this, MainActivity::class.java)
            startActivity(displayIntent)
            finish()
        }

        shareToOtherApp.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Привет! Вот ссылка на мое приложение: https://iv-4.ru/login")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
            finish()
        }

        writeToSupport.setOnClickListener {
            val message = "Сообщение разработчикам и разработчицам приложения Playlist Maker"
            val shareIntent = Intent(Intent.ACTION_SENDTO)
            shareIntent.data = Uri.parse("mailto:")
            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("isc47@bk.ru"))
            shareIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(shareIntent)
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