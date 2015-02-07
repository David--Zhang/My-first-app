package com.example.damoyishi.developertraining;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    EditText userName;
    EditText password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.edit_username);
        password = (EditText) findViewById(R.id.edit_password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu action_bar_menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_bar, action_bar_menu);
        return super.onCreateOptionsMenu(action_bar_menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                //openSearch();
                return true;
            case R.id.action_settings:
                //openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText username = (EditText) findViewById(R.id.edit_message);
        String message = username.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void save(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", userName.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data was saved successfully", Toast.LENGTH_SHORT).show();
    }

    public void next(View view) {
        Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SharedReferenceTest.class);
        startActivity(intent);
    }
}
