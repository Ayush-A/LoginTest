package com.example.android.logintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter = 3;
    private EditText name;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.nameEditTextView);
        password = (EditText) findViewById(R.id.passwordEditTextView);
        login = (Button) findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate(String nameUser, String userPassword) {
        if (nameUser.equals("Ayush") && userPassword.equals("Ayush")) {
            Intent intent = new Intent(MainActivity.this, NextActivity.class);
            startActivity(intent);
        } else {
            counter--;
            Toast.makeText(this, "You have " + counter + " attempts left.", Toast.LENGTH_SHORT).show();
            if (counter == 0) {
                Toast.makeText(this, "You had too many incorrect attempts.", Toast.LENGTH_LONG).show();
                login.setEnabled(false);
            }
        }
    }
}
