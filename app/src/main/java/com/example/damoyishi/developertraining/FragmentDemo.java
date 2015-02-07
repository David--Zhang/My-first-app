package com.example.damoyishi.developertraining;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by damoyishi on 1/8/15.
 */
public class FragmentDemo extends ActionBarActivity {
    //ActionBarActivity is a subclass of FragmentActivity

    Button B1, B2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_demo);
        B1 = (Button) findViewById(R.id.b1);
        B2 = (Button) findViewById(R.id.b2);
        B1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager FM = getFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();
                FragmentOne F1 = new FragmentOne();
                F1.setArguments(getIntent().getExtras());
                FT.add(R.id.fr1_id, F1);
                FT.addToBackStack(null);
                FT.commit();
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager FM = getFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();
                FragmentTwo F2 = new FragmentTwo();
                Bundle args = new Bundle();
              //args.putInt(ArticleFragment.ARG_POSITION, position);
                F2.setArguments(args);
                FT.replace(R.id.fr2_id, F2);
                FT.addToBackStack(null);
                FT.commit();
            }
        });
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
}
