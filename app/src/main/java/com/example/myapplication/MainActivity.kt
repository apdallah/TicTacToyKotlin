package com.example.myapplication

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
//        calcAge.setOnClickListener {
//            var YearOfBirth:Int=birthYear.text.toString().toInt()
//            var CurrentYear:Int=Calendar.getInstance().get(Calendar.YEAR)
//            var resultCalc:Int=CurrentYear-YearOfBirth
//
//            result.text="Your Age Is $resultCalc"
//        }

    }

    fun restGame(view:View) {
        Player1ArrayList.clear()
        Player2ArrayList.clear()
        btn1.setBackgroundColor(Color.WHITE)
        btn2.setBackgroundColor(Color.WHITE)
        btn3.setBackgroundColor(Color.WHITE)
        btn4.setBackgroundColor(Color.WHITE)
        btn5.setBackgroundColor(Color.WHITE)
        btn6.setBackgroundColor(Color.WHITE)
        btn7.setBackgroundColor(Color.WHITE)
        btn8.setBackgroundColor(Color.WHITE)
        btn9.setBackgroundColor(Color.WHITE)
        btn1.text=""
        btn2.text=""
        btn3.text=""
        btn4.text=""
        btn5.text=""
        btn6.text=""
        btn7.text=""
        btn8.text=""
        btn9.text=""
        btn1.isEnabled=true
        btn2.isEnabled=true
        btn3.isEnabled=true
        btn4.isEnabled=true
        btn5.isEnabled=true
        btn6.isEnabled=true
        btn7.isEnabled=true
        btn8.isEnabled=true
        btn9.isEnabled=true
        ActivePlayer=1
    }

    fun BtnClick(view: View) {
        var btnID: Int = 0

        when (view.id) {
            R.id.btn1 -> btnID = 1
            R.id.btn2 -> btnID = 2
            R.id.btn3 -> btnID = 3
            R.id.btn4 -> btnID = 4
            R.id.btn5 -> btnID = 5
            R.id.btn6 -> btnID = 6
            R.id.btn7 -> btnID = 7
            R.id.btn8 -> btnID = 8
            R.id.btn9 -> btnID = 9
        }
        PlayGame(btnID, view as Button)
    }

    var Player1ArrayList = ArrayList<Int>()
    var Player2ArrayList = ArrayList<Int>()
    var ActivePlayer: Int = 1

    fun PlayGame(btnId: Int, selectedBtn: Button) {

        if (ActivePlayer == 1) {
            selectedBtn.isEnabled = false
            selectedBtn.setText("X")
            selectedBtn.setTextSize(25f)
            selectedBtn.setBackgroundColor(Color.parseColor("#FF4CAF50"))
            Player1ArrayList.add(btnId)
            ActivePlayer = 2
            AutoPlay()
        } else {
            selectedBtn.isEnabled = false
            selectedBtn.setText("O")
            selectedBtn.setTextSize(25f)
            selectedBtn.setBackgroundColor(Color.parseColor("#FF03A9F4"))
            Player2ArrayList.add(btnId)
            ActivePlayer = 1
        }
        checkWinner()
    }

    fun checkWinner() {
        var winner: Int = -1
        //row1
        if (Player1ArrayList.contains(1) && Player1ArrayList.contains(2) && Player1ArrayList.contains(3)) {
            winner = 1
        }
        if (Player2ArrayList.contains(1) && Player2ArrayList.contains(2) && Player2ArrayList.contains(3)) {
            winner = 2
        }
        //row2
        if (Player1ArrayList.contains(4) && Player1ArrayList.contains(5) && Player1ArrayList.contains(6)) {
            winner = 1
        }
        if (Player2ArrayList.contains(4) && Player2ArrayList.contains(5) && Player2ArrayList.contains(6)) {
            winner = 2
        }
        //row3
        if (Player1ArrayList.contains(7) && Player1ArrayList.contains(8) && Player1ArrayList.contains(9)) {
            winner = 1
        }
        if (Player2ArrayList.contains(7) && Player2ArrayList.contains(8) && Player2ArrayList.contains(9)) {
            winner = 2
        }

        //col 1
        if (Player1ArrayList.contains(1) && Player1ArrayList.contains(4) && Player1ArrayList.contains(7)) {
            winner = 1
        }
        if (Player2ArrayList.contains(1) && Player2ArrayList.contains(4) && Player2ArrayList.contains(7)) {
            winner = 2
        }

        //col 2
        if (Player1ArrayList.contains(8) && Player1ArrayList.contains(5) && Player1ArrayList.contains(2)) {
            winner = 1
        }
        if (Player2ArrayList.contains(8) && Player2ArrayList.contains(5) && Player2ArrayList.contains(2)) {
            winner = 2
        }

        //col 3
        if (Player1ArrayList.contains(3) && Player1ArrayList.contains(6) && Player1ArrayList.contains(9)) {
            winner = 1
        }
        if (Player2ArrayList.contains(3) && Player2ArrayList.contains(6) && Player2ArrayList.contains(9)) {
            winner = 2
        }

        //cross 1
        if (Player1ArrayList.contains(1) && Player1ArrayList.contains(5) && Player1ArrayList.contains(9)) {
            winner = 1
        }
        if (Player2ArrayList.contains(1) && Player2ArrayList.contains(5) && Player2ArrayList.contains(9)) {
            winner = 2
        }
        //cross 1
        if (Player1ArrayList.contains(3) && Player1ArrayList.contains(5) && Player1ArrayList.contains(7)) {
            winner = 1
        }
        if (Player2ArrayList.contains(3) && Player2ArrayList.contains(5) && Player2ArrayList.contains(7)) {
            winner = 2
        }
        if (winner != -1) {
            Toast.makeText(this, "Player $winner is the winner ", Toast.LENGTH_SHORT).show()
        }

    }

    fun AutoPlay() {
        var emptyList = ArrayList<Int>()


        //get list of empty cells
        for (cellId in 1..9) {
            if (!(Player1ArrayList.contains(cellId) || Player2ArrayList.contains(cellId))) {
                emptyList.add(cellId)
            }
        }
        if (emptyList.size > 0) {
            val rand = Random()
            val randIndex = rand.nextInt(emptyList.size - 0) + 0
            val CellID = emptyList.get(randIndex)
            var selectedBtn: Button?
            when (CellID) {
                1 -> selectedBtn = btn1
                2 -> selectedBtn = btn2
                3 -> selectedBtn = btn3
                4 -> selectedBtn = btn4
                5 -> selectedBtn = btn5
                6 -> selectedBtn = btn6
                7 -> selectedBtn = btn7
                8 -> selectedBtn = btn8
                9 -> selectedBtn = btn9
                else -> {
                    selectedBtn = btn1
                }
            }
            Log.i("MAinActivity", " Selected CellIndex: $randIndex");
            Log.i("MAinActivity", " Selected Cell: $CellID");
            PlayGame(CellID, selectedBtn)
        }
    }
}
