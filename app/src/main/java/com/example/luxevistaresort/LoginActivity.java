package com.example.luxevistaresort;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText emailInput, passwordInput;
    Button loginBtn;
    TextView guestLogin, signup;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        emailInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.pass);
        loginBtn = findViewById(R.id.logbtn);
        guestLogin = findViewById(R.id.guest);
        signup = findViewById(R.id.sign);

        DB = new DBhelper(this);

        loginBtn.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {

                boolean checkUserPass = DB.checkEmailPassword(email, password);
                if (checkUserPass) {
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        guestLogin.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, Dashboard.class);
            startActivity(intent);
        });

        signup.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, Signup.class);
            startActivity(intent);
        });
    }
}
