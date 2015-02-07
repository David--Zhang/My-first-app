package com.example.damoyishi.developertraining;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by damoyishi on 1/12/15.
 */
public class SharedReferenceTest extends ActionBarActivity {

    public final static String DEFAULT = "N/A";
    TextView userNameTextView, passwordTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_reference_test);
        userNameTextView = (TextView) findViewById(R.id.show_username);
        passwordTextView = (TextView) findViewById(R.id.show_password);
    }

    public void load(View view) {
        SharedPreferences SharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = SharedPreferences.getString("name",DEFAULT);
        String password = SharedPreferences.getString("password",DEFAULT);
        if(name.equals(DEFAULT)||password.equals(DEFAULT)){
            Toast.makeText(this, "No data was found", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Data was loaded successfully", Toast.LENGTH_SHORT).show();
            userNameTextView.setText(name);
            passwordTextView.setText(password);
        }
    }

    public void previous(View view) {
        Toast.makeText(this, "Previous", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

