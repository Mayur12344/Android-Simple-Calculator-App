package com.example.calculator;
// Make sure to replace with your actual package name
// Replace with your actual package name

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText addText1, addText2;
    private TextView textView;
    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure this matches your XML layout file name

        // Initialize views
        addText1 = findViewById(R.id.addText1);
        addText2 = findViewById(R.id.addText2);
        textView = findViewById(R.id.textView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        // Set button click listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("add");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("subtract");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("multiply");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("divide");
            }
        });
    }

    private void performOperation(String operation) {
        // Get the numbers from the EditText fields
        String num1Str = addText1.getText().toString();
        String num2Str = addText2.getText().toString();

        // Check if the fields are empty
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            textView.setText("Please enter both numbers");
            return;
        }

        // Parse the numbers
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        // Perform the operation based on the button clicked
        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textView.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        // Display the result
        textView.setText(String.valueOf(result));
    }
}
