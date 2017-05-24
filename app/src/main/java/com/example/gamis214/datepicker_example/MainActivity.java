package com.example.gamis214.datepicker_example;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener, DatePickerFragment.OnDateSelected{

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.btn)  ;
        tv = (TextView) findViewById(R.id.tv);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(),"Date Picker");
    }

    @Override
    public void onNewDataSelected(String data) {
        tv.setText(data);
    }
}


