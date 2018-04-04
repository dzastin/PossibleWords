package pl.dzastin.possiblewords.Words;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import java.util.List;


/**
 * Created by Justyn on 2018-04-01.
 */

@Dao
public interface WordDao {

    @Query("select * from word where length = :length limit 10")
    List<Word> getAllInLength(int length);

    @Insert
    void insertAll(List<Word> words);

//    @Query("select * from word where ")
//    List<Word> getAllWithLetters(Character[] letters);
//
//    List<Word> getAllWithLetters(Character[] letters, int length);
}
