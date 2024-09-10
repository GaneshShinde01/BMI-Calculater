package com.example.bmicalculater;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight, etHeightInch, etHeightFeet;
    private Button btnCalculateBMI;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.llmain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etWeight = findViewById(R.id.etWeight);
        etHeightInch = findViewById(R.id.etHeightInEnch);
        etHeightFeet = findViewById(R.id.etHeightInFeet);
        btnCalculateBMI = findViewById(R.id.btnCalculateBMI);
        tvResult = findViewById(R.id.tvResult);
        LinearLayout linearLayout = findViewById(R.id.llmain);

        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(etWeight.getText().toString());
                int hft = Integer.parseInt(etHeightFeet.getText().toString());
                int hin = Integer.parseInt(etHeightInch.getText().toString());

                int totalIn = hft * 12 + hin;

                double totalCm = totalIn * 2.53;

                double totalM = totalCm / 100;

                double bmi = wt / (totalM * totalM);

                if(bmi > 25) {
                    tvResult.setText("You're OverWeight!!!!");
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.color_OW));
                }
                else if(bmi < 18) {
                    tvResult.setText("You're UnderWeight!!");
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.color_UW));
                }
                else {
                    tvResult.setText("You're Healthy!");
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.color_H));
                }


            }
        });
    }
}