package com.example.gamis214.datepicker_example;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by ArielSV on 12/05/17.
 */

 public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public interface OnDateSelected{
        public void onNewDataSelected(String data);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current date as the default date in the date picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


         DatePickerDialog dpd = new DatePickerDialog(getActivity(),AlertDialog.THEME_HOLO_LIGHT,this,year, month, day){


            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setStyle(STYLE_NO_TITLE, 0);
                int day = getContext().getResources().getIdentifier("android:id/day", null, null);
                if(day != 0){
                    View dayPicker = findViewById(day);
                    if(dayPicker != null){
                        dayPicker.setVisibility(View.GONE);
                    }
                }
            }
        };
        DatePicker dp = dpd.getDatePicker();
        dp.setMinDate(c.getTimeInMillis());
        c.add(Calendar.YEAR,20);
        dp.setMaxDate(c.getTimeInMillis());
        return dpd;

    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        String mes="";
        //TextView tv = (TextView) getActivity().findViewById(R.id.tv);
        if(month >= 10){
            mes = ""+String.valueOf(month);
        }else {
            mes = "0"+String.valueOf(month);
        }
        year = year%100;
        //tv.setText(mes+"/"+year);
        try{
            ((OnDateSelected) getActivity()).onNewDataSelected(""+mes+"/"+year+"");
        }catch (ClassCastException cce){

        }
    }


}
