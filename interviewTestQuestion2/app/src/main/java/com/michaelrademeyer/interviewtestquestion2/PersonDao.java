package com.michaelrademeyer.interviewtestquestion2;

import androidx.room.*;

import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM person")
    List<Person> getAll();

    @Insert
    void insertAll(Person... person);

}
