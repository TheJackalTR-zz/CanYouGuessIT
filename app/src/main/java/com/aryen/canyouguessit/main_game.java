package com.aryen.canyouguessit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class main_game extends AppCompatActivity {

    Button btnMinusX, btnMinusY, btnMinusZ,
            btnPlusX, btnPlusY, btnPlusZ;
    Button btnCheck, btnResign, btnRestart;

    TextView tvNum1, tvNum2, tvNum3;
    TextView tvInfo, tvOutput;

    Random r;

    int guess1 = 1, guess2 = 2, guess3 = 3;
    int generated1, generated2, generated3;
    int bulls = 0, cows = 0;
    int tries = 0;

    String output = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        btnMinusX = findViewById(R.id.btnminus_x);
        btnMinusY = findViewById(R.id.btnminus_y);
        btnMinusZ = findViewById(R.id.btnminus_z);

        btnPlusX = findViewById(R.id.btnplus_x);
        btnPlusY = findViewById(R.id.btnplus_y);
        btnPlusZ = findViewById(R.id.btnplus_z);

        btnCheck = findViewById(R.id.btn_check);
        btnResign = findViewById(R.id.btn_resign);
        btnRestart = findViewById(R.id.button);

        tvNum1 = findViewById(R.id.num_1);
        tvNum2 = findViewById(R.id.num_2);
        tvNum3 = findViewById(R.id.num_3);

        tvInfo = findViewById(R.id.tv_info);
        tvOutput = findViewById(R.id.tv_output);

        r = new Random();
        generateNumber();

        btnMinusX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess1 > 0){
                    guess1--;
                }
                tvNum1.setText("" + guess1);

            }
        });

        btnMinusY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess2 > 0){
                    guess2--;
                }
                tvNum2.setText("" + guess2);

            }
        });

        btnMinusZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess3 > 0){
                    guess3--;
                }
                tvNum3.setText("" + guess3);

            }
        });

        btnPlusX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess1 < 9){
                    guess1++;
                }
                tvNum1.setText("" + guess1);

            }
        });

        btnPlusY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess2 < 9){
                    guess2++;
                }
                tvNum2.setText("" + guess2);

            }
        });

        btnPlusZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess3 < 9){
                    guess3++;
                }
                tvNum3.setText("" + guess3);

            }
        });

        btnResign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnResign.setEnabled(false);
                btnCheck.setEnabled(false);

                tvInfo.setText("You Lost! The number is: " + generated1 + "" + generated2 + "" + generated3);

            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess1 == guess2 || guess1 == guess3 || guess2 == guess3){
                    tvInfo.setText("Wrong input!");

                } else {
                    tries++;
                    CheckNumber();
                    checkWin();
                    bulls = 0;
                    cows = 0;
                    tvInfo.setText("");
                }
            }
        });


    }

    private void checkWin(){

        if (bulls == 3){
            btnResign.setEnabled(false);
            btnCheck.setEnabled(false);

            tvOutput.setText("You won in " + tries + " tries!");
        }
    }

    private void generateNumber(){
        //First Digit
        generated1 = r.nextInt(9) + 1;

        //Second Digit
        do {
            generated2 = r.nextInt(9) + 1;
        }while (generated1 == generated2);

        //Third Digit
        do {
            generated3 = r.nextInt(9) + 1;
        }while (generated3 == generated1 || generated3 == generated2);
    }

    private void CheckNumber(){
        //Bulls
        if(guess1 == generated1){
            bulls++;
        }
        if(guess2 == generated2){
            bulls++;
        }
        if(guess3 == generated3){
            bulls++;
        }

        //Cows
        if(guess1 == generated2 || guess1 == generated3){
            cows++;
        }
        if(guess2 == generated1 || guess2 == generated3){
            cows++;
        }
        if(guess3 == generated1 || guess3 == generated2) {
            cows++;
        }

        output = output + "" + tries + ". " + guess1 + "" + guess2 + "" + guess3 +
                " - Bulls: " + bulls + ", Cows: " + cows + "\n";

        tvOutput.setText(output);

    }

    public void launchFirstActivity(View view) {

        Intent restart = new Intent(main_game.this, MainActivity.class);
        startActivity(restart);
    }


}