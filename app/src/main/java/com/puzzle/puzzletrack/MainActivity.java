package com.puzzle.puzzletrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DungeonDatabase dungeonDb;
    EditText editName;
    Button submitData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dungeonDb = new DungeonDatabase(this);
        editName = (EditText)findViewById(R.id.editText3);
        submitData = (Button)findViewById(R.id.button);
        DataInsertion();
    }

    public void DataInsertion(){
        submitData.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                       boolean success = dungeonDb.insertData(editName.getText().toString());
                       if(success == true){
                           Toast.makeText(MainActivity.this, "Data insertion successful", Toast.LENGTH_LONG).show();
                       }
                       else{
                           Toast.makeText(MainActivity.this, "Data insertion failed", Toast.LENGTH_LONG).show();
                       }
                    }
                }
        );
    }
}
