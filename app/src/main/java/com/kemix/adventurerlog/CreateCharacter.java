package com.kemix.adventurerlog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CreateCharacter extends AppCompatActivity {

    List<String> ageSpinnerArray = new ArrayList<String>();
    List<String> levelSpinnerArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_character);

        for (int i = 1; i <= 100; i++){
            ageSpinnerArray.add(Integer.toString(i));
            if (i < 51){
                levelSpinnerArray.add(Integer.toString(i));
            }
        }

        Spinner  gamesSpinner = (Spinner) findViewById(R.id.games_spinner);
        ArrayAdapter<CharSequence> gamesAdapter = ArrayAdapter.createFromResource(this, R.array.games_array, android.R.layout.simple_spinner_item);
        gamesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gamesSpinner.setAdapter(gamesAdapter);

        Spinner genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
        ArrayAdapter<CharSequence>  genderAdapter = ArrayAdapter.createFromResource(this, R.array.sex_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ageSpinnerArray);
        Spinner ageSpinner =(Spinner) findViewById(R.id.age_spinner);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageAdapter);

        ArrayAdapter<String> levelAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, levelSpinnerArray);
        Spinner levelSpinner = (Spinner) findViewById(R.id.level_spinner);
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(levelAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_character, menu);
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

    public void sendInfo (View view){
        Intent intent = new Intent(this, PickStats.class);
        EditText trainerName = (EditText) findViewById(R.id.trainer_name);
        Spinner ageSpinner = (Spinner) findViewById(R.id.age_spinner);
        Spinner genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
        EditText trainerHeight = (EditText) findViewById(R.id.trainer_height);
        EditText trainerWeight = (EditText) findViewById(R.id.trainer_weight);
        Spinner trainerLevel = (Spinner) findViewById(R.id.level_spinner);
        intent.putExtra("trainerName", trainerName.getText().toString());
        intent.putExtra("trainerAge", ageSpinner.getSelectedItem().toString());
        intent.putExtra("trainerGender", genderSpinner.getSelectedItem().toString());
        intent.putExtra("trainerHeight", trainerHeight.getText().toString());
        intent.putExtra("trainerWeight", trainerWeight.getText().toString());
        intent.putExtra("trainerLevel", trainerLevel.getSelectedItem().toString());
        startActivity(intent);
    }


}
