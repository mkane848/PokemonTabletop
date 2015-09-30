package com.kemix.adventurerlog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class PickStats extends AppCompatActivity {

    public String name;
    public String age;
    public String gender;
    public String height;
    public String weight;
    public String level;
    public String characterClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_stats);

        Intent intent = getIntent();
        name = intent.getStringExtra("trainerName");
        age = intent.getStringExtra("trainerAge");
        gender = intent.getStringExtra("trainerGender");
        height = intent.getStringExtra("trainerHeight");
        weight = intent.getStringExtra("trainerWeight");
        level = intent.getStringExtra("trainerLevel");
        characterClass = intent.getStringExtra("trainerClass");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pick_stats, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendInfo(View view){
        Intent intent = new Intent(this, MainSheet.class);
        EditText trainerStr = (EditText) findViewById(R.id.trainer_str);
        EditText trainerDex = (EditText) findViewById(R.id.trainer_dex);
        EditText trainerCon = (EditText) findViewById(R.id.trainer_con);
        EditText trainerInt = (EditText) findViewById(R.id.trainer_int);
        EditText trainerWis = (EditText) findViewById(R.id.trainer_wis);
        EditText trainerCha = (EditText) findViewById(R.id.trainer_cha);
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        intent.putExtra("gender", gender);
        intent.putExtra("height", height);
        intent.putExtra("weight", weight);
        intent.putExtra("level", level);
        intent.putExtra("characterClass", characterClass);
        intent.putExtra("str", trainerStr.getText().toString());
        intent.putExtra("dex", trainerDex.getText().toString());
        intent.putExtra("con", trainerCon.getText().toString());
        intent.putExtra("int", trainerInt.getText().toString());
        intent.putExtra("wis", trainerWis.getText().toString());
        intent.putExtra("cha", trainerCha.getText().toString());
        startActivity(intent);
    }
}
