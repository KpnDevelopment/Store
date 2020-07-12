package dataBase;

import android.content.Context;

import androidx.room.Room;


public class Database_Client {
    private Context clcontext;
    private static Database_Client clInstance;

    //app database object

    private Cdb_database cdb_database;

    public Database_Client(Context clcontext){
        this.clcontext= clcontext;
        cdb_database= Room.databaseBuilder(clcontext,Cdb_database.class,"Customer").build();
    }

    public static synchronized Database_Client getInstance(Context context){
        if(clInstance==null){
            clInstance=new Database_Client(context);
        }
        return clInstance;
    }
    public Cdb_database getCdb_database(){
        return cdb_database;
    }
}
