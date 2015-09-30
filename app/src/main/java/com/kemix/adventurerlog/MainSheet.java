package com.kemix.adventurerlog;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MainSheet extends AppCompatActivity {

    public Trainer trainer1 = new Trainer();
    DataHandler handler;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sheet);

        handler = new DataHandler(getBaseContext());
        handler.open();
        Cursor c = handler.returnData();
        c.moveToFirst();
        num = c.getCount();


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int age = Integer.parseInt(intent.getStringExtra("age"));
        String gender = intent.getStringExtra("gender");
        String height = intent.getStringExtra("height");
        int weight = Integer.parseInt(intent.getStringExtra("weight"));
        int level = Integer.parseInt(intent.getStringExtra("level"));
        String startingClass = intent.getStringExtra("characterClass");

        int strVal = Integer.parseInt(intent.getStringExtra("str"));
        int dexVal = Integer.parseInt(intent.getStringExtra("dex"));
        int conVal = Integer.parseInt(intent.getStringExtra("con"));
        int intVal = Integer.parseInt(intent.getStringExtra("int"));
        int wisVal = Integer.parseInt(intent.getStringExtra("wis"));
        int chaVal = Integer.parseInt(intent.getStringExtra("cha"));

        trainer1.load(name, age, gender, height, weight, level, strVal, dexVal, conVal, intVal, wisVal, chaVal);


        TextView nameView = (TextView)findViewById(R.id.characterName);
        nameView.setText(trainer1.getName());

        TextView strView = (TextView)findViewById(R.id.characterStr);
        strView.setText(trainer1.getStr());

        TextView dexView = (TextView)findViewById(R.id.characterDex);
        dexView.setText(trainer1.getDex());

        TextView conView = (TextView)findViewById(R.id.characterCon);
        conView.setText(trainer1.getCon());

        TextView intView = (TextView)findViewById(R.id.characterInt);
        intView.setText(trainer1.getInt());

        TextView wisView = (TextView)findViewById(R.id.characterWis);
        wisView.setText(trainer1.getWis());

        TextView chaView = (TextView)findViewById(R.id.characterCha);
        chaView.setText(trainer1.getCha());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_sheet, menu);
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
        if (id == R.id.action_load) {
            //Go to List of Saved Character Sheets
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToClassMenu (View view){
        Intent intent = new Intent(this, TrainerClassMenu.class);
    }

    public void saveSheet(){
        String filename = trainer1.getName() + "sheet";
        filename.replaceAll("\\s", "");


        FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(trainer1);
        os.close();
        fos.close();
    }
}
