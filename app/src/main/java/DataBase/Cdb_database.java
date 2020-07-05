package DataBase;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Customer_db.class},version = 1,exportSchema = false)
public abstract class Cdb_database extends RoomDatabase {
public abstract Cus_Dao cus_dao();
private static volatile Cdb_database Instance;
private static final int THREADS=4;
static final ExecutorService dbwrite = Executors.newFixedThreadPool(THREADS);
static Cdb_database getdatabase(final Context context)
{
    if (Instance==null){
        synchronized (Cdb_database.class){
            if (Instance==null){
                Instance= Room.databaseBuilder(context.getApplicationContext(), Cdb_database.class,"CustomerDb").build();

            }
        }
    }
    return Instance;

}
}
