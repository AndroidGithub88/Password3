package com.murach.scccismobiledesignclassportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ClassScheduale extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_scheduale);

        // Get Intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Capture the layouts TextView ms set the string as Text
        TextView textView = (TextView) findViewById(R.id.textView);

        message = "Welcome Sacramento City Class Schedule " + message;
        textView.setText(message);

        // get a reference to the spinner
        Spinner splitSpinner = (Spinner) findViewById(R.id.spinner);
        // create array adapter for specified array and layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.split_array, android.R.layout.simple_spinner_item);
        // set the layout for the drop-down l ist
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        // set the adapter for the spinner
        splitSpinner.setAdapter(adapter);
        //https://www.youtube.com/watch?v=lrWBLgkiThw
    }
}