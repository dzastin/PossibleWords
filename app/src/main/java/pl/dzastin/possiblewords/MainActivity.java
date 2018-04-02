package pl.dzastin.possiblewords;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import pl.dzastin.possiblewords.Words.Word;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findWords(View view) {
        Intent i = new Intent(this, FindWordsActivity.class);
        startActivity(i);
    }

}
