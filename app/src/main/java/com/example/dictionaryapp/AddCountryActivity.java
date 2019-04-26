package com.example.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class AddCountryActivity extends AppCompatActivity {
    EditText etCountry,etCapital;
    Button btnAddCapital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        etCountry = findViewById(R.id.etCountry);
        etCapital = findViewById(R.id.etCapital);
        btnAddCapital= findViewById(R.id.btnAddCountry);

        btnAddCapital.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Save();
            }
        });
    }
    private void Save(){
        try{
            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(etCountry.getText().toString() + "->" + etCapital.getText().toString());
            Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Log.d("Dictionary App", "Error" + e.toString());
            e.printStackTrace();
        }
    }
}
