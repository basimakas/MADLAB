package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedprefences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text1);
        EditText username = findViewById(R.id.edit1);
        EditText phonenumber = findViewById(R.id.edit2);
        EditText email = findViewById(R.id.edit3);
        EditText password = findViewById(R.id.edit4);
        EditText Confirmpassword = findViewById(R.id.edit5);
        Button submit = findViewById(R.id.buttonsubmit);

        sharedprefences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        editor = sharedprefences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernames = username.getText().toString().trim();
                String phonenumbers = phonenumber.getText().toString().trim();
                String emails = email.getText().toString().trim();
                String passwords = password.getText().toString().trim();
                String confirmpasswords = Confirmpassword.getText().toString().trim();


                if (usernames.isEmpty()) {
                    username.setError("Username is Empty");
                    username.requestFocus();
                    return;
                }

                if (phonenumbers.isEmpty()) {
                    phonenumber.setError("Mobile number is empty");
                    phonenumber.requestFocus();
                    return;
                }

                if (emails.isEmpty()) {
                    email.setError("Emails is Empty");
                    email.requestFocus();
                    return;
                }

                if (passwords.length() < 6) {
                    password.setError("Length must atleast 6 length");
                    password.requestFocus();
                    return;
                }

                if (!passwords.equals(confirmpasswords)) {
                    Confirmpassword.setError("Password doesnt match");
                    Confirmpassword.requestFocus();
                    return;
                }

                Toast.makeText(MainActivity.this,
                        "Registration Successful",
                        Toast.LENGTH_SHORT).show();

                editor.putString("keyusername", usernames);
                editor.putString("keyphonenumber", phonenumbers);
                editor.putString("keyemail", emails);
                editor.putString("keypassword", passwords);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("username", usernames);
                intent.putExtra("mobile", phonenumbers);
                intent.putExtra("email", emails);
                intent.putExtra("password", passwords);

                startActivity(intent);
            }
        });
    }
}

