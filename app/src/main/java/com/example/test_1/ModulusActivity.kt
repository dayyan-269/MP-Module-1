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

class ModulusActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnResult: Button
    private lateinit var btnRetry: Button

    private lateinit var etDigit: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_modulus)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etDigit = findViewById(R.id.et_digit)
        tvResult = findViewById(R.id.tv_result)

        btnResult.setOnClickListener(this)
        btnRetry.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val digit = etDigit.text.toString().toDouble()
        val result: String = if (digit % 2 == 0.0) "Even" else "Odd"

        tvResult.text = result
    }
}