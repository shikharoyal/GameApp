package com.example.tictactoe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//
//    Button x,o;
//    int activePlayer = 0;
//    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
//    int [][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
//                             {0,3,6}, {1,4,7}, {2,5,8},
//                          {0,4,8}, {2,4,6}};
//    boolean gameActive = true;
//    public void playerTap(View view) {
//        ImageView counter = (ImageView) view;
//
//        int tappedCounter = Integer.parseInt(counter.getTag().toString());
//        if (gameState[tappedCounter] == 2) {
//            gameState[tappedCounter] = activePlayer;
//            counter.setTranslationY(-1500);
//
//            if (activePlayer == 0) {
//
//                counter.setImageResource(R.drawable.o);
//                activePlayer = 1;
//            } else {
//                counter.setImageResource(R.drawable.x);
//                activePlayer = 0;
//            }
//            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
//            for (int[] winningPosition : winPositions) {
//                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
//                        gameState[winningPosition[0]] != 2) {
//                    gameActive = false;
//                    String winner = "";
//                    if (activePlayer == 1) {
//                        winner = "0";
//                    }
//                        else {
//                            winner = "X";
//                        }
//                        Button playAgain = findViewById(R.id.button);
//                        TextView winnerTextView = findViewById(R.id.textView);
//                        winnerTextView.setText("Winner :"+winner);
//
//                        playAgain.setVisibility(View.VISIBLE);
//                        winnerTextView.setVisibility(View.VISIBLE);
//                    }
//                else {
//                    Button playAgain = findViewById(R.id.button);
//                    playAgain.setVisibility(View.VISIBLE);
//
//                }
//                }
//            }
//        }
//public void playAgain(View view){
//    Button playAgain = findViewById(R.id.button);
//    TextView winnerTextView = findViewById(R.id.textView);
//    LinearLayout linearLayout = findViewById(R.id.linearLayout);
//
//    playAgain.setVisibility(View.INVISIBLE);
//    winnerTextView.setVisibility(View.INVISIBLE);
//    for (int i = 0; i<linearLayout.getChildCount(); i++) {
//        ImageView counter = (ImageView) linearLayout.getChildAt(i);
//
//        counter.setImageDrawable(null);
//    }
//    for(int i = 0; i<gameState.length; i++){
//        gameState[i] = 2;
//    }
//    activePlayer = 0;
//    gameActive = true;
//}


        boolean gameActive = true;
    //player
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                             {0,3,6}, {1,4,7}, {2,5,8},
                             {0,4,8}, {2,4,6}};

    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
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
        }
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
    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        for(int i=0; i<gameState.length;i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn-Tap to play");
    }
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                }
            }


