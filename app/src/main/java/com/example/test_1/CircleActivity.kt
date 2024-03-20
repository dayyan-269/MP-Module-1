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
import kotlin.math.PI

class CircleActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnKeliling: Button
    private lateinit var btnLuas: Button
    private lateinit var btnRetry: Button

    private lateinit var etRuas: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_circle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnKeliling = findViewById(R.id.btn_keliling)
        btnLuas = findViewById(R.id.btn_luas)
        btnRetry = findViewById(R.id.btn_retry)
    }

    override fun onClick(v: View?) {
        val ruas = etRuas.text.toString().toDouble()
        var result = 0.0

        when (v?.id) {
            R.id.btn_luas -> {
                result = PI * ruas * ruas
            }
            R.id.btn_keliling -> {
                result = 2 * PI * ruas
            }
            R.id.btn_retry -> {
                etRuas.text.clear()
                result = 0.0
                etRuas.requestFocus()
            }
        }

        tvResult.text = result.toString()
    }
}