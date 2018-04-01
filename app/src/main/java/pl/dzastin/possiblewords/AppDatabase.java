package pl.dzastin.possiblewords;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import pl.dzastin.possiblewords.Words.Word;
import pl.dzastin.possiblewords.Words.WordDao;

/**
 * Created by Justyn on 2018-04-01.
 */

@Database(entities = {Word.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WordDao wordDao();
}
