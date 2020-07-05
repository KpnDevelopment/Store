package Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Activity.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import Adapter.Activity_Adapter;

public class MainActivity extends AppCompatActivity {
    Menu searchbar;
    FloatingActionButton floatbtn;
    LinearLayout mlinear;
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    Activity_Adapter activity_adapter;
    public MainActivity(){
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view= getLayoutInflater().inflate(R.layout.activity_main,container,false)
        floatbtn=findViewById(R.id.id_floatbtn);
        linearLayout=view.findViewById(R.id.Adapterleaner);
        recyclerView=view.findViewById(R.id.homerecycler);
        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Inserting_Activity.class));
            }
        });

        LinearLayout lmgr = new LinearLayout(getContext());
        RecyclerView.LayoutManager rlmgr=lmgr;
        recyclerView.setLayoutManager(rlmgr);
        activity_adapter=new Activity_Adapter(getContext());
        recyclerView.setAdapter(activity_adapter);
        return view;


    }
}