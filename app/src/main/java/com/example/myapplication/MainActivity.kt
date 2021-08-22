package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val a=5
        bttn.setOnClickListener {
           val title=textView3.text.toString().trim();
            val body=textView10.text.toString().trim();
            val user=textView11.text.toString().toInt();
            Log.i("hello","this is $a")
            val retrofitBuilder=Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
            val api=retrofitBuilder.create(Api::class.java)
            val request=Request(title,body,user)
           val call=  api.inputData(request)
            call.enqueue(object:Callback<Response>{
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                   val resp= response.body()

                    val intent = Intent(this@MainActivity,MainActivity2::class.java)
                    if (resp != null) {
                        intent.putExtra("title",resp.title)
                        intent.putExtra("body",resp.body)
                        intent.putExtra("user",resp.userId)
                    }

                    startActivity(intent)



                }

                override fun onFailure(call: Call<Response>, t: Throwable) {
                    TODO("Not yet implemented")

                }

            })
        }
    }
}