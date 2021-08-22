package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val id=intent.getStringExtra("id")
        val title1=intent.getStringExtra("title")
        val body=intent.getStringExtra("body")
        val b=5
        textView15.text=title1
        textView7.text=body
        textView9.text=id.toString()
        Log.i("hello","this is $b")
//youohh
//ddd


    }
}