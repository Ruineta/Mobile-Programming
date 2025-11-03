package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.TextView
import android.widget.Button

class MainActivity : ComponentActivity() {

    private lateinit var txtvResult: TextView
    private var currentNumber = "0"
    private var latestNumber = 0.0
    private var operation: Char? = null
    private var isNewOp = true

    private fun MainActivity.setOperation(ch: Char) {
        latestNumber = currentNumber.toDouble()
        currentNumber = "0"
        operation = ch
        isNewOp = true
    }
    //Thực hiện các phép toán
    private fun MainActivity.calculateResult() {
        val newNumber = currentNumber.toDouble()
        val result = when (operation) {
            '+' -> latestNumber + newNumber
            '-' -> latestNumber - newNumber
            '*' -> latestNumber * newNumber
            '/' -> if(newNumber != 0.0) latestNumber / newNumber else Double.NaN
            else -> newNumber
        }

        txtvResult.text = if (result % 1 == 0.0) {
            result.toInt().toString()
        } else {
            result.toString()
        }
        currentNumber = txtvResult.text.toString()
        isNewOp = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bai1)

        txtvResult = findViewById(R.id.textView2)

        val numberButtons = listOf(
            R.id.button1, R.id.button, R.id.button6,
            R.id.button8, R.id.button9, R.id.button10,
            R.id.button15, R.id.button16, R.id.button17, R.id.button18
        )
        //Kiểm tra số nhập vào
        for (id in numberButtons) {
            findViewById<Button>(id).setOnClickListener {
                val digit = (it as Button).text.toString()
                if (isNewOp) {
                    currentNumber = digit
                    isNewOp = false
                } else {
                    currentNumber += digit
                }
                txtvResult.text = currentNumber
            }
        }

        //Cộng trừ nhân chia
        findViewById<Button>(R.id.button11).setOnClickListener {setOperation('+')}
        findViewById<Button>(R.id.button13).setOnClickListener {setOperation('-')}
        findViewById<Button>(R.id.button19).setOnClickListener {setOperation('*')}
        findViewById<Button>(R.id.button23).setOnClickListener {setOperation('/')}

        //Dấu bằng
        findViewById<Button>(R.id.button14).setOnClickListener {calculateResult()}

        //Xóa
        findViewById<Button>(R.id.button20).setOnClickListener {
            currentNumber = "0"
            txtvResult.text = currentNumber
        }

        //Xoá toàn bộ
        findViewById<Button>(R.id.button21).setOnClickListener {
            currentNumber = "0"
            latestNumber = 0.0
            operation = null
            isNewOp = true
            txtvResult.text = currentNumber
        }

        //Backspace
        findViewById<Button>(R.id.button22).setOnClickListener {
            currentNumber = if (currentNumber.length > 1) {
                currentNumber.substring(0, currentNumber.length - 1)
            } else {
                "0"
            }
            txtvResult.text = currentNumber
        }

        //Đổi dấu
        findViewById<Button>(R.id.button12).setOnClickListener {
            currentNumber = if (currentNumber.startsWith("-")) {
                currentNumber.substring(1)
            } else {
                "-$currentNumber"
            }
            txtvResult.text = currentNumber
        }

        //Dấu chấm
        findViewById<Button>(R.id.button13).setOnClickListener {
            if (!currentNumber.contains(".")) {
                currentNumber += "."
                txtvResult.text = currentNumber
            }
        }

    }
}
