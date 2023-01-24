package com.example.bmiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight = findViewById(R.id.wtid);
        EditText edtHeightInFt = findViewById(R.id.heightinftid);
        EditText edtHeightInIn = findViewById(R.id.heightininchid);
        Button calbtn = findViewById(R.id.btnid);
        TextView textResult = findViewById(R.id.resultid);

        LinearLayout backgroundChange = findViewById(R.id.LLMain);

        calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int heightFt = Integer.parseInt(edtHeightInFt.getText().toString());
                int heightIn = Integer.parseInt(edtHeightInIn.getText().toString());

                int totalIn = heightFt*12 + heightIn;
                double totoalCm = totalIn*2.53;
                double totalM = totoalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi==25){
                    textResult.setText("Your are healthy ");
                    backgroundChange.setBackgroundColor(getResources().getColor(R.color.Healthy));
                }else if(bmi>25){
                    textResult.setText("Your are over weight ");
                    backgroundChange.setBackgroundColor(getResources().getColor(R.color.OverWt));
                }else{
                    textResult.setText("Your are Under Weight ");
                    backgroundChange.setBackgroundColor(getResources().getColor(R.color.UnderWt));
                }

            }
        });
    }
}