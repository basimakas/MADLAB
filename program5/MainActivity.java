package com.example.toggle;

import android.os.Bundle;import android.view.View;import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
     ImageView i1,i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        i1 = findViewById(R.id.cake1);
        i2 = findViewById(R.id.cake2);
        i1.setOnClickListener(this::onClick);
        i2.setOnClickListener(this::onClick);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }private  void onClick(View view){
        if (view.getId()==R.id.cake1) {
            i1.setVisibility(View.GONE);
            i2.setVisibility(View.VISIBLE);
        }
        else {
            i2.setVisibility(View.GONE);
            i1.setVisibility(View.VISIBLE);
        }
        }
    }
