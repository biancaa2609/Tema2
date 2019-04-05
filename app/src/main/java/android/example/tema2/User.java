package android.example.tema2;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class User {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;
}

