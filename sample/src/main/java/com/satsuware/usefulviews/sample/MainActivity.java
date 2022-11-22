package com.satsuware.usefulviews.sample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.satsuware.usefulviews.LabelledSpinner;

public class MainActivity extends AppCompatActivity implements LabelledSpinner.OnItemChosenListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LabelledSpinner labelledSpinner = (LabelledSpinner) findViewById(R.id.spinner_planets);
        labelledSpinner.setItemsArray(R.array.planets_array);
        labelledSpinner.setDefaultErrorEnabled(true);
        labelledSpinner.setDefaultErrorText("This is a compulsory field.");  // Displayed when first item remains selected
        labelledSpinner.setOnItemChosenListener(this);
    }

    @Override
    public void onItemChosen(View labelledSpinner, AdapterView<?> adapterView, View itemView, int position, long id) {
        String selectedText = adapterView.getItemAtPosition(position).toString();
        switch (labelledSpinner.getId()) {
            case R.id.spinner_planets:
                Toast.makeText(MainActivity.this, "Selected: " + selectedText, Toast.LENGTH_SHORT).show();
                break;
            // If you have multiple LabelledSpinners, you can add more cases here
        }
    }

    @Override
    public void onNothingChosen(View labelledSpinner, AdapterView<?> adapterView) {
        // Do something here
    }
}
