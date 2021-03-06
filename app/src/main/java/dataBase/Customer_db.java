package dataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Customer_db {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "place")
    private String place;

    @ColumnInfo(name = "mobile")
    private String mobile;

    @ColumnInfo(name = "amobile")
    private String amobile;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "total")
    private String total;

        public Customer_db(String name,String place,String mobile,String amobile,String total){

        this.name = name;
        this.place = place;
        this.mobile = mobile;
        this.amobile = amobile;
        this.date = date;
        this.total = total;
    }
    //getter & setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAmobile() {
        return amobile;
    }

    public void setAmobile(String amobile) {
        this.amobile = amobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
@Entity
class Adding_db{
    @PrimaryKey(autoGenerate =  true)
    private int ida;

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    @ColumnInfo(name = "mobile")
    private  String mobile;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "admoney")
    private String admoney;

    public Adding_db(String mobile,String date,String admoney){
        this.mobile=mobile;
        this.date=date;
        this.admoney=admoney;

    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdmoney() {
        return admoney;
    }

    public void setAdmoney(String admoney) {
        this.admoney = admoney;
    }
}
