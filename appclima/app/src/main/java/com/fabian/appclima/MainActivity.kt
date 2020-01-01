package com.fabian.appclima

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    var txt_ciudad:TextView? = null
    var txt_grados:TextView? = null
    var txt_Estatus:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_ciudad = findViewById(R.id.txtview_ciudad)
        txt_grados = findViewById(R.id.txtview_grados)
        txt_Estatus = findViewById(R.id.txtview_tiempo)

        val ciudad = intent.getStringExtra("com.fabian.appclima.Ciudades.CIUDAD")


        if(Network.checkRed(this)){
            //2890d0c002d9d8117bf988ee76aef1c4
            getHTTPVolley("http://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=2890d0c002d9d8117bf988ee76aef1c4&units=metric&lang=es")


        }else{
            Toast.makeText(this,"Sin Internet",Toast.LENGTH_SHORT)
        }

    }

    private fun getHTTPVolley(url:String){
        val queue = Volley.newRequestQueue(this)
        val get = StringRequest(Request.Method.GET, url, Response.Listener<String> {
                response ->
            try {
                Log.d("getHTTPVolley",response)
                val gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad::class.java)

                txt_ciudad?.text = ciudad.name
                txt_grados?.text = ciudad.main?.temp.toString()+""
                txt_Estatus?.text = ciudad.weather?.get(0)?.description

            }catch (e:Exception){

            }
        }, Response.ErrorListener {  })
        queue.add(get)
    }
}
