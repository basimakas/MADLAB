package com.example.sharedpreference;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView intName, intMobile, intEmail, intPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        intName = findViewById(R.id.intName);
        intMobile = findViewById(R.id.intMobile);
        intEmail = findViewById(R.id.intEmail);
        intPassword = findViewById(R.id.intPassword);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String username = getIntent().getStringExtra("username");
        String phonenumber = getIntent().getStringExtra("mobile");
        String mail = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");

        intName.setText("Username : " + username);
        intMobile.setText("Mobile : " + phonenumber);
        intEmail.setText("Email : " + mail);
        intPassword.setText("Password : " + password);
    }
}