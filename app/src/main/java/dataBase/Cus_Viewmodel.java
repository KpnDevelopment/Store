package dataBase;

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
    //
    private LiveData<List<Adding_db>>getAdd;
    private  LiveData<List<Adding_db>>getaddfilter;
    private  LiveData<List<Adding_db>>getAddhistory;

    private MutableLiveData<String>mutableLiveData=new MutableLiveData<>();
    private MutableLiveData<String>mutableLiveData1=new MutableLiveData<>();


    public Cus_Viewmodel(@NonNull Application application) {
        super(application);
        repositry = new Cus_Repositry(application);
        getCustomer = repositry.getCustomer();
        getAdd = repositry.getAdding();
        getaddfilter=Transformations.switchMap(mutableLiveData1,a->repositry.getAddfil(a));
        getfilter = Transformations.switchMap(mutableLiveData,c->repositry.getCustomerfil(c)); // c is searching object
    }
    public LiveData<List<Customer_db>>getCustomer(){
        return getCustomer;
    }
    //
    public LiveData<List<Adding_db>>getAdding(){
        return getAdd;
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
    //
    public void insert(Adding_db adding_db){repositry.ainsertdata(adding_db);}
    public void update(String admoney,String mob){repositry.agetupdate(admoney,mob);}
    public void delete(String date,String amoney,String mob){repositry.agetdelete(date,amoney,mob);}
    void apass(String ap){
        mutableLiveData1.setValue(ap);
    }
}