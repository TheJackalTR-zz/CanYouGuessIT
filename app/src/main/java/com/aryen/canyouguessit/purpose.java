package com.aryen.canyouguessit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class purpose extends AppCompatActivity {

    String p = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose);

        TextView purpose;

        purpose = findViewById(R.id.purposeT);

        //Purpose text
        p = "The purpose of the game is very simple. Try to find a 3-digit number that the system generates randomly " +
                "and does not consist of the same numbers. There are two terms in the game called Bulls and Cows." + "\n" + "\n" +

                "Bulls: Each Bull indicates that a number is in the correct place." + "\n" + "\n" +
                "Cows: Each Cow indicates that a number is correct, but the place is incorrect." + "\n" + "\n" +
        "Winning condition" + "\n" + "\n" +

        "If the player finds three Bulls, the player wins the game.";

        purpose.setText(p);


    }

    //Back to Main Menu
    public void GoBack(View view) {
        Intent back = new Intent(purpose.this, MainActivity.class);
        startActivity(back);
    }
}
