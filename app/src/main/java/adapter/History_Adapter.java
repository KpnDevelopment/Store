package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Activity.R;

import java.util.List;

import dataBase.Customer_db;

public class History_Adapter extends RecyclerView.Adapter<History_Adapter.Holder> implements Filterable {
    LayoutInflater inflater;
    Context context;
    List<Customer_db>customer_dbs;
    List<Customer_db>cusViewmodlist;
    public History_Adapter(Context context,List<Customer_db>customer_dbs){
        this.context=context;
        this.customer_dbs=customer_dbs;
        this.cusViewmodlist=customer_dbs;
    }
    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public History_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.history__adapter,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull History_Adapter.Holder holder, int position) {
        if (customer_dbs!=null){
            Customer_db customer_db=customer_dbs.get(position);
            holder.date.setText(customer_db.getDate());
//            holder.admoney.setText(customer_db.getAdmoney());
        }

    }

    @Override
    public int getItemCount() {
        if (customer_dbs!=null){
            return customer_dbs.size();
        }
        else {
            return 0;
        }

    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView admoney,date;
        public Holder(@NonNull View itemView) {
            super(itemView);
            admoney=itemView.findViewById(R.id.date_txt);
            date=itemView.findViewById(R.id.amount_txt);
        }
    }
    public void setdata(List<Customer_db>customer_db){
        customer_dbs=customer_db;
        cusViewmodlist=customer_db;
        notifyDataSetChanged();
    }
}