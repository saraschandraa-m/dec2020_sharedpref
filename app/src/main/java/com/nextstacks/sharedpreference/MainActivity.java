package com.nextstacks.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEmailAddress;
    private EditText mEtPassword;

    private SharedPreferences prefManager;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtEmailAddress = findViewById(R.id.et_email_address);
        mEtPassword = findViewById(R.id.et_password);

        prefManager = getApplicationContext().getSharedPreferences("NEXTSTACKS", MODE_PRIVATE);
        editor = prefManager.edit();

        boolean isAlreadyLoggedIn = prefManager.getBoolean("ISLOGGEDIN", false);

        if(isAlreadyLoggedIn){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }
    }

    public void doLoginAction(View v1){
        String email = mEtEmailAddress.getText().toString();
        String pwd = mEtPassword.getText().toString();

        editor.putString("EMAIL", email);
        editor.putString("PASSWORD", pwd);
        editor.putBoolean("ISLOGGEDIN", true);
        //UI Thread
        editor.apply();

//Background Thread
//        editor.commit();

//        Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
//        startActivity(homeIntent);


        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        finish();
    }
}