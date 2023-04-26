package com.app.playlistmaker

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView

class FinderActivity : AppCompatActivity() {
    //https://github.com/IvanChet-4/PlayListMaker/commit/bd3467f5a187e52233b193d47b9b3d9b0a11475d#diff-25c10ae84a45f48035361880f66f01b31ca844964fb377e7f764b79cd6a3dc2c
    //https://github.com/IvanChet-4/PlayListMaker/pull/2
       private val KEY_TEXT = ""
        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_finder)

            val inputEditText = findViewById<EditText>(R.id.inputEditText)
            val clearButton = findViewById<ImageView>(R.id.clearIcon)

            clearButton.setOnClickListener {
                inputEditText.setText("")
                val keyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                keyboard.hideSoftInputFromWindow(inputEditText.windowToken, 0)
                inputEditText.clearFocus()
            }


            val simpleTextWatcher = object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int){
                    // empty
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    clearButton.visibility = clearButtonVisibility(s)
                }

                override fun afterTextChanged(s: Editable?) {
                    // empty
                }
            }
            inputEditText.addTextChangedListener(simpleTextWatcher)
            val arrowButton = findViewById<Button>(R.id.button_finder_Home)
            arrowButton.setOnClickListener {
                val displayIntent = Intent(this, MainActivity::class.java)
                startActivity(displayIntent)
                finish()
            }
        }

        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            val inputEditText = findViewById<EditText>(R.id.inputEditText)
            outState.putString(KEY_TEXT, inputEditText.text.toString())
        }

        override fun onRestoreInstanceState(savedInstanceState: Bundle) {
            super.onRestoreInstanceState(savedInstanceState)
            savedInstanceState.getString(KEY_TEXT, "")
        }

        private fun clearButtonVisibility(s: CharSequence?): Int {
            return if (s.isNullOrEmpty()) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }
    }