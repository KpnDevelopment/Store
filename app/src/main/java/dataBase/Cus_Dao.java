package dataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao

public interface Cus_Dao {
    @Query("SELECT * FROM Customer_db")
    LiveData<List<Customer_db>>getAll();

    @Query("SELECT * FROM Customer_db WHERE  name=:string OR place=:string OR total=:string OR amobile=:string OR mobile=:string")
    LiveData<List<Customer_db>>getfilter(String string);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Customer_db customer_db);
    @Delete
    void delete(Customer_db customer_db);

    @Update
    void update(Customer_db customer_db);

    @Query("SELECT * FROM Customer_db WHERE mobile=:st")
    List<Customer_db>getupdate(String st);

//    @Query("SELECT date,admoney FROM Customer_db WHERE mobile=mob")
//    List<Customer_db>gethistory(String mob);

    @Query("UPDATE Customer_db SET name=:nam,place=:plac,total=:tot,amobile=:amob WHERE mobile=:mob")
    void updateval(String nam,String plac,String tot,String amob,String mob);

    @Query("DELETE FROM Customer_db WHERE mobile=:mob")
    void deleteval(String mob);

    // Adding_db

    @Query("SELECT * FROM Adding_db")
    LiveData<List<Adding_db>>getadd();

    @Query("SELECT * FROM Adding_db WHERE mobile=:string OR date=:string OR admoney=:string")
    LiveData<List<Adding_db>>adfilter(String string);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Adding_db adding_db);

    @Delete
    void delete(Adding_db adding_db);
    @Update
    void update(Adding_db adding_db);

    @Query("SELECT * FROM Adding_db WHERE mobile=:mt")
    List<Adding_db>adupdate(String mt);

    @Query("UPDATE Adding_db SET admoney=:amoney WHERE mobile=:mob")
    void uadval(String amoney,String mob);

    @Query("DELETE FROM Adding_db WHERE mobile=:mobi")
    void adeleteval(String mobi);




}
