package Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.Activity.R;

public class Inserting_Activity extends AppCompatActivity {
    Button subbtn;
    EditText name;
    EditText place;
    EditText mobile;
    EditText amobile;
    EditText total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting);
        subbtn = findViewById(R.id.submit_btn);
        name = findViewById(R.id.name_etxt);
        place = findViewById(R.id.mobile_etxt);
        amobile = findViewById(R.id.amobile_etxt);
        total = findViewById(R.id.total_etxt);
    }
}