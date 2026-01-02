package com.example.luxevistaresort;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class BookAppointmentActivity extends AppCompatActivity {

    Spinner serviceSpinner, roomTypeSpinner, cabanaTypeSpinner, spaTypeSpinner, tourTypeSpinner;
    LinearLayout diningOptions, roomOptions, cabanaOptions, spaOptions, tour;
    EditText dateField, timeField;
    Button bookNowBtn;

    DBhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookappointment);

        // Initialize DB
        dbhelper = new DBhelper(this);

        serviceSpinner = findViewById(R.id.serviceSpinner);
        diningOptions = findViewById(R.id.diningOptions);
        roomOptions = findViewById(R.id.roomOptions);
        cabanaOptions = findViewById(R.id.cabanaOptions);
        spaOptions = findViewById(R.id.spaOptions);
        tour = findViewById(R.id.tour);

        roomTypeSpinner = findViewById(R.id.roomTypeSpinner);
        cabanaTypeSpinner = findViewById(R.id.cabanaTypeSpinner);
        spaTypeSpinner = findViewById(R.id.spaTypeSpinner);
        tourTypeSpinner = findViewById(R.id.tourTypeSpinner);
        dateField = findViewById(R.id.dateField);
        timeField = findViewById(R.id.timeField);
        bookNowBtn = findViewById(R.id.sumitBtn);

        String[] services = {"Select", "Dining", "Rooms", "Cabanas", "Spa", "Beach Tour"};
        ArrayAdapter<String> serviceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, services);
        serviceSpinner.setAdapter(serviceAdapter);

        String[] diningTypes = {"Fine Dining", "Buffet Dining", "Beach Side Grill", "Cafe And Snack"};
        String[] roomTypes = {"Deluxe Room", "Ocean View Suite"};
        String[] cabanaTypes = {"Garden View Cabana", "Beachfront Cabana"};
        String[] spaTypes = {"Aroma Therapy Spa", "Hot Stone Therapy", "Ayurvedic Rejuvenation", "Ocean Detox"};
        String[] tourTypes = {"Beach Tour"};

        roomTypeSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, roomTypes));
        cabanaTypeSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cabanaTypes));
        spaTypeSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spaTypes));
        tourTypeSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tourTypes));

        serviceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                diningOptions.setVisibility(View.GONE);
                roomOptions.setVisibility(View.GONE);
                cabanaOptions.setVisibility(View.GONE);
                spaOptions.setVisibility(View.GONE);
                tour.setVisibility(View.GONE);

                switch (services[position]) {
                    case "Dining":
                        diningOptions.setVisibility(View.VISIBLE);
                        break;
                    case "Rooms":
                        roomOptions.setVisibility(View.VISIBLE);
                        break;
                    case "Cabanas":
                        cabanaOptions.setVisibility(View.VISIBLE);
                        break;
                    case "Spa":
                        spaOptions.setVisibility(View.VISIBLE);
                        break;
                    case "Beach Tour":
                        tour.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        dateField.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(BookAppointmentActivity.this,
                    (view, year1, month1, dayOfMonth) -> {
                        String selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%04d", dayOfMonth, month1 + 1, year1);
                        dateField.setText(selectedDate);
                    }, year, month, day);
            datePickerDialog.show();
        });

        timeField.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(BookAppointmentActivity.this,
                    (view, hourOfDay, minute1) -> {
                        String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute1);
                        timeField.setText(selectedTime);
                    }, hour, minute, true);
            timePickerDialog.show();
        });

        bookNowBtn.setOnClickListener(v -> {
            String service = serviceSpinner.getSelectedItem().toString();
            String option = "";

            switch (service) {
                case "Dining":
                    option = diningTypes[0];
                    break;
                case "Rooms":
                    option = roomTypeSpinner.getSelectedItem().toString();
                    break;
                case "Cabanas":
                    option = cabanaTypeSpinner.getSelectedItem().toString();
                    break;
                case "Spa":
                    option = spaTypeSpinner.getSelectedItem().toString();
                    break;
                case "Beach Tour":
                    option = tourTypeSpinner.getSelectedItem().toString();
                    break;
            }

            String date = dateField.getText().toString();
            String time = timeField.getText().toString();

            if (service.equals("Select") || date.isEmpty() || time.isEmpty()) {
                Toast.makeText(BookAppointmentActivity.this, "Please complete all fields.", Toast.LENGTH_SHORT).show();
                return;
            }


            String name = "Guest";

            boolean isInserted = dbhelper.insertBooking(name, service, option, date, time);
            if (isInserted) {
                Toast.makeText(BookAppointmentActivity.this, "Booking Successful!", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(BookAppointmentActivity.this, "Booking Failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
