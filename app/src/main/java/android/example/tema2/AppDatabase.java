package android.example.tema2;

import androidx.room.RoomDatabase;

public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();}
