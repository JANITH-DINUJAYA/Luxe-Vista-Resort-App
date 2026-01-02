package com.example.luxevistaresort;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    EditText name, username, pass, confirmpass;
    Button logbtn;
    DBhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        confirmpass = findViewById(R.id.confirmpass);
        logbtn = findViewById(R.id.sigbtn);
        DB = new DBhelper(this);

        logbtn.setOnClickListener(v -> {
            String uname = name.getText().toString();
            String email = username.getText().toString();
            String password = pass.getText().toString();
            String confpass = confirmpass.getText().toString();

            if (uname.isEmpty() || email.isEmpty() || password.isEmpty() || confpass.isEmpty()) {
                Toast.makeText(Signup.this, "Fill all fields", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confpass)) {
                Toast.makeText(Signup.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
            } else {
                if (!DB.checkEmail(email)) {
                    Boolean insert = DB.insertData(uname, email, password);
                    if (insert) {
                        Toast.makeText(Signup.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Signup.this, "Email already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
