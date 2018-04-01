package pl.dzastin.possiblewords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import pl.dzastin.possiblewords.Words.Word;

public class MainActivity extends AppCompatActivity {

    public AppDatabaseHelper appDbHelper = new AppDatabaseHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getWords() {
        List<Word> words = this.appDbHelper.getInstance(getApplicationContext()).wordDao().getAllInLength(10);
    }
}
