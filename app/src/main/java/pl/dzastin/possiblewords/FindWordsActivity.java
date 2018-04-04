package pl.dzastin.possiblewords;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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

    public void getWords(final View view) {
        final TextView results = findViewById(R.id.results);
        results.setText(" ");
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                EditText wordsLengthInput = findViewById(R.id.wordsLength);
                Integer wordsLength = Integer.parseInt(wordsLengthInput.getText().toString(), 10);
                final List<Word> words = AppDatabase.getInstance(getApplicationContext()).wordDao().getAllInLength(wordsLength);

                if(words.size() > 0) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String resultsString = "";
                            for(Word word : words) {
                                resultsString += resultsString.concat(word.getName().concat("\n"));
                            }
                            results.setText(resultsString);
                        }
                    });

                }
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
