package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tictac.setOnClickListener {
            var intent:Intent= Intent(this,TicTacToy::class.java)
            startActivity(intent)
        }
        calc.setOnClickListener {
            var intent:Intent= Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }


    }

}
