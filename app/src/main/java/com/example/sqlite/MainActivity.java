package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqlite.helper.MyHelper;

public class MainActivity extends AppCompatActivity {
    EditText etWord, etMeaning;
    Button btnAddWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnAddWord = findViewById(R.id.btnAddWord);

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
    }

    public boolean InsertData(String word, String meaning, SQLiteDatabase db){
        try {
            String query = "insert into Words(Word, Meaning) values('" + word +"','"+ meaning +"') ";
            db.execSQL(query);
            return true;
        }
        catch (Exception e){
            Log.d("Error : ", e.toString());
            return false;
        }
    }
}
