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

class RectangleActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnKeliling: Button
    private lateinit var btnLuas: Button
    private lateinit var btnRetry: Button

    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rectangle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnKeliling = findViewById(R.id.btn_keliling)
        btnLuas = findViewById(R.id.btn_luas)
        btnRetry = findViewById(R.id.btn_retry)

        etPanjang = findViewById(R.id.et_panjang)
        etLebar = findViewById(R.id.et_lebar)
        tvResult = findViewById(R.id.tv_result)

        btnLuas.setOnClickListener(this)
        btnKeliling.setOnClickListener(this)
        btnRetry.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val panjang = etPanjang.text.toString().toDouble()
        val lebar = etLebar.text.toString().toDouble()
        var result = 0.0

        when (v?.id) {
            R.id.btn_luas -> {
                result = panjang * lebar
            }
            R.id.btn_keliling -> {
                result = 2 * (panjang + lebar)
            }
            R.id.btn_retry -> {
                etPanjang.text.clear()
                etLebar.text.clear()
                result = 0.0
                etPanjang.requestFocus()
            }
        }

        tvResult.text = result.toString()
    }
}