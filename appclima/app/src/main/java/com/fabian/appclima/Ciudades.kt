package com.fabian.appclima

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Ciudades : AppCompatActivity() {

    val TAG = "com.fabian.appclima.Ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val btn_concepcion = findViewById<Button>(R.id.btn_ciudad_concepcion)
        val btn_valdivia = findViewById<Button>(R.id.btn_ciudad_valdivia)
        val btn_shanghai = findViewById<Button>(R.id.btn_ciudad_shanghai)

        btn_concepcion.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"3870282")
            startActivity(intent)

        })

        btn_valdivia.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"3868707")
            startActivity(intent)

        })

        btn_shanghai.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG,"1796236")
            startActivity(intent)
        })


    }
}
