package DataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Cus_Repositry {
    private Cus_Dao cus_dao;
    private LiveData<List<Customer_db>> customer;
    private LiveData<List<Customer_db>> customerfil;
    private List<Customer_db> updatefil;
    private List<Customer_db> deletefil;

    Cus_Repositry(Application application) {
        Cdb_database cdb_database = Cdb_database.getdatabase(application);
        cus_dao = cdb_database.cus_dao();
        customer = cus_dao.getAll();
    }

    LiveData<List<Customer_db>> getCustomer() {
        return customer;
    }

    LiveData<List<Customer_db>> getCustomerfil(String s) {
        return customerfil;
    }

    List<Customer_db> getupdate(String nam, String plac, String tot, String amob, String mob) {
        Cdb_database.dbwrite.execute(() -> {
            cus_dao.updateval(nam,plac,tot,amob,mob);
        });
        return updatefil;
    }

    List<Customer_db> getdelete(String nam, String plac, String tot, String amob, String mob) {
        Cdb_database.dbwrite.execute(() -> {
            cus_dao.deleteval(mob);
        });
        return deletefil;
    }

    void insertdata(final Customer_db customer_db) {
        Cdb_database.dbwrite.execute(() -> {
            cus_dao.insert(customer_db);
        });
    }
}
