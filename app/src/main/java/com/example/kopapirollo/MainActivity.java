package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView sajatImageview;
    private ImageView enemyImageview;
    private TextView sajatPont;
    private TextView enemyPont;
    private Button buttonKo;
    private Button buttonPapir;
    private Button buttonOllo;
    private int sajatPontszam;
    private int enemyPontszam;
    private int sajatValasztas;
    private int enemyValasztas;
    private AlertDialog.Builder gameOver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sajatImageview.setImageResource(R.drawable.rock);
                sajatValasztas = 0;
                if (decide() == 1)
                {
                    enemyImageview.setImageResource(R.drawable.paper);
                    enemyPontszam += 1;
                    enemyPont.setText(String.valueOf(enemyPontszam));
                    Toast.makeText(MainActivity.this, "Az ellenfél nyert", Toast.LENGTH_SHORT).show();
                    gameOver();

                }
                else if (decide() == 2)
                {
                    enemyImageview.setImageResource(R.drawable.scissors);
                    sajatPontszam += 1;
                    sajatPont.setText(String.valueOf(sajatPontszam));
                    Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
                    gameOver();
                }
                else
                {
                    enemyImageview.setImageResource(R.drawable.rock);
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sajatImageview.setImageResource(R.drawable.paper);
                sajatValasztas = 1;
                if (decide() == 2)
                {
                    enemyImageview.setImageResource(R.drawable.scissors);
                    enemyPontszam += 1;
                    enemyPont.setText(String.valueOf(enemyPontszam));
                    Toast.makeText(MainActivity.this, "Az ellenfél nyert", Toast.LENGTH_SHORT).show();
                    gameOver();
                }
                else if (decide() == 0)
                {
                    enemyImageview.setImageResource(R.drawable.rock);
                    sajatPontszam += 1;
                    sajatPont.setText(String.valueOf(sajatPontszam));
                    Toast.makeText(MainActivity.this, "Az ellenfél nyert", Toast.LENGTH_SHORT).show();
                    gameOver();
                }
                else
                {
                    enemyImageview.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sajatImageview.setImageResource(R.drawable.scissors);
                sajatValasztas = 2;
                if (decide() == 0)
                {
                    enemyImageview.setImageResource(R.drawable.rock);
                    enemyPontszam += 1;
                    enemyPont.setText(String.valueOf(enemyPontszam));
                    Toast.makeText(MainActivity.this, "Az ellenfél nyert", Toast.LENGTH_SHORT).show();
                    gameOver();
                }
                else if (decide() == 1)
                {
                    enemyImageview.setImageResource(R.drawable.paper);
                    sajatPontszam += 1;
                    sajatPont.setText(String.valueOf(sajatPontszam));
                    Toast.makeText(MainActivity.this, "Az ellenfél nyert", Toast.LENGTH_SHORT).show();
                    gameOver();
                }
                else
                {
                    enemyImageview.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void gameOver()
    {
        if (sajatPontszam == 3)
        {
            gameOver.setTitle("Gratulálok, nyertél!").create();
            gameOver.show();
        }
        else if(enemyPontszam == 3)
        {
            gameOver.setTitle("Vesztettél!").create();
            gameOver.show();
        }
        else
        {
        }
    }

    private int decide()
    {
        Random random = new Random();
        int valasztas = 0;
         valasztas = random.nextInt(3);
         return valasztas;
    }

    private void newgame()
    {
        sajatPontszam = 0;
        enemyPontszam = 0;
        sajatValasztas = 0;
        enemyValasztas = 0;
        enemyImageview.setImageResource(R.drawable.paper);
        sajatImageview.setImageResource(R.drawable.paper);
        sajatPont.setText("0");
        enemyPont.setText("0");
    }

    private void init()
    {
        sajatImageview = findViewById(R.id.sajatImageview);
        enemyImageview = findViewById(R.id.enemyImageview);
        sajatPont = findViewById(R.id.sajatPont);
        enemyPont = findViewById(R.id.enemyPont);
        buttonKo = findViewById(R.id.buttonKo);
        buttonPapir = findViewById(R.id.buttonPapir);
        buttonOllo = findViewById(R.id.buttonOllo);
        sajatPontszam = 0;
        enemyPontszam = 0;
        sajatValasztas = 0;
        enemyValasztas = 0;
        gameOver = new AlertDialog.Builder(MainActivity.this);
        gameOver.setTitle("Játék vége")
                .setMessage("Újra akarod kezdeni?")
                .setCancelable(false)
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newgame();
                    }
                })
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

    }
}