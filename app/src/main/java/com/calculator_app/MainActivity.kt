package com.calculator_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "CutPasteId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Numer of Calculator
        val one = findViewById<Button>(R.id.one)
        val two = findViewById<Button>(R.id.two)
        val third = findViewById<Button>(R.id.three)
        val fourth = findViewById<Button>(R.id.four)
        val five = findViewById<Button>(R.id.five)
        val six = findViewById<Button>(R.id.six)
        val seven = findViewById<Button>(R.id.seven)
        val eight = findViewById<Button>(R.id.eight)
        val nine = findViewById<Button>(R.id.nine)
        val zero = findViewById<Button>(R.id.zero)
        val dot = findViewById<Button>(R.id.dot)

        //Maths
        val mul = findViewById<Button>(R.id.multiply)
        val plus = findViewById<Button>(R.id.plus)
        val minus = findViewById<Button>(R.id.minus)
        val divide = findViewById<Button>(R.id.divide)
        //Result
        val resultMenu = findViewById<TextView>(R.id.resultMenu)
        val answer = findViewById<Button>(R.id.answer)
        val AllClear = findViewById<Button>(R.id.allclear)



        var firstNum :Double = 0.0
        var secondNum :Double = 0.0
        var operator :String = ""

        var isNewOperator:Boolean=true

        val buttons = arrayOf(one,two,third,fourth,five,six,seven,eight,nine,zero,dot)

        for(button in buttons){
            button.setOnClickListener(){
                if(isNewOperator){
                    resultMenu.text =""
                    isNewOperator=false

                }
                val currentText = resultMenu.text.toString()
                val buttonText = (button as Button).text.toString()

                resultMenu.text = currentText + buttonText
            }
        }

        // Operation button clicks
        plus.setOnClickListener {
            firstNum = resultMenu.text.toString().toDouble()
            operator = "+"
            isNewOperator = true
        }

        minus.setOnClickListener {
            firstNum = resultMenu.text.toString().toDouble()
            operator = "-"
            isNewOperator = true
        }

        mul.setOnClickListener {
            firstNum = resultMenu.text.toString().toDouble()
            operator = "x"
            isNewOperator = true
        }

        divide.setOnClickListener {
            firstNum = resultMenu.text.toString().toDouble()
            operator = "%"
            isNewOperator = true
        }


//        AC and Equal utton

        answer.setOnClickListener(){
            secondNum = resultMenu.text.toString().toDouble()

            val result = when (operator){
                "+" -> firstNum + secondNum
                "-" -> firstNum - secondNum
                "x" -> firstNum * secondNum
                "%" -> if (secondNum != 0.0)firstNum / secondNum else {"Error"}



                else -> "Error"
            }

            resultMenu.text = result.toString()
            isNewOperator =  true
        }


        AllClear.setOnClickListener(){
            resultMenu.text ="0"
            firstNum = 0.0
            secondNum = 0.0
            operator = ""
            isNewOperator = true
        }

    }
}