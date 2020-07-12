package activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Activity.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import adapter.Activity_Adapter;
//import DataBase.Adding_db;
import dataBase.Cus_Viewmodel;
import dataBase.Customer_db;

public class MainActivity extends AppCompatActivity implements Activity_Adapter.StartActivity {
    Toolbar toolbar;
    FloatingActionButton floatbtn;
    LinearLayout mlinear;
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    Cus_Viewmodel viewmodel;
    String sname;
    String splace,stotal,samobile,smobile;
    Activity_Adapter adapter;
    ArrayList<Customer_db>customer_dbs=new ArrayList<>();



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
        LinearLayoutManager Lmgr=new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager recylmgr=Lmgr;
        recyclerView.setLayoutManager(recylmgr);
        adapter= new Activity_Adapter(getApplicationContext(),customer_dbs,this);
        recyclerView.setAdapter(adapter);

        viewmodel=new ViewModelProvider(this).get(Cus_Viewmodel.class);
        viewmodel.getCustomer().observe(this, new Observer<List<Customer_db>>() {
            @Override
            public void onChanged(List<Customer_db> customer_dbs) {
                adapter.setdata(customer_dbs);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.acbar_menu,menu);
        MenuItem searchViewItem=menu.findItem(R.id.app_bar_search);
        SearchView searchView=(SearchView) searchViewItem.getActionView();
        searchView.setQueryHint("Search");
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


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void clickstart(String optionMenu) {
        if (optionMenu.equals("Add ₹")){
            dialogadd();
        }
        else if (optionMenu.equals("Update")){
            startActivity(new Intent(MainActivity.this,Update_Activity.class));
        }
        else if (optionMenu.equals("History")){
            startActivity(new Intent(MainActivity.this,History_Activity.class));
        }
    }
    public void savetask(){

    }
    void datepic(){

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);
    }
    public void dialogadd(){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_add_money_);
        dialog.setTitle("Add Money");
        EditText admoney;
        admoney=dialog.findViewById(R.id.eaddmoney);
        Button adok = (Button)dialog.findViewById(R.id.adok);
        Button adcan = (Button)dialog.findViewById(R.id.adcancel);
        dialog.show();
        adok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(admoney.getText().toString().trim())
                ) {
                    admoney.setError("Field can't empty");
                }
                else {
//                    final String amoney=admoney.getText().toString().trim();
//                    Adding_db adding_db=new Adding_db((mobile,date,admoney));
//                    viewmodel.insert(adding_db);

                    Customer_db customer_db=new Customer_db(sname,splace,stotal,samobile,smobile);
                    viewmodel.insert(customer_db);
                }

                Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        adcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_LONG).show();
                dialog.cancel();

            }
        });
    }
//    @Override
//    public void clicked(String mob) {
//
//    }
}