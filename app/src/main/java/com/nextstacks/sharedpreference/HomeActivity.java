package com.nextstacks.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    private SharedPreferences prefManager;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        prefManager = getApplicationContext().getSharedPreferences("NEXTSTACKS", MODE_PRIVATE);
        editor = prefManager.edit();
    }

    public void doLogoutAction(View v){
        editor.putString("EMAIL", "");
        editor.putString("PASSWORD", "");
        editor.putBoolean("ISLOGGEDIN", false);
        editor.apply();

        startActivity(new Intent(HomeActivity.this, MainActivity.class));
        finish();
    }
}