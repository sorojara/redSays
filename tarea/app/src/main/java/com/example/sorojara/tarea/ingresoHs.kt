package com.example.sorojara.tarea

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import org.w3c.dom.Text
import android.widget.EditText;
import android.widget.TextView

class ingresoHs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_hs)
        val sessionId = intent.getStringExtra("EXTRA_SESSION_ID")
        var hS1:Int = sessionId.toInt()
        val mensaje = "Marcador: " + hS1
        var play = findViewById<TextView>(R.id.textView3)
        play.setText(mensaje)

    }

    fun goToHS(view: View) {
        val intent = Intent(this, HighScores::class.java)
        startActivity(intent)
    }

    fun addHS(view: View){
        val mySharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val data = sharedPreferences.getString("hs", "08:00")

        val sessionId = intent.getStringExtra("EXTRA_SESSION_ID")
        var hS1:Int = sessionId.toInt()


        val separate1 = data.split("\n")
        var cambio = 0
        var nuevoFile = ""
        var play = findViewById<EditText>(R.id.editText)
        var nombre = play.getText().toString()




        for (i in 0 until 4){
            val item = separate1[i]

            val words = item.split(" ")

            if(hS1> words[1].toInt() && cambio == 0){
                var buffer = nombre + " "+ hS1 + "\n"
                nuevoFile += buffer
                cambio = 1
                nuevoFile += separate1[i] + "\n"
                hS1 = 0

            }else{
                nuevoFile += separate1[i] + "\n"
            }

        }
        if(cambio == 0){
            var buffer = nombre + " "+ hS1 + "\n"
            nuevoFile += buffer
        }
        println(nuevoFile)

        val editor = mySharedPreferences.edit()
        editor.putString("hs", nuevoFile)
        editor.commit()

        goToHS(view)

    }
}
