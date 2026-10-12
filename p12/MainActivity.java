package com.example.database;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etName,etEmail;
    Button btnInsert,btnSelect;
    TextView tvResult;
    Databasehelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.edit1);
        etEmail=findViewById(R.id.edit2);
        btnInsert=findViewById(R.id.btn1);
        btnSelect=findViewById(R.id.btn2);
        tvResult=findViewById(R.id.text1);
        dbHelper=new Databasehelper(this);
        btnInsert.setOnClickListener(v -> {
            String name=etName.getText().toString().trim();
            String email=etEmail.getText().toString().trim();
            if (name.isEmpty()|| email.isEmpty()){
                Toast.makeText(this, "please enter name and email", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean inserted=dbHelper.insertData(name,email);
            if (inserted) {
                Toast.makeText(this, "data inserted succesfully", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etEmail.setText("");
            }
            else {
                Toast.makeText(this, "insertion failed", Toast.LENGTH_SHORT).show();

            }
        } );

        btnSelect.setOnClickListener(v -> {
            String data=dbHelper.getAllData();
            tvResult.setText(data);

        } );


    }
}