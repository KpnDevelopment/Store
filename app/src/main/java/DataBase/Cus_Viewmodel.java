package DataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

public class Cus_Viewmodel extends AndroidViewModel  {

    private Cus_Repositry repositry;
    private LiveData<List<Customer_db>>getCustomer;
    private LiveData<List<Customer_db>>getfilter;
    private List<Customer_db>getup;
    private MutableLiveData<String>mutableLiveData=new MutableLiveData<>();


    public Cus_Viewmodel(@NonNull Application application) {
        super(application);
        repositry = new Cus_Repositry(application);
        getCustomer = repositry.getCustomer();
        getfilter = Transformations.switchMap(mutableLiveData,c->repositry.getCustomerfil(c)); // c is searching object
    }
    public LiveData<List<Customer_db>>getCustomer(){
        return getCustomer;
    }
    public void insert(Customer_db customer_db){repositry.insertdata(customer_db);}
    public void update(String nam,String plac,String tot,String amob,String mob){repositry.getupdate(nam, plac, tot, amob, mob);}
    public void delete(String nam,String plac,String tot,String amob,String mob){repositry.getdelete(nam, plac, tot, amob, mob);}
    void pass(String st){
        mutableLiveData.setValue(st);
    }
    public LiveData<List<Customer_db>>reCustomer(){
        return getfilter;

    }
}