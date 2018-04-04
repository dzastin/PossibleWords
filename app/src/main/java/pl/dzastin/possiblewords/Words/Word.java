package pl.dzastin.possiblewords.Words;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justyn on 2018-04-01.
 */

@Entity
public class Word {

    @PrimaryKey
    @NonNull
    protected String name;

    protected int length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static List<Word> populateData(Context context) {
        List<Word> words = new ArrayList<Word>();

        try {
            BufferedReader reader;
            Resources resources = context.getResources();

            InputStream file = resources.openRawResource(
                    resources.getIdentifier("words",
                            "raw", context.getPackageName()));
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){
                Log.d("word", line);
                Word newWord = new Word();
                newWord.setName(line);
                newWord.setLength(line.length());
                words.add(newWord);
                line = reader.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }


        return words;
    }
}
