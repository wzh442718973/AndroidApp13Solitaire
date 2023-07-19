package com.romain.app13solitaire;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

// En étendant non pas AppCompatActivity mais Activity
public class MainActivity extends AppCompatActivity implements IGameOver, View.OnClickListener {

    private GameView gameView;
    private LEVEL level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        try{
            String aa = getIntent().getStringExtra("level");
            if(LEVEL.FOUR.name.equalsIgnoreCase(aa)){
                level = LEVEL.FOUR;
            }else if(LEVEL.DOUBLE.name.equalsIgnoreCase(aa)){
                level = LEVEL.DOUBLE;
            }else{
                level = LEVEL.SINGLE;
            }
        }catch (Throwable e){
            this.level = LEVEL.SINGLE;
        }

        gameView = findViewById( R.id.gameView );
        gameView.restart(level);
        gameView.setCallBack(this);

        findViewById(R.id.new_game).setOnClickListener(this);
    }

    @Override
    public void OnGameOver() {
        Log.e("wzh", "OnGameOver");
        new AlertDialog.Builder(this).setTitle(R.string.won_tip).setMessage(R.string.won_message).setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gameView.restart(level);
            }
        }).setNeutralButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        }).create().show();
    }

    @Override
    public void onClick(View v) {
        new AlertDialog.Builder(this).setTitle(R.string.new_tip).setMessage(R.string.new_message).setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gameView.restart(level);
            }
        }).setNeutralButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }
}
