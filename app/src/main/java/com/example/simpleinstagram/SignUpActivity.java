package com.example.simpleinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private EditText etUsername;
    private  EditText etPassword;
    private Button btnLogin;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        etEmail = findViewById(R.id.email);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                createAccount(username, password, email);
            }
        });
    }

    private void createAccount(String username, String password, String email) {

        ParseUser user = new ParseUser();
// Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
// Set custom properties

// Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    goToMain();
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });
    }

    private void goToMain(){
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
