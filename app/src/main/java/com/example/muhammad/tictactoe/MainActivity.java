package com.example.muhammad.tictactoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private int score [];
    private int currentPlayer;
    Button [] blocks;
    int movesLeft;
    TextView player_TextView;
    TextView score_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = new int [2];
        score[0] = 0;
        score [1] = 0;
        player_TextView = (TextView) findViewById(R.id.player_TextView);
        score_TextView = (TextView) findViewById(R.id.score_TextView);
        initiateBoard();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_new){
            clearBoard();
        }
        else
            if(id == R.id.action_exit) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        return super.onOptionsItemSelected(item);
    }

    private void initiateBoard() {
        blocks = new Button [9];
        blocks[0] = (Button) findViewById(R.id.button0);
        blocks[1] = (Button) findViewById(R.id.button1);
        blocks[2] = (Button) findViewById(R.id.button2);
        blocks[3] = (Button) findViewById(R.id.button3);
        blocks[4] = (Button) findViewById(R.id.button4);
        blocks[5] = (Button) findViewById(R.id.button5);
        blocks[6] = (Button) findViewById(R.id.button6);
        blocks[7] = (Button) findViewById(R.id.button7);
        blocks[8] = (Button) findViewById(R.id.button8);

        clearBoard();
    }


    public void click_0(View view) {
        if(blocks[0].isEnabled()) {
            blocks[0].setEnabled(false);
            setBlock(0);
            if (!checkBlocks(0, 1, 2) && !checkBlocks(0, 3, 6) && !checkBlocks(0,4,8)) {
                movesLeft--;
                if(movesLeft>0)
                    switchPlayer();//not win
                else
                    draw();
            }
            else{
                win();
            }
        }
    }

    public void click_1(View view) {
        if(blocks[1].isEnabled()) {
            blocks[1].setEnabled(false);
            setBlock(1);
            if (!checkBlocks(1, 0, 2) && !checkBlocks(1, 4, 7)) {
                movesLeft--;
                if(movesLeft>0)
                    switchPlayer();//not win
                else
                    draw();
            }
            else{
                win();
            }
        }
    }

    public void click_2(View view) {
        if(blocks[2].isEnabled()) {
            blocks[2].setEnabled(false);
            setBlock(2);
            if (!checkBlocks(2, 0, 1) && !checkBlocks(2, 5, 8) && !checkBlocks(2, 4, 6)) {
                movesLeft--;
                if(movesLeft>0)
                    switchPlayer();//not win
                else
                    draw();
            }
            else{
                win();
            }
        }
    }

    public void click_3(View view) {
        if(blocks[3].isEnabled()) {
            blocks[3].setEnabled(false);
            setBlock(3);
            if (!checkBlocks(3, 0, 6) && !checkBlocks(3, 4, 5)) {
                movesLeft--;
                if(movesLeft>0)
                    switchPlayer();//not win
                else
                    draw();
            }
            else{
                win();
            }
        }
    }

    public void click_4(View view) {
        if(blocks[4].isEnabled()) {
            blocks[4].setEnabled(false);
            setBlock(4);
            if (!checkBlocks(4, 1, 7) && !checkBlocks(4, 3, 5) && !checkBlocks(4, 2, 6) && !checkBlocks(4, 0, 8)) {
                movesLeft--;
                if(movesLeft>0)
                    switchPlayer();//not win
                else
                    draw();
            }
            else{
                win();
            }
        }
    }

    public void click_5(View view) {
        if(blocks[5].isEnabled()) {
            blocks[5].setEnabled(false);
            setBlock(5);
            if (!checkBlocks(5, 3, 4) && !checkBlocks(5, 2, 8)) {
                movesLeft--;
                if(movesLeft>0)
                    switchPlayer();//not win
                else
                    draw();
            }
            else{
                win();
            }
        }
    }

    public void click_6(View view) {
        if(blocks[6].isEnabled()) {
            blocks[6].setEnabled(false);
            setBlock(6);
            if (!checkBlocks(6, 0, 3) && !checkBlocks(6, 7, 8) && !checkBlocks(6, 4, 2)) {
                movesLeft--;
                if(movesLeft>0)
                    switchPlayer();//not win
                else
                    draw();
            }
            else{
                win();
            }
        }
    }

    public void click_7(View view) {
        if(blocks[7].isEnabled()) {
            blocks[7].setEnabled(false);
            setBlock(7);
            if (!checkBlocks(7, 4, 1) && !checkBlocks(7, 6, 8)) {
                movesLeft--;
                if(movesLeft>0)
                    switchPlayer();//not win
                else
                    draw();
            }
            else{
                win();
            }
        }
    }

    public void click_8(View view) {
        if(blocks[8].isEnabled()) {
            blocks[8].setEnabled(false);
            setBlock(8);
            if (!checkBlocks(8, 2, 5) && !checkBlocks(8, 6, 7) && !checkBlocks(8, 4, 0)) {
                movesLeft--;
                if(movesLeft>0)
                    switchPlayer();//not win
                else
                    draw();
            }
            else{
                win();
            }
        }
    }

    private void draw() {
        player_TextView.setText("Draw Game.");
        score_TextView.setText("Player 1 Score: "+score[0]+"\nPlayer 2 Score: "+score[1]);
        playAgainPopUp("Draw Game!");

    }

    private void playAgainPopUp(String title) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(title);
        alertDialog.setMessage("Player 1 Score: "+score[0]+"\nPlayer 2 Score: "+score[1]+"\nPlay Again?");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearBoard();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }


    private void clearBoard() {
        for(int i=0; i<blocks.length;i++) {
            blocks[i].setText("");
            blocks[i].setEnabled(true);
            blocks[i].setBackgroundColor(Color.rgb(225, 225, 225));
        }
        LinearLayout bg = (LinearLayout) findViewById(R.id.background);
        bg.setBackgroundColor(Color.rgb(235,235,235));
        currentPlayer=1;
        movesLeft=9;
        player_TextView.setText("Player 1");
        score_TextView.setText("");
    }

    private void switchPlayer() {
        LinearLayout background = (LinearLayout) findViewById(R.id.background);
        if(currentPlayer==1) {
            currentPlayer = 2;
            background.setBackgroundColor(Color.rgb(185,185,185));
        }
        else {
            currentPlayer = 1;
            background.setBackgroundColor(Color.rgb(235,235,235));
        }
        player_TextView.setText("Player "+currentPlayer);

    }

    private void win() {
        score[currentPlayer-1]++;
        player_TextView.setText("Player "+currentPlayer+" won!");
        score_TextView.setText("Player 1 Score: "+score[0]+"\nPlayer 2 Score: "+score[1]);
        for(int i=0; i<blocks.length;i++){
            blocks[i].setEnabled(false);
        }
        playAgainPopUp("Player "+currentPlayer+" won!");

    }

    private boolean checkBlocks(int x, int i, int j) {
        if(currentPlayer == 1) {
            if (blocks[i].getText().equals("X") && blocks[j].getText().equals("X")) {
                blocks[x].setBackgroundColor(Color.BLACK);
                blocks[i].setBackgroundColor(Color.BLACK);
                blocks[j].setBackgroundColor(Color.BLACK);
                return true;
            }
        }
        else{
            if (blocks[i].getText().equals("O") && blocks[j].getText().equals("O")) {
                blocks[x].setBackgroundColor(Color.BLACK);
                blocks[i].setBackgroundColor(Color.BLACK);
                blocks[j].setBackgroundColor(Color.BLACK);
                return true;
            }
        }
        return false;
    }

    public void setBlock(int i) {
        if(currentPlayer==1)
            blocks[i].setText("X");
        else
            blocks[i].setText("O");
    }

    @Override
    public void onBackPressed() {

        android.os.Process.killProcess(android.os.Process.myPid());
        // This above line close correctly
    }
}
