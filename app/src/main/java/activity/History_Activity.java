package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.Activity.R;

import java.util.ArrayList;
import java.util.List;

import adapter.History_Adapter;
import dataBase.Cus_Viewmodel;
import dataBase.Customer_db;

public class History_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    Cus_Viewmodel cus_viewmodel;
    History_Adapter adapter;
    ArrayList<Customer_db>customer_dbs=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView=findViewById(R.id.homerecycler);
        cus_viewmodel=new ViewModelProvider(this).get(Cus_Viewmodel.class);

        LinearLayoutManager lmgr = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager recyler=lmgr;
        recyclerView.setLayoutManager(recyler);
        adapter=new History_Adapter(this,customer_dbs);
        recyclerView.setAdapter(adapter);

        cus_viewmodel=new ViewModelProvider(this).get(Cus_Viewmodel.class);
        cus_viewmodel.getCustomer().observe(this, new Observer<List<Customer_db>>() {
            @Override
            public void onChanged(List<Customer_db> customer_dbs) {
                adapter.setdata(customer_dbs);
            }
        });


    }
}