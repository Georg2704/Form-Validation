package com.minoza.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //initialization
    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvCreateAcccouint;
    String username, password;
    int formsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find objects
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvCreateAcccouint = findViewById(R.id.tvCreateAccount);

        // Event Listener for Login button
        btnLogin.setOnClickListener(this);
        tvCreateAcccouint.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                //Function of button Login once it was clicked

                formsuccess = 2; // 2 since we have 2 object to validate
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                // If username is null
                if (username.equals("")){
                    etUsername.setError("Invalid");
                    formsuccess--;// always minus
                }
                //checked if password if null
                if (password.equals("")){
                    etPassword.setError("Invalid");
                    formsuccess--;// always minus
                }

                if (formsuccess == 2 ){
                    Toast.makeText(this, "Form Success Thank you", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.tvCreateAccount:
                //Function of the TextView Create Account once it was clicked
                Intent signup = new Intent(this, signupActivity.class); //WE"LL going to create a class later
                startActivity(signup);
                break;
        }
    }
}
