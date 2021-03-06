package android.example.tema2;

import android.app.Application;
import android.provider.SyncStateContract;

import androidx.room.Room;

public class ApplicationController extends Application {

    //  If your app runs in a single process, you should follow the singleton design pattern
//  when instantiating an AppDatabase object.
    private static ApplicationController mInstance;

    //  Each RoomDatabase instance is fairly expensive,
//  and you rarely need access to multiple instances within a single process.
    private static AppDatabase mAppDatabase;

    public static ApplicationController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        // Get a database instance to work with
        mAppDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"UserDatabase").build();
    }

    public static AppDatabase getAppDatabase(){
        return mAppDatabase;
    }
}

