package com.aryen.canyouguessit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked");

        Intent intent = new Intent(MainActivity.this, main_game.class);

        startActivity(intent);
    }


    public void launchPurpose(View view) {
        Intent purpose = new Intent(MainActivity.this, com.aryen.canyouguessit.purpose.class);
        startActivity(purpose);
    }


}


