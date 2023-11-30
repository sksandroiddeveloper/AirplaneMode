package com.example.savideocall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

public class Aaeroplane extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aaeroplane);
        textView = findViewById(R.id.textView);
        checkAirplaneMode();


    }
    private void checkAirplaneMode() {
        if (isAirplaneModeOn(getApplicationContext()))
        {
            textView.setText("Airplane Mode is Enabled");
        } else {
            textView.setText("Airplane Mode is Disabled");
        }
    }
    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}