package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.Activity.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import adapter.Activity_Adapter;
import dataBase.Cus_Viewmodel;
import dataBase.Customer_db;

public class Inserting_Activity extends AppCompatActivity {
    Button subbtn;
    EditText name;
    EditText place;
    EditText mobile;
    EditText amobile;
    EditText total;
    String admoney;
    RecyclerView recyclerView;
    Activity_Adapter activity_adapter;
    Cus_Viewmodel cus_viewmodel;
    ArrayList<Customer_db>customer_dbs=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting);
        subbtn = findViewById(R.id.submit_btn);
        name = findViewById(R.id.name_etxt);
        place = findViewById(R.id.palce_etxt);
        amobile = findViewById(R.id.amobile_etxt);
        mobile = findViewById(R.id.mobile_etxt);
        total = findViewById(R.id.total_etxt);
        cus_viewmodel = new ViewModelProvider(this).get(Cus_Viewmodel.class);
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savetask();
                clear();
                datepic();
            }
        });


    }

    public void savetask(){
        if (TextUtils.isEmpty(name.getText().toString().trim()) || TextUtils.isEmpty(place.getText().toString().trim()) || TextUtils.isEmpty(total.getText().toString().trim())
                || TextUtils.isEmpty(amobile.getText().toString().trim()) || TextUtils.isEmpty(mobile.getText().toString().trim()) ||
                TextUtils.isEmpty(mobile.getText().toString().trim())
        ) {
            name.setError("Field can't empty");
            place.setError("Field can't empty");
            total.setError("Field can't empty");
            amobile.setError("Field can't empty");
            mobile.setError("Field can't empty");

        }
        else {
            final String sname=name.getText().toString().trim();
            final String splace=place.getText().toString().trim();
            final String smobile=mobile.getText().toString().trim();
            final String samobile=amobile.getText().toString().trim();
            final String stotal=total.getText().toString().trim();





            Customer_db customer_db=new Customer_db(sname,splace,smobile,samobile,stotal);
            cus_viewmodel.insert(customer_db);
        }
    }
    public void clear(){
        name.setText(null);
        place.setText(null);
        mobile.setText(null);
        amobile.setText(null);
        total.setText(null);

    }
    void datepic(){

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);
    }
}
