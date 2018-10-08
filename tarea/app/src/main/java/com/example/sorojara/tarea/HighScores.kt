package com.example.sorojara.tarea

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.TextView

class HighScores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_scores)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val data = sharedPreferences.getString("hs", "08:00")

        var mensajeTexto = findViewById<TextView>(R.id.textView2)
        mensajeTexto.text = data


    }

    fun goToMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
