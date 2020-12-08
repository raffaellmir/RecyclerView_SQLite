package com.edu.recyclerviewdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    RecyclerView recyclerView;
    DatabaseAdapter databaseAdapter;
    WordsAdapter wordsAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Word> wordsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreContentDB.copyDB(this);
        databaseHelper = new DatabaseHelper(this);


    }
}