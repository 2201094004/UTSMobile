package com.syaviraindahmaryam.task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class AgendaRepository {
    private static AgendaRepository instance;
    private final SQLiteDatabase db;

    private AgendaRepository(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public static synchronized AgendaRepository getInstance(Context context) {
        if (instance == null) {
            instance = new AgendaRepository(context);
        }
        return instance;
    }

    public static void addAgenda(Agenda newAgenda) {
    }

    public long insertAgenda(String nama, String deskripsi, String status) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAMA, nama);
        values.put(DatabaseHelper.COLUMN_DESKRIPSI, deskripsi);
        values.put(DatabaseHelper.COLUMN_STATUS, status);
        return db.insert(DatabaseHelper.TABLE_AGENDA, null, values);
    }

    public List<Agenda> getAllAgendas() {
        List<Agenda> agendaList = new ArrayList<>();
        Cursor cursor = db.query(DatabaseHelper.TABLE_AGENDA, null, null, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
                String nama = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAMA));
                String deskripsi = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DESKRIPSI));
                String status = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_STATUS));
                agendaList.add(new Agenda(id, nama, deskripsi, status));
            }
            cursor.close();
        }
        return agendaList;
    }
}
