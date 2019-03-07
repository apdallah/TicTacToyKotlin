package com.example.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlin.math.log

class CalculatorActivity : AppCompatActivity() {
    var isNewOp = false
    var op = "*"
    var oldNumber=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calculator)
        showNumbers.setHintTextColor(Color.BLACK)
    }

    fun numberBtnClick(view: View) {
        if (isNewOp) {
            showNumbers.setText("")
        }
        isNewOp = false
        var btnSelected = view as Button
        var numberText = showNumbers.text.toString()
        when (btnSelected.id) {
            btn0.id -> {
                numberText += "0"
            }
            btn1.id -> {
                numberText += "1"
            }
            btn2.id -> {
                numberText += "2"
            }
            btn3.id -> {
                numberText += "3"
            }
            btn4.id -> {
                numberText += "4"
            }
            btn5.id -> {
                numberText += "5"
            }
            btn6.id -> {
                numberText += "6"
            }
            btn7.id -> {
                numberText += "7"
            }
            btn8.id -> {
                numberText += "8"
            }
            btn9.id -> {
                numberText += "9"
            }
            btnPlusSub.id -> {
                if(numberText.contains('-'))
                {
                    numberText=numberText.replace("-","")
                }else {
                    numberText = "-" + numberText
                }
            }
            btnDot.id -> {
                if (!numberText.contains('.'))
                    numberText += "."
            }

        }
        showNumbers.setText(numberText)
    }

    fun opClick(view: View) {
        var btnSelected = view as Button

        when (btnSelected.id) {
            btnDiv.id -> {
                op = "/"
            }
            btnMulti.id -> {
                op = "*"
            }
            btnPlus.id -> {
                op = "+"
            }
            btnSub.id -> {
                op = "-"
            }
            modl.id -> {
                op = "%"
            }
        }
        isNewOp=true
        oldNumber=showNumbers.text.toString()

    }
    fun equalBtnClick(view:View){
        var newNumber=showNumbers.text.toString()
        var result:Double?=null
        when(op){
            "*"->{
                result=oldNumber.toDouble()*newNumber.toDouble()
            }
            "/"->{
                if(!(newNumber.equals("0")||newNumber.isEmpty())) {
                    result = oldNumber.toDouble() / newNumber.toDouble()
                }else{
                    result=0.0
                }
            }
            "+"->{
                result=oldNumber.toDouble()+newNumber.toDouble()
            }
            "-"->{
                result=oldNumber.toDouble()-newNumber.toDouble()
            }
            "%"->{
//                result=Math.IEEEremainder(oldNumber.toDouble(),newNumber.toDouble())
                result=oldNumber.toDouble()-(Math.round(oldNumber.toDouble()/newNumber.toDouble())*newNumber.toDouble())
                if(result<0) {
                    result *= -1
                }

            }
        }
        showNumbers.setText(result.toString())
        isNewOp=true
    }
    fun cleanCalc(view: View){
        showNumbers.setText("")
        oldNumber=""
        isNewOp=false
        op="*"
    }
}
