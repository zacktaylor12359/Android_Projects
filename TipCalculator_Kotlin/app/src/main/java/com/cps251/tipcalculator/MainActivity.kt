package com.cps251.tipcalculator

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cps251.tipcalculator.databinding.ActivityMainBinding


open class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calculateTip(view: View) {
        var prompt = "The tip values are as follows";
        var tenPercentText = "Ten percent = $";
        var fifteenPercentText = "Fifteen percent = $";
        var twentyPercentText = "Twenty percent = $";
        var emptyField = "You must enter an amount";
        if(binding.dollarText.text.toString() != ""){
            var dollarValue = binding.dollarText.text.toString()
            var tenPercentValue = String.format("%.2f", dollarValue.toFloat() * .10F)
            var fifteenPercentValue = String.format("%.2f", dollarValue.toFloat() * .15F)
            var twentyPercentValue = String.format("%.2f", dollarValue.toFloat() * .20F)

            binding.textView.text = "$prompt\n\n$tenPercentText$tenPercentValue\n$fifteenPercentText" +
                    "$fifteenPercentValue\n$twentyPercentText$twentyPercentValue"
        } else {
            binding.textView.text = emptyField
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("thing", "onSaveInstanceState")
        val userText: CharSequence = binding.dollarText.text
        val tipVal: CharSequence = binding.textView.text
        outState.putCharSequence("savedText", userText)
        outState.putCharSequence("savedCalculation", tipVal)
    }

    @Override
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("thing", "onRestoreInstanceState")
        val userText = savedInstanceState.getCharSequence("savedText")
        val tipVal = savedInstanceState.getCharSequence("savedCalculation")

        binding.dollarText.setText(userText)
        binding.textView.text = tipVal
    }
}