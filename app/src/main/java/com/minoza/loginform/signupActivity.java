package com.minoza.loginform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {

    //Declaration
    EditText etUsername, etPassword, etConfirmPassword, etFullName;
    String username, password, confirmPassword, fullname;
    int formsuccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etFullName = findViewById(R.id.etFullName);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_cancel, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnSave:

                formsuccess = 4;

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                confirmPassword = etConfirmPassword.getText().toString();
                fullname = etFullName.getText().toString();

                if (username.equals("")){
                    etUsername.setError("Invalid");
                    formsuccess --;
                }

                if (password.equals("")){
                    etPassword.setError("Invalid");
                    formsuccess--;
                }

                if (!confirmPassword.equals(password)){
                    etConfirmPassword.setError("Invalid");
                    formsuccess--;
                }

                if (fullname.equals("")){
                    etFullName.setError("Invalid");
                    formsuccess--;
                }

                if (formsuccess == 4) {
                    Toast.makeText(this, "Sign up success", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnCancel:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
