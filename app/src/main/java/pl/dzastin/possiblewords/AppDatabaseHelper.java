package pl.dzastin.possiblewords;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by Justyn on 2018-04-01.
 */

public class AppDatabaseHelper {
    private AppDatabase instance = null;

    public AppDatabase getInstance(Context context) {
      if(this.instance == null) {
          this.instance = Room.databaseBuilder(context, AppDatabase.class, "word").build();
      }

      return this.instance;
    }

}
