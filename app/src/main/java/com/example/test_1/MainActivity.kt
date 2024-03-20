package com.example.test_1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnAdd: Button
    private lateinit var btnMin: Button
    private lateinit var btnMulti: Button
    private lateinit var btnDivide: Button
    private lateinit var btnRetry: Button

    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAdd = findViewById(R.id.btn_add)
        btnMin = findViewById(R.id.btn_min)
        btnMulti = findViewById(R.id.btn_multi)
        btnDivide = findViewById(R.id.btn_divide)
        btnRetry = findViewById(R.id.btn_retry)

        etFirst = findViewById(R.id.et_first_digit)
        etSecond = findViewById(R.id.et_second_digit)
        tvResult = findViewById(R.id.tv_result)

        btnAdd.setOnClickListener(this)
        btnMin.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
        btnMulti.setOnClickListener(this)
        btnRetry.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val firstDigit = etFirst.text.toString().toDouble()
        val secondDigit = etSecond.text.toString().toDouble()
        var result = 0.0
        print(firstDigit)
        print(secondDigit)

        when (view.id) {
            R.id.btn_add -> {
                result = firstDigit + secondDigit
            }
            R.id.btn_min -> {
                result = firstDigit - secondDigit
            }
            R.id.btn_multi -> {
                result = firstDigit * secondDigit
            }
            R.id.btn_divide -> {
                result = firstDigit/secondDigit
            }
            R.id.btn_retry -> {
                etFirst.text.clear()
                etSecond.text.clear()
                etFirst.requestFocus()
                result = 0.0
            }
        }

        tvResult.text = result.toString()
    }
}