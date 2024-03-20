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

class TemperateActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnCelcius: Button
    private lateinit var btnFahrenheit: Button
    private lateinit var btnRetry: Button

    private lateinit var etCelcius: EditText
    private lateinit var etFahrenheit: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_temperate)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnFahrenheit = findViewById(R.id.btn_fahrenheit)
        btnCelcius = findViewById(R.id.btn_celcius)
        btnRetry = findViewById(R.id.btn_retry)

        etCelcius = findViewById(R.id.et_celcius)
        etFahrenheit = findViewById(R.id.et_fahrenheit)
        tvResult = findViewById(R.id.tv_result)

        btnCelcius.setOnClickListener(this)
        btnFahrenheit.setOnClickListener(this)
        btnRetry.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val celcius = etCelcius.text.toString().toDouble()
        val fahrenheit = etFahrenheit.text.toString().toDouble()
        var result = 0.0

        when (v?.id) {
            R.id.btn_celcius -> {
                result = (celcius * 9 / 5) + 32
            }
            R.id.btn_fahrenheit -> {
                result = (5.0 / 9.0) * (fahrenheit - 32)
            }
            R.id.btn_retry -> {
                etCelcius.text.clear()
                etFahrenheit.text.clear()
                result = 0.0
                etCelcius.requestFocus()
            }
        }

        tvResult.text = result.toString()
    }
}