package pl.dzastin.possiblewords;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import pl.dzastin.possiblewords.Words.Word;

/**
 * Created by Justyn on 2018-04-02.
 */

public class FindWordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_words);
    }

    public void getWords(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Word> words = AppDatabase.getInstance(getApplicationContext()).wordDao().getAllInLength(10);
                Log.i("LOG", "got words");
            }
        }).start();

//        new AsyncTask<>() {
//
//            @Override
//            protected List<Word> doInBackground(Void... params) {
//                return this.appDbHelper.getInstance(getApplicationContext()).wordDao().getAllInLength(10);
//            }
//
//
//        }.execute();

//        new AsyncTask<Void, Void, Integer>() {
//            @Override
//            protected List<Word> doInBackground(Void... params) {
//                return appDbHelper.getInstance(getApplicationContext()).wordDao().getAllInLength(10);
//            }
//
//            @Override
//            protected void onPostExecute(Integer agentsCount) {
//                if (agentsCount > 0) {
//                    //2: If it already exists then prompt user
//                    Toast.makeText(Activity.this, "Agent already exists!", Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Toast.makeText(Activity.this, "Agent does not exist! Hurray :)", Toast.LENGTH_LONG).show();
//                    onBackPressed();
//                }
//            }
//        }.execute();

    }
}
