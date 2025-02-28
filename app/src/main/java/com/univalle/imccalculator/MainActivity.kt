package com.univalle.imccalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.univalle.imccalculator.databinding.ActivityMainBinding
import android.view.View
import android.util.Log

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        calculate()
    }

    private fun calculate() {
        binding.btnCalculate.setOnClickListener {
            val height = binding.etHeight.text.toString().toFloat()
            val weight = binding.etWeight.text.toString().toFloat()

            val imc = weight / (height * height)
            Log.d("IMC", imc.toString())


            binding.tvResult.text = if (imc < 18.5) {
                "Bajo peso"
            } else if (imc in 18.5..24.9) {
                "Peso normal"
            } else if (imc in 25.0..29.9) {
                "Sobrepeso"
            } else {
                "Obesidad"
            }

            binding.etHeight.text = null
            binding.etWeight.text = null
            binding.tvPreResult.visibility = View.VISIBLE
            binding.tvResult.visibility = View.VISIBLE
        }
    }
}