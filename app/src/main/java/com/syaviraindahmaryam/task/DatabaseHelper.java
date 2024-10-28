package com.syaviraindahmaryam.task;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AgendaDatabase";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_AGENDA = "Agenda";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_DESKRIPSI = "deskripsi";
    public static final String COLUMN_STATUS = "status";

    private static final String CREATE_TABLE_AGENDA = "CREATE TABLE " + TABLE_AGENDA + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAMA + " TEXT, "
            + COLUMN_DESKRIPSI + " TEXT, "
            + COLUMN_STATUS + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_AGENDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AGENDA);
        onCreate(db);
    }
}
