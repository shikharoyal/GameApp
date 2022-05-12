package com.example.tictactoe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ComputerGame extends AppCompatActivity {

    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};
    boolean gameActive = true;
    ArrayList<String> emptySquares = new ArrayList<> ();

    public void computer(){

        if (gameActive) {
            int select = emptySquares.size();
        int selected = new Random().nextInt(select);
        String selectedSquare = emptySquares.get(selected);
        switch (selectedSquare) {
            case "0":
                ImageView imageView0 = findViewById(R.id.imageView0);
                imageView0.setImageResource(R.drawable.x);
                activePlayer = 0;
                emptySquares.remove(selectedSquare);
                gameState[Integer.parseInt(selectedSquare)] = activePlayer;
                imageView0.animate().translationYBy(1000f).setDuration(300);
                break;
            case "1":
                ImageView imageView1 = findViewById(R.id.imageView1);
                imageView1.setImageResource(R.drawable.x);
                activePlayer = 0;
                emptySquares.remove(selectedSquare);
                gameState[Integer.parseInt(selectedSquare)] = activePlayer;
                imageView1.animate().translationYBy(1000f).setDuration(300);
                break;

            case "2":
                ImageView imageView2 = findViewById(R.id.imageView2);
                imageView2.setImageResource(R.drawable.x);
                activePlayer = 0;
                emptySquares.remove(selectedSquare);
                gameState[Integer.parseInt(selectedSquare)] = activePlayer;
                imageView2.animate().translationYBy(1000f).setDuration(300);
                break;

            case "3":
                ImageView imageView3 = findViewById(R.id.imageView3);
                imageView3.setImageResource(R.drawable.x);
                activePlayer = 0;
                emptySquares.remove(selectedSquare);
                gameState[Integer.parseInt(selectedSquare)] = activePlayer;
                imageView3.animate().translationYBy(1000f).setDuration(300);
                break;

            case "4":
                ImageView imageView4 = findViewById(R.id.imageView4);
                imageView4.setImageResource(R.drawable.x);
                activePlayer = 0;
                emptySquares.remove(selectedSquare);
                gameState[Integer.parseInt(selectedSquare)] = activePlayer;
                imageView4.animate().translationYBy(1000f).setDuration(300);
                break;

            case "5":
                ImageView imageView5 = findViewById(R.id.imageView5);
                imageView5.setImageResource(R.drawable.x);
                activePlayer = 0;
                emptySquares.remove(selectedSquare);
                gameState[Integer.parseInt(selectedSquare)] = activePlayer;
                imageView5.animate().translationYBy(1000f).setDuration(300);
                break;

            case "6":
                ImageView imageView6 = findViewById(R.id.imageView6);
                imageView6.setImageResource(R.drawable.x);
                activePlayer = 0;
                emptySquares.remove(selectedSquare);
                gameState[Integer.parseInt(selectedSquare)] = activePlayer;
                imageView6.animate().translationYBy(1000f).setDuration(300);
                break;

            case "7":
                ImageView imageView7 = findViewById(R.id.imageView7);
                imageView7.setImageResource(R.drawable.x);
                activePlayer = 0;
                emptySquares.remove(selectedSquare);
                gameState[Integer.parseInt(selectedSquare)] = activePlayer;
                imageView7.animate().translationYBy(1000f).setDuration(300);
                break;

            case "8":
                ImageView imageView8 = findViewById(R.id.imageView8);
                imageView8.setImageResource(R.drawable.x);
                activePlayer = 0;
                emptySquares.remove(selectedSquare);
                gameState[Integer.parseInt(selectedSquare)] = activePlayer;
                imageView8.animate().translationYBy(1000f).setDuration(300);
                break;
        }
        check();
        }
    }
    public  void dropIn(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (!gameActive) {
            gameReset(view);
        }
        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn-Tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn-Tap to play");
            }


            img.animate().translationYBy(1000f).setDuration(300);

            check();

            computer();

        }
    }

    private void check() {

        for(int[] winningPosition: winPositions){
        if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                gameState[winningPosition[0]]!=2) {
            String winnerStr;
            gameActive = false;
            if(gameState[winningPosition[0]] == 0){
                winnerStr = "X has won";
            }
            else {
                winnerStr = "O has won";
            }
            TextView status = findViewById(R.id.status);
            status.setText(winnerStr);
        }
    }
}
    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_game);

        emptySquares.add("0");
        emptySquares.add("1");
        emptySquares.add("2");
        emptySquares.add("3");
        emptySquares.add("4");
        emptySquares.add("5");
        emptySquares.add("6");
        emptySquares.add("7");
        emptySquares.add("8");
    }
}