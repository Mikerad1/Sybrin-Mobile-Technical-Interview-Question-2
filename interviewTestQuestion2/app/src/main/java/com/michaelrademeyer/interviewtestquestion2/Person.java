package com.michaelrademeyer.interviewtestquestion2;

import androidx.room.*;

@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    public int personID;

    @ColumnInfo(name = "firstName")
    public String firstName;

    @ColumnInfo(name = "lastName")
    public String lastName;

    @ColumnInfo(name = "country")
    public String country;

    @ColumnInfo(name = "age")
    public int age;


}
