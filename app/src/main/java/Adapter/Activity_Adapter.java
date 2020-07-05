package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Activity.R;

import java.util.List;

import Model_Class.Activity_Model;

public class Activity_Adapter extends RecyclerView.Adapter<Activity_Adapter.Holder> {
    Context context;
    List<Activity_Model> list;
    public Activity_Adapter(Context context,List<Activity_Model>list){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext().inflate(R.layout.activity_adapter,parent,false));
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final Activity_Model amodel=list.get(position);
        holder.name.setText(amodel.getname());
        holder.total.setText(amodel.getTotal());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class Holder extends RecyclerView.ViewHolder {
        TextView name,total;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.adname_txt);
            total=itemView.findViewById(R.id.adtotal_txt);
        }
    }
}


