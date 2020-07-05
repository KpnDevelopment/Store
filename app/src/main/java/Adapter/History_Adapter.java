package Adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.Activity.R;

public class History_Adapter extends AppCompatActivity {
    TextView date;
    TextView time;
    TextView amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history__adapter);
        date = findViewById(R.id.date_txt);
        time = findViewById(R.id.time_txt);
        amount = findViewById(R.id.amount_txt);
    }
}