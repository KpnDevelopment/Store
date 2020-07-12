package dataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Cus_Repositry {
    private Cus_Dao cus_dao;
    private LiveData<List<Customer_db>> customer;
    private  LiveData<List<Adding_db>> adding;
    private  LiveData<List<Adding_db>>addfil;
    private List<Customer_db> aupdatefil;
    private List<Customer_db> adeletefil;
    //
    private LiveData<List<Customer_db>> customerfil;
    private LiveData<List<Customer_db>>history;
    private List<Customer_db> updatefil;
    private List<Customer_db> deletefil;
    private List<Customer_db>historyfil;

    Cus_Repositry(Application application) {
        Cdb_database cdb_database = Cdb_database.getdatabase(application);
        cus_dao = cdb_database.cus_dao();
        customer = cus_dao.getAll();
        adding =cus_dao.getadd();

        //
    }

    LiveData<List<Customer_db>> getCustomer() {

        return customer;
    }
    LiveData<List<Adding_db>>getAdding(){
        return adding;
    }

    LiveData<List<Customer_db>> getCustomerfil(String s) {
        return customerfil;
    }
    LiveData<List<Adding_db>>getAddfil(String a){
        return  addfil;
    }

    List<Customer_db> getupdate(String nam, String plac, String tot, String amob, String mob) {
        Cdb_database.dbwrite.execute(() -> {
            cus_dao.updateval(nam,plac,tot,amob,mob);
        });
        return updatefil;
    }
    //
    List<Customer_db> agetupdate(String amoney, String mob){
        Cdb_database.dbwrite.execute(()->{
            cus_dao.uadval(amoney,mob);
        });
        return aupdatefil;
    }

    List<Customer_db> getdelete(String nam, String plac, String tot, String amob, String mob) {
        Cdb_database.dbwrite.execute(() -> {
            cus_dao.deleteval(mob);
        });
        return deletefil;
    }
    //
    List<Customer_db> agetdelete(String date, String amoney, String mob){
        Cdb_database.dbwrite.execute(()->{
            cus_dao.adeleteval(mob);
        });
        return adeletefil;
    }


    LiveData<List<Customer_db>>gethistory(String sh){
        return history;
    }

    void insertdata(final Customer_db customer_db) {
        Cdb_database.dbwrite.execute(() -> {
            cus_dao.insert(customer_db);
        });
    }
    void ainsertdata(final Adding_db adding_db){
        Cdb_database.dbwrite.execute(()->{
            cus_dao.insert(adding_db);
        });
    }

    public void gethistory(String date, String admoney, String mob) {
    }
}
