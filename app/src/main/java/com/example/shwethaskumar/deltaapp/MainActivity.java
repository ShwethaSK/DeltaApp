package com.example.shwethaskumar.deltaapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int value_r=0,value_g=0,value_b=0;
    TextView changingValue_r,changingValue_g,changingValue_b;
    LinearLayout lineLay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        lineLay=(LinearLayout) findViewById(R.id.linearLayout);
        changingValue_r=(TextView) findViewById(R.id.value_red);
        changingValue_r.setText(String.valueOf(value_r));
        changingValue_g=(TextView) findViewById(R.id.value_green);
        changingValue_g.setText(String.valueOf(value_g));
        changingValue_b=(TextView) findViewById(R.id.value_blue);
        changingValue_b.setText(String.valueOf(value_b));
        setSupportActionBar(toolbar);
        load_game();
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

        //noinspection SimplifiableIfStatement
      /* switch(id){
           case R.id.menu_save:
               SharedPreferences saveGame=getSharedPreferences("save",MODE_PRIVATE);
               SharedPreferences.Editor editor1=saveGame.edit();
               SharedPreferences.Editor editor2=saveGame.edit();
               SharedPreferences.Editor editor3=saveGame.edit();
               editor1.putInt("SavedValue1",value_r);
               editor2.putInt("SavedValue2",value_g);
               editor3.putInt("SavedValue3",value_b);
               editor1.apply();
               editor2.apply();
               editor3.apply();
               Toast.makeText(getApplicationContext(),"Saved game successfully", Toast.LENGTH_SHORT).show();
               break;
           case R.id.menu_load:
               SharedPreferences loadGame=getSharedPreferences("save",MODE_PRIVATE);
               value_r=loadGame.getInt("SavedValue1",0);
               changingValue_r.setText(String.valueOf(value_r));
               value_g=loadGame.getInt("SavedValue2",0);
               changingValue_g.setText(String.valueOf(value_g));
               value_b=loadGame.getInt("SavedValue3",0);
               changingValue_b.setText(String.valueOf(value_b));
               setColor();
               Toast.makeText(getApplicationContext(),"Loaded game successfully", Toast.LENGTH_SHORT).show();
               break;
           case R.id.menu_new_game:
               value_r=0;value_g=0;value_b=0;
               changingValue_r.setText(String.valueOf(value_r));
               changingValue_g.setText(String.valueOf(value_g));
               changingValue_b.setText(String.valueOf(value_b));
               setColor();
               Toast.makeText(getApplicationContext(),"New game loaded successfully", Toast.LENGTH_SHORT).show();
               break;
       }*/

        return super.onOptionsItemSelected(item);
    }
    public void refresh(View view)
    {
        value_r=0;value_g=0;value_b=0;
        changingValue_r.setText(String.valueOf(value_r));
        changingValue_g.setText(String.valueOf(value_g));
        changingValue_b.setText(String.valueOf(value_b));
        setColor();
            }
    public void increaseValueRed(View view)
    {
        value_r=value_r+1;
        if(value_r>=255)
            value_r=0;
        changingValue_r.setText(String.valueOf(value_r));
        setColor();
        save_game();
    }

    public void increaseValueGreen(View view)
    {
        value_g=value_g+1;
        if(value_g>=255)
            value_g=0;
        changingValue_g.setText(String.valueOf(value_g));
        setColor();
        save_game();
    }
    public void increaseValueBlue(View view)
    {
        value_b=value_b+1;
        if(value_b>=255)
            value_b=0;
        changingValue_b.setText(String.valueOf(value_b));
        setColor();
        save_game();
    }
    public void setColor()

    {
        lineLay.setBackgroundColor(Color.rgb(value_r,value_g,value_b));
    }
    public void save_game()
    {
        SharedPreferences saveGame=getSharedPreferences("save",MODE_PRIVATE);
        SharedPreferences.Editor editor1=saveGame.edit();
        SharedPreferences.Editor editor2=saveGame.edit();
        SharedPreferences.Editor editor3=saveGame.edit();
        editor1.putInt("SavedValue1",value_r);
        editor2.putInt("SavedValue2",value_g);
        editor3.putInt("SavedValue3",value_b);
        editor1.apply();
        editor2.apply();
        editor3.apply();
    }
    public void load_game()
    {
        SharedPreferences loadGame=getSharedPreferences("save",MODE_PRIVATE);
        value_r=loadGame.getInt("SavedValue1",0);
        changingValue_r.setText(String.valueOf(value_r));
        value_g=loadGame.getInt("SavedValue2",0);
        changingValue_g.setText(String.valueOf(value_g));
        value_b=loadGame.getInt("SavedValue3",0);
        changingValue_b.setText(String.valueOf(value_b));
        setColor();

    }
}
