package pl.dzastin.possiblewords.Words;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

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
}
