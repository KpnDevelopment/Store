package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.Activity.R;

public class Update_Activity extends AppCompatActivity {
    EditText  uname_etxt;
    EditText uplace_etxt;
    EditText uamobile_txt;
    Button upbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        uname_etxt = findViewById(R.id.upname_etxt);
        uplace_etxt = findViewById(R.id.uppalce_etxt);
        uamobile_txt = findViewById(R.id.upaMobile_etxt);
        upbtn = findViewById(R.id.update_btn);

    }
}