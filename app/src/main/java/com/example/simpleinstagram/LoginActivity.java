package com.example.simpleinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private  EditText etPassword;
    private Button btnLogin;
    private  static  final String TAG = "loginActivity";
    private TextView newAcc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        newAcc = findViewById(R.id.newAccount);
        newAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSignUp();

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
            }
        });

    }
    private  void  login(String username, String password){
        ParseUser.logInInBackground(username,password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null){
                    Log.d(TAG, "issue with login");
                    e.printStackTrace();
                    return;
                }
                    goToMain();


            }
        });

    }

    private void goToMain(){
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void toSignUp(){
        Intent i= new Intent(this, SignUpActivity.class);
        startActivity(i);
        finish();
    }
}
