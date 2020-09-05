package com.luiz3d2.juan3d2;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recuperar();
    }
    //menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void amarelo(MenuItem item) {
        String tipo = "amarelo";
        mainLinearLayout = findViewById(R.id.mainLinearLayout);
        mainLinearLayout.setBackgroundColor(Color.rgb(255, 255, 0));
        gravar(tipo);
    }

    public void cinza(MenuItem item) {
        String tipo = "cinza";
        mainLinearLayout = findViewById(R.id.mainLinearLayout);
        mainLinearLayout.setBackgroundColor(Color.rgb(105, 105, 105));
        gravar(tipo);
    }
    //grava auteracao
    public void gravar(String tipo) {
        SharedPreferences prefs = getSharedPreferences("background", MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString("cor", tipo);
        ed.apply();
    }

    //recupera alteracao
    public void recuperar() {
        SharedPreferences prefs = getSharedPreferences("background", MODE_PRIVATE);
        if (prefs.getString("cor", "").equals("amarelo")) {
            mainLinearLayout = findViewById(R.id.mainLinearLayout);
            mainLinearLayout.setBackgroundColor(Color.rgb(128, 0, 128));
        } else if (prefs.getString("cor", "").equals("cinza")) {
            mainLinearLayout = findViewById(R.id.mainLinearLayout);
            mainLinearLayout.setBackgroundColor(Color.rgb(8, 77, 110));
        }
    }

}