package com.example.victor.alertdialog;

import android.widget.TimePicker;

        import android.app.DatePickerDialog;
        import android.app.TimePickerDialog;
        import android.content.DialogInterface;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.TextView;
        import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    Button bt_data, bt_hora, bt_color;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    TextView   tw_data, tw_hora, tw_color;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_color = findViewById(R.id.bt_color);
        bt_hora = findViewById(R.id.bt_hora);
        bt_data = findViewById(R.id.bt_data);

        tw_data = findViewById(R.id.tw_data);
        tw_hora = findViewById(R.id.tw_hora);
        tw_color = findViewById(R.id.tw_color);


        datePickerDialog  = new DatePickerDialog(this);
        timePickerDialog  = new TimePickerDialog(this, this, 10, 30, true);



        bt_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.updateDate(2018, 0, 6);
                datePickerDialog.show();

                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date;
                        date = year+"/";

                        if(String.valueOf(month).length() != 2){
                            date = date+0+(month+1)+"/";
                        }else{
                            date = date+(month+1)+"/";
                        }

                        if(String.valueOf(dayOfMonth).length() != 2){
                            date = date+0+dayOfMonth;
                        }else{
                            date = date+dayOfMonth;
                        }
                        tw_data.setText(date);
                    }
                });

            }
        });

        bt_hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        bt_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arrayColors = {
                        "Rojo",
                        "Verde",
                        "Amarillo",
                };
                AlertDialog.Builder colorsDialog = new AlertDialog.Builder(MainActivity.this);
                colorsDialog.create();
                colorsDialog.setTitle("Escoge un Color").setItems(arrayColors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selected = arrayColors[which];
                        tw_color.setText(selected);
                    }
                });
                colorsDialog.show();
            }
        });

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String hour = "";
        Toast.makeText(getApplicationContext(),String.valueOf(hourOfDay),Toast.LENGTH_LONG).show();
        if(String.valueOf(hourOfDay).length() != 2){
            hour = "0"+hourOfDay+":";
        }else{
            hour = hourOfDay+":";
        }

        if(String.valueOf(minute).length() != 2){
            hour = hour+0+minute;
        }else{
            hour = hour+minute;
        }

        tw_hora.setText(hour);
    }
}