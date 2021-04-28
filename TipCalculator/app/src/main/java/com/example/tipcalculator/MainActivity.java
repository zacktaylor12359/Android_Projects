package com.example.tipcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tipcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private View view;
    private static final String TAG = "StateChange";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        Log.i(TAG, "onCreate");
    }

    public void calculateTip(View view) {
        this.view = view;
        String prompt = "The Tip values are as follows";
        String tenPercentText = "Ten percent = $";
        String fifteenPercentText = "Fifteen percent = $";
        String twentyPercentText = "Twenty percent = $";
        String emptyField = "You must enter an amount";
        if(!mainBinding.dollarText.getText().toString().equals("")){
            float dollarValue = Float.valueOf(mainBinding.dollarText.getText().toString());
            String tenPercentValue = String.format("%.2f", dollarValue * .10F);
            String fifteenPercentValue = String.format("%.2f", dollarValue * .15F);
            String twentyPercentValue = String.format("%.2f", dollarValue * .20F);

            mainBinding.textView.setText(String.format("%s\n\n%s%s\n%s%s\n%s%s", prompt, tenPercentText,
                    tenPercentValue, fifteenPercentText, fifteenPercentValue, twentyPercentText,
                    twentyPercentValue));
        }
        else {
            mainBinding.textView.setText(emptyField);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");

        CharSequence userText = mainBinding.dollarText.getText();
        CharSequence tipVal = mainBinding.textView.getText();
        outState.putCharSequence("savedText", userText);
        outState.putCharSequence("savedCalculation", tipVal);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
        CharSequence userText =
                savedInstanceState.getCharSequence("savedText");
        CharSequence tipVal =
                savedInstanceState.getCharSequence("savedCalculation");

        mainBinding.dollarText.setText(userText);
        mainBinding.textView.setText(tipVal);
    }
}