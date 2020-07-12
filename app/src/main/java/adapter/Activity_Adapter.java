package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Activity.R;

import java.util.ArrayList;
import java.util.List;

import dataBase.Customer_db;

public class Activity_Adapter extends RecyclerView.Adapter<Activity_Adapter.Holder> implements Filterable{
    LayoutInflater inflater;
    Context context;
    private static StartActivity clickerlistener;
    List<Customer_db> customer_dbs;
    List<Customer_db>customerModelList;



    public Activity_Adapter(Context context,List<Customer_db>customer_dbs,StartActivity listener){
        this.context=context;
        this.customer_dbs=customer_dbs;
        this.customerModelList=customer_dbs;
        clickerlistener=listener;

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                 String charstring=charSequence.toString().toLowerCase();
                 if (charstring.isEmpty()){
                     customer_dbs=customerModelList;
                 }
                 else{
                     List<Customer_db>filteredList=new ArrayList<>();
                     for (Customer_db row:customerModelList)
                     {
                         if (row.getName().toLowerCase().contains(charstring.toLowerCase()) || row.getTotal().toLowerCase().contains(charstring.toLowerCase())
                         || row.getMobile().toLowerCase().contains(charstring.toLowerCase())){

                         }
                     }
                     customer_dbs=filteredList;
                 }
                 FilterResults filterResults=new FilterResults();
                 filterResults.values=customer_dbs;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                customer_dbs=(ArrayList<Customer_db>)results.values;
                notifyDataSetChanged();

            }
        };
    }

    @NonNull
    @Override
    public Activity_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(context);
        View view=inflater. inflate(R.layout.activity_adapter,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Activity_Adapter.Holder holder, int position) {
        if (customer_dbs!=null){
            Customer_db customer_db=customer_dbs.get(position);
            holder.name.setText(customer_db.getName());
            holder.total.setText(customer_db.getTotal());
            holder.mobile.setText(customer_db.getMobile());
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
    public void setdata(List<Customer_db>customer_db){
        customer_dbs=customer_db;
        customerModelList=customer_db;
        notifyDataSetChanged();
    }

//    @Override
//    public void onClick(View v) {
//        PopupMenu popupMenu;
//        popupMenu = new PopupMenu(.this,longbtn);
//        popupMenu.getMenuInflater().inflate(R.menu.acbar_menu,popupMenu.getMenu());
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Intent intent;
//                switch (){
//                    case 0:
//                        intent =  new Intent(context, Update_Activity.class);
//                        break;
//
//                    case 1:
//                        intent =  new Intent(context, History_Activity.class);
//                        break;
//                    case 2:
//
//                        intent =  new Intent(context, AddMoney_Activity.class);
//                        break;
//                };
//            }
//        });
//
//    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView name,total,mobile;
        public Holder(@NonNull View itemView) {
            super(itemView);
            LinearLayout longbtn;

            name=itemView.findViewById(R.id.adname_txt);
            total=itemView.findViewById(R.id.adtotal_txt);
            mobile=itemView.findViewById(R.id.admob_txt);
            itemView.setClickable(true);
            longbtn=itemView.findViewById(R.id.userlog);
            longbtn.setOnLongClickListener(v -> {
                PopupMenu popupMenu = new PopupMenu(context,longbtn);
                popupMenu.getMenuInflater().inflate(R.menu.long_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        clickerlistener.clickstart(item.getTitle().toString());
                        return false;
                    }
                });
                popupMenu.show();
                return true;
            });

        }

    }
    public interface StartActivity  {
        void clickstart(String optionMenu);
    }
}
