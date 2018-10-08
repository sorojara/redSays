package com.example.sorojara.tarea

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.view.View
import android.content.SharedPreferences
import android.preference.PreferenceManager
import java.io.File
import android.R.id.edit




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method

        val mySharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val strPref = mySharedPreferences.getString("hs", null)

        if (strPref == null){
            println("Bloke: archivo no existe")
            val fileName = "hs.txt"
            val highScores: String = applicationContext.assets.open(fileName).bufferedReader().use{
                it.readText()
            }
            val editor = mySharedPreferences.edit()
            editor.putString("hs", highScores)
            editor.commit()
        }else{
            println(mySharedPreferences.getString("hs", "08:00") )
        }
    }

    fun goToJuego(view: View) {
        val intent = Intent(this, Juego::class.java)
        startActivity(intent)
    }

    fun goToHS(view: View) {
        val intent = Intent(this, HighScores::class.java)
        startActivity(intent)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
