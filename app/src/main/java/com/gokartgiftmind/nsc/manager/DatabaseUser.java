package com.gokartgiftmind.nsc.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ASUS-PC on 21/11/2560.
 */

public class DatabaseUser extends SQLiteOpenHelper {

    private static final String DB_NAME = "TaxiFindFriend";
    private static final int DB_VERSION = 1;
    private static final String DB_CREATE = "" + "CREATE TABLE user ("
            + "id INTEGER PRIMARY KEY, "
            + "name TEXT NOT NULL, "
            + "surName TEXT NOT NULL, "
            + "sex TEXT NOT NULL, "
            + "email INTEGER NOT NULL, "
            + "idStudent TEXT NOT NULL, "
            + "mobile INTEGER NOT NULL, "
            + "username INTEGER NOT NULL, "
            + "password TEXT NOT NULL );";

    public DatabaseUser(Context context) {
        super(context, DB_NAME, null , DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        onCreate(sqLiteDatabase);
    }
}
