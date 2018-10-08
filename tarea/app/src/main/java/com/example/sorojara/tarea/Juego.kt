package com.example.sorojara.tarea

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.os.Handler
import android.media.MediaPlayer
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import java.util.Random
import kotlin.concurrent.thread


class Juego : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        mp = MediaPlayer.create (this, R.raw.ludi)
    }

    var player : Int = 0
    var controlPrint : Int = 0
    var vivo: Int = 1
    val listaMoves: MutableList<Int> = ArrayList()
    val listaJuego: MutableList<Int> = ArrayList()
    lateinit var mp: MediaPlayer



    fun goToMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onLudi() {
        mp.stop()
        mp.prepare()
        mp.release()
        mp = MediaPlayer.create (this, R.raw.ludi)
        mp.start ()
        val imageButton = findViewById<ImageButton>(R.id.imageButton2)

        imageButton.setImageResource(R.drawable.ludicolo)
        val handler = Handler()
        handler.postDelayed({ imageButton.setImageResource(R.drawable.ludicolooff) }, 750)
        //handler.postDelayed({ Thread.sleep(1000) }, 500)


    }

    fun onEsp() {
        mp.stop()
        mp.prepare()
        mp.release()
        mp = MediaPlayer.create (this, R.raw.esp)
        mp.start ()
        val imageButton = findViewById<ImageButton>(R.id.imageButton3)

        imageButton.setImageResource(R.drawable.espeon)
        val handler = Handler()
        handler.postDelayed({ imageButton.setImageResource(R.drawable.espeonoff) }, 750)
        //handler.postDelayed({ Thread.sleep(1000) }, 500)
    }

    fun onAlak() {
        mp.stop()
        mp.prepare()
        mp.release()
        mp = MediaPlayer.create (this, R.raw.alak)
        mp.start ()
        val imageButton = findViewById<ImageButton>(R.id.imageButton4)

        imageButton.setImageResource(R.drawable.alakazam)
        val handler = Handler()
        handler.postDelayed({ imageButton.setImageResource(R.drawable.alakazamoff) }, 1400)
        //handler.postDelayed({ Thread.sleep(1000) }, 500)
    }

    fun onVani() {
        mp.stop()
        mp.prepare()
        mp.release()
        mp = MediaPlayer.create (this, R.raw.vani)
        mp.start ()
        val imageButton = findViewById<ImageButton>(R.id.imageButton5)

        imageButton.setImageResource(R.drawable.vanilluxe)
        val handler = Handler()
        handler.postDelayed({ imageButton.setImageResource(R.drawable.vanilluxeoff) }, 750)
        //handler.postDelayed({ Thread.sleep(1000) }, 500)
    }

    fun onUmb() {
        mp.stop()
        mp.prepare()
        mp.release()
        mp = MediaPlayer.create (this, R.raw.umb)
        mp.start ()
        val imageButton = findViewById<ImageButton>(R.id.imageButton6)

        imageButton.setImageResource(R.drawable.umbreon)
        val handler = Handler()
        handler.postDelayed({ imageButton.setImageResource(R.drawable.umbreonoff) }, 750)
        //handler.postDelayed({ Thread.sleep(1000) }, 500)
    }

    fun onExeg() {
        mp.stop()
        mp.prepare()
        mp.release()
        mp = MediaPlayer.create (this, R.raw.exeg)
        mp.start ()
        val imageButton = findViewById<ImageButton>(R.id.imageButton7)

        imageButton.setImageResource(R.drawable.exeggcutor)
        val handler = Handler()
        handler.postDelayed({ imageButton.setImageResource(R.drawable.exeggcutoroff) }, 1350)
        //handler.postDelayed({ Thread.sleep(1000) }, 500)
    }

    fun pressLudi(view: View){
        val handler = Handler()
        if(player==1){
            listaJuego.add(1)
            onLudi()
            println("Sin ejecutar GameController")
            handler.postDelayed({gameController(view) }, 750)
            println("GameController")
        }
    }

    fun pressEsp(view: View){
        val handler = Handler()
        if(player==1){
            listaJuego.add(2)
            onEsp()
            handler.postDelayed({gameController(view) }, 750)
        }
    }

    fun pressAlak(view: View){
        val handler = Handler()
        if(player==1){
            listaJuego.add(3)
            onAlak()
            handler.postDelayed({gameController(view) }, 1400)
        }
    }

    fun pressVani(view: View){
        val handler = Handler()
        if(player==1){
            listaJuego.add(4)
            onVani()
            handler.postDelayed({gameController(view) }, 750)
        }
    }

    fun pressUmb(view: View){
        val handler = Handler()
        if(player==1){
            listaJuego.add(5)
            onUmb()
            handler.postDelayed({gameController(view) }, 750)
        }
    }

    fun pressExeg(view: View){
        val handler = Handler()
        if(player==1){
            listaJuego.add(6)
            onExeg()
            handler.postDelayed({gameController(view) }, 1350)
        }
    }

    fun onLudiPrint(num: Int) {
        val handler = Handler()
        if (controlPrint == num){

            onLudi()
            if (num == listaMoves.size-1){
                handler.postDelayed({ controlPrint = 0 }, 750)
            }else{
                handler.postDelayed({ controlPrint = num + 1 }, 850)
            }
        }else{
            handler.postDelayed({ onLudiPrint(num)}, 750)
            //onLudiPrint(num)
            println("420 llamada recursiva")
        }
    }

    fun onEspPrint(num: Int) {
        val handler = Handler()
        if (controlPrint == num){

            onEsp()
            if (num == listaMoves.size-1){
                handler.postDelayed({ controlPrint = 0 }, 750)
            }else{
                handler.postDelayed({ controlPrint = num + 1 }, 850)
            }
        }else{
            handler.postDelayed({ onEspPrint(num)}, 750)
            //onEspPrint(num)
            println("420 llamada recursiva")
        }
    }

    fun onAlakPrint(num: Int) {
        val handler = Handler()
        if (controlPrint == num){

            onAlak()
            if (num == listaMoves.size-1){
                handler.postDelayed({ controlPrint = 0 }, 1400)
            }else{
                handler.postDelayed({ controlPrint = num + 1 }, 1500)
            }
        }else{
            handler.postDelayed({ onAlakPrint(num)}, 750)
            //onAlakPrint(num)
            println("420 llamada recursiva")
        }
    }

    fun onVaniPrint(num: Int) {
        val handler = Handler()
        if (controlPrint == num){

            onVani()
            if (num == listaMoves.size-1){
                handler.postDelayed({ controlPrint = 0 }, 750)
            }else{
                handler.postDelayed({ controlPrint = num + 1 }, 850)
            }
        }else{
            handler.postDelayed({ onVaniPrint(num)}, 750)
            //onVaniPrint(num)
            println("420 llamada recursiva")
        }
    }

    fun onUmbPrint(num: Int) {
        val handler = Handler()
        if (controlPrint == num){
            val handler = Handler()
            onUmb()
            if (num == listaMoves.size-1){
                handler.postDelayed({ controlPrint = 0 }, 750)
            }else{
                handler.postDelayed({ controlPrint = num + 1 }, 850)
            }
        }else{
            handler.postDelayed({ onUmbPrint(num)}, 750)
            //onUmbPrint(num)
            println("420 llamada recursiva")
        }
    }

    fun onExegPrint(num: Int) {
        val handler = Handler()
        if (controlPrint == num){

            onExeg()
            if (num == listaMoves.size-1){
                handler.postDelayed({ controlPrint = 0 }, 1250)
            }else{
                handler.postDelayed({ controlPrint = num + 1 }, 1350)
            }
        }else{
            handler.postDelayed({ onExegPrint(num)}, 750)
            //onExegPrint(num)
            println("420 llamada recursiva")
        }
    }



    fun printJuego(){
        var suma: Int = 0

        val imageButton1 = findViewById<ImageButton>(R.id.imageButton2)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton3)
        val imageButton3 = findViewById<ImageButton>(R.id.imageButton4)
        val imageButton4 = findViewById<ImageButton>(R.id.imageButton5)
        val imageButton5 = findViewById<ImageButton>(R.id.imageButton6)
        val imageButton6 = findViewById<ImageButton>(R.id.imageButton7)

        imageButton1.setClickable(false)
        imageButton2.setClickable(false)
        imageButton3.setClickable(false)
        imageButton4.setClickable(false)
        imageButton5.setClickable(false)
        imageButton6.setClickable(false)

        val handler = Handler()
        var tiempo = 0
        var mensajeTexto = findViewById<TextView>(R.id.textView)

        if(listaMoves.isNotEmpty()){

            for (item in 0..listaMoves.size-1){
                println("420 imprimiendo el " + item)
                println("420 Control print: " + controlPrint)
                when (listaMoves[item]) {
                    1 -> {
                        //onLudi()
                        //handler.postDelayed({ onLudi()}, 1)
                        //handler.postDelayed({ Thread.sleep(750) }, 750)
                        onLudiPrint(item)
                        tiempo = 850
                        println("Tiempo agregado: " + tiempo)
                        suma += tiempo
                    }
                    2 -> {
                        //onEsp()
                        //handler.postDelayed({ onEsp()}, 1)
                        //handler.postDelayed({ Thread.sleep(750) }, 750)
                        onEspPrint(item)
                        tiempo = 850
                        println("Tiempo agregado: " + tiempo)
                        suma += tiempo
                    }
                    3 -> {
                        //onAlak()
                        //handler.postDelayed({ onAlak()}, 1)
                        //handler.postDelayed({ Thread.sleep(1400)  }, 1400)
                        onAlakPrint(item)
                        tiempo = 1500
                        println("Tiempo agregado: " + tiempo)
                        suma += tiempo
                    }
                    4 -> {
                        //onVani()
                        //handler.postDelayed({ onVani()}, 1)
                        //handler.postDelayed({ Thread.sleep(750)  }, 750)
                        onVaniPrint(item)
                        tiempo = 850
                        println("Tiempo agregado: " + tiempo)
                        suma += tiempo
                    }
                    5 -> {
                        //onUmb()
                        //handler.postDelayed({ onUmb()}, 1)
                        //handler.postDelayed({ Thread.sleep(750) }, 750)
                        onUmbPrint(item)
                        tiempo = 850
                        println("Tiempo agregado: " + tiempo)
                        suma += tiempo
                    }
                    6 -> {
                        //onExeg()
                        //handler.postDelayed({ onExeg()}, 1)
                        //handler.postDelayed({ Thread.sleep(1350) }, 1350)
                        onExegPrint(item)
                        tiempo = 1450
                        println("Tiempo agregado: " + tiempo)
                        suma += 1450
                    }
                }



            }
            println("Tiempo: " + tiempo)

            handler.postDelayed({ mensajeTexto.text = getString(R.string.Turn)}, suma.toLong()+3*tiempo.toLong()/4)
            handler.postDelayed({
                imageButton1.setClickable(true)
                imageButton2.setClickable(true)
                imageButton3.setClickable(true)
                imageButton4.setClickable(true)
                imageButton5.setClickable(true)
                imageButton6.setClickable(true)
            }, suma.toLong()+3*tiempo.toLong()/4)


        }
    }

    fun gameController(view: View){

        var play = findViewById(R.id.button4) as Button
        play.isClickable=false
        play.visibility= View.INVISIBLE

        if (vivo ==1){

            if (player == 0){
                var mensajeTexto = findViewById<TextView>(R.id.textView)
                mensajeTexto.text = getString(R.string.Says)

                val handler = Handler()

                var nuevoMove: Int = (1..6).shuffled().last()
                println("420-->agregado el " + nuevoMove)
                listaMoves.add(nuevoMove)
                handler.postDelayed({ printJuego() }, 1500)
                println("Agregado")
                /*
                for (item in listaMoves){
                    when (item) {
                        1 -> onLudi()
                        2 -> onEsp()
                        3 -> onAlak()
                        4 -> onVani()
                        5 -> onUmb()
                        6 -> onExeg()
                    }
                }
                */

                //handler.postDelayed({ player = 1 }, 1000)
                player = 1
                //val tiempo : Long = 1500 * listaMoves.size.toLong()
                //handler.postDelayed({ mensajeTexto.text = getString(R.string.Turn)}, tiempo)

            }else{
                //println("pasaIf")
                if (listaJuego.isNotEmpty()){

                    if (listaMoves.size <= listaJuego.size){

                        var comp: Int = 1
                        for (item2 in 0..listaMoves.size-1){

                            if(listaMoves[item2] != listaJuego[item2]){

                                comp = 0
                            }

                        }

                        if (comp == 0){
                            vivo = 0
                            println("420 PERDIO")
                            gameController(view)
                        }else{

                            listaJuego.clear()

                            player = 0
                            gameController(view)
                        }



                    }else {
                        //player = 1
                        var mensajeTexto = findViewById<TextView>(R.id.textView)
                        mensajeTexto.text = getString(R.string.Turn)

                    }
                }

            }
        }else{ //al perder

            var mensajeTexto = findViewById<TextView>(R.id.textView)
            mensajeTexto.text = getString(R.string.Loose)

            val fileName = "hs.txt"
            val highScores: String = applicationContext.assets.open(fileName).bufferedReader().use{
                it.readText()
            }
            println(highScores)
            val separate1 = highScores.split("\n")
            var mayor = 0

            for (i in 0 until 5){

                val item = separate1[i]

                val words = item.split(" ")

                if(listaMoves.size-1 > words[1].toInt()){
                    mayor = 1

                }

            }

            if (mayor == 1){
                val puntaje = listaMoves.size-1
                listaJuego.clear()
                listaMoves.clear()
                vivo = 1
                controlPrint = 0
                player = 0
                var play = findViewById<Button>(R.id.button4)
                play.isClickable=true
                play.visibility= View.VISIBLE

                val intent2 = Intent(this, ingresoHs::class.java)
                intent2.putExtra("EXTRA_SESSION_ID", puntaje.toString())
                startActivity(intent2)



            }else {

                listaJuego.clear()
                listaMoves.clear()
                vivo = 1
                controlPrint = 0
                player = 0
                //gameController(view)
                var play = findViewById<Button>(R.id.button4)
                play.isClickable=true
                play.visibility= View.VISIBLE
            }
        }



    }


}
