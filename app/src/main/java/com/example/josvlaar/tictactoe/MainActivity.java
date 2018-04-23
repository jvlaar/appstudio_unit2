package com.example.josvlaar.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();

        if (savedInstanceState != null) {
            game = (Game) savedInstanceState.getSerializable("game");
            for (int i = 0; i < game.BOARD_SIZE; i++) {
                for (int j = 0; j < game.BOARD_SIZE; j++) {
                    Button button = (Button) findViewById(MainActivity.this.getResources()
                            .getIdentifier("button" + i + "_" + j, "id", getBaseContext().getPackageName()));
                    Tile tile = game.getState(i, j);
                    switch (tile) {
                        case CROSS:
                            button.setText("X");
                            break;
                        case CIRCLE:
                            button.setText("O");
                            break;
                    }
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("game", game);
    }

    public void tileClicked(View view) {
        Button button = (Button) view;
        int id = button.getId();
        String name = getResources().getResourceEntryName(id);

        int x = Integer.parseInt(name.substring(6,7));
        int y = Integer.parseInt(name.substring(8,9));

        Tile tile = game.draw(x, y);
        switch(tile) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
        }
    }

    public void resetClicked(View view) {
        game = new Game();

        for (int i=0; i < game.BOARD_SIZE; i++) {
            for (int j=0; j < game.BOARD_SIZE; j++) {
                Button button = (Button) findViewById(MainActivity.this.getResources()
                        .getIdentifier("button" + i + "_" + j, "id", getBaseContext().getPackageName()));
                button.setText("");
            }
        }
    }
}
