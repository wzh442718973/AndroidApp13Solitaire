package com.romain.app13solitaire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton levle1, levle2, levle3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        levle1 = findViewById(R.id.game_level_single);
        levle2 = findViewById(R.id.game_level_double);
        levle3 = findViewById(R.id.game_level_four);
        findViewById(R.id.app_game).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String level = LEVEL.SINGLE.name;
        if(levle1.isChecked()){
            level = LEVEL.SINGLE.name;
        }else if(levle2.isChecked()){
            level = LEVEL.DOUBLE.name;
        }else{
            level = LEVEL.FOUR.name;
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("level", level);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
