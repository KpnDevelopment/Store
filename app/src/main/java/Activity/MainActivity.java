package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Activity.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Adapter.Activity_Adapter;
import DataBase.Cus_Viewmodel;
import DataBase.Customer_db;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatbtn;
    LinearLayout mlinear;
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    Cus_Viewmodel viewmodel;
    Activity_Adapter adapter;
    ArrayList<Customer_db>customer_dbs=new ArrayList<>();
    public MainActivity(){
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.homerecycler);
        floatbtn=findViewById(R.id.id_floatbtn);
        viewmodel = new ViewModelProvider(this).get(Cus_Viewmodel.class);
        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Inserting_Activity.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.acbar_menu,menu);
        MenuItem searchViewItem=menu.findItem(R.id.app_bar_search);
        final SearchView searchView=(SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        LinearLayoutManager lmgr=new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager recylmgr=lmgr;
        recyclerView.setLayoutManager(recylmgr);
        adapter=new Activity_Adapter(this,customer_dbs);
        recyclerView.setAdapter(adapter);

        viewmodel=new ViewModelProvider(this).get(Cus_Viewmodel.class);
        viewmodel.getCustomer().observe(this, new Observer<List<Customer_db>>() {
            @Override
            public void onChanged(List<Customer_db> customer_dbs) {
                adapter.setdata(customer_dbs);
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}