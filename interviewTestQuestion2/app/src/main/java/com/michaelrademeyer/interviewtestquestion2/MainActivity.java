package com.michaelrademeyer.interviewtestquestion2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    public static final String EXTRA_MESSAGE = "com.michaelrademeyer.interviewtestquestion2.DB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "quesetion2").build();
    }
    public void CaptureData(View view){
        Person person = new Person();
        final EditText ageText = (EditText)findViewById(R.id.textAge);
        person.age = Integer.parseInt(ageText.getText().toString());

        final EditText firstNameText = (EditText)findViewById(R.id.textFirstName);
        person.firstName = firstNameText.getText().toString();

        final EditText lastNameText = (EditText)findViewById(R.id.textLastName);
        person.lastName = lastNameText.getText().toString();

        final EditText countryText = (EditText)findViewById(R.id.textCountry);
        person.country = countryText.getText().toString();

        new PersonAsyncTask(this, person, db).execute();

        ageText.setText("");
        firstNameText.setText("");
        lastNameText.setText("");
        countryText.setText("");

        alertDialog();

    }

    public void ViewAllData(View view){
        Intent intent = new Intent(this, ViewAllData.class);
        //intent.putExtra(EXTRA_MESSAGE, (Serializable) db);
        startActivity(intent);
    }

    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Data has been captured");
        dialog.setTitle("Data Capture");
        dialog.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {

                    }
                });

        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}