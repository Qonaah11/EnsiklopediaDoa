package com.example.qonaah.ensiklopediadoa.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.example.qonaah.ensiklopediadoa.model.Hari;
import com.example.qonaah.ensiklopediadoa.model.Nama;
import com.example.qonaah.ensiklopediadoa.model.Shiroh;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qona'ah on 10/1/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Info
    private static final String DATABASE_NAME = "kp";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_DOA = "doa_table";
    private static final String TABLE_NAMA = "nama_table";
    private static final String TABLE_SHIROH = "shiroh_table";


    // Category Table Columns
    private static final String KEY_ID = "id";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_KETERANGAN = "keterangan";
    private static final String KEY_VIDEO = "video";

    // Create table CATEGORY DOA
    private String CREATE_DOA_TABLE = "CREATE TABLE " + TABLE_DOA +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," + // Define a primary key
            KEY_NAMA + " TEXT," +
            KEY_IMAGE + " TEXT," +
            KEY_KETERANGAN + " TEXT" +
            ")";

    // Create table CATEGORY TABLE_NAMA
    private String CREATE_NAMA_TABLE = "CREATE TABLE " + TABLE_NAMA +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," + // Define a primary key
            KEY_NAMA + " TEXT," +
            KEY_IMAGE + " TEXT," +
            KEY_KETERANGAN + " TEXT" +
            ")";
    // Create table CATEGORY TABLE_SHIROH
    private String CREATE_SHIROH_TABLE = "CREATE TABLE " + TABLE_SHIROH +
            "(" +
            KEY_ID + " INTEGER PRIMARY KEY," + // Define a primary key
            KEY_NAMA + " TEXT," +
            KEY_VIDEO + " TEXT," +
            KEY_KETERANGAN + " TEXT" +
            ")";

    private static DatabaseHelper sInstance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }

        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            db.setForeignKeyConstraintsEnabled(true);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DOA_TABLE);
        db.execSQL(CREATE_NAMA_TABLE);
        db.execSQL(CREATE_SHIROH_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_DOA_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_NAMA_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_SHIROH_TABLE);

            onCreate(db);
        }
    }

    // TODO ADD CONTENT
    public int simpanDoa(Hari param) {
        int result = 0;
        SQLiteDatabase database = getWritableDatabase();
        database.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_NAMA, param.getNama());
            values.put(KEY_KETERANGAN, param.getKeterangan());
            values.put(KEY_IMAGE, param.getImage());

            result = (int) database.insertOrThrow(TABLE_DOA, null, values);
            database.setTransactionSuccessful();
            Log.d("DatabaseHelper", "SAVE TABLE_DOA SUCCESS");
        } catch (Exception e) {
            Log.d("DatabaseHelper", "Error while trying to add Category to database");
        } finally {
            database.endTransaction();
        }

        return result;
    }

    public int ubahDoa(Hari param) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, param.getNama());
        values.put(KEY_IMAGE, param.getImage());
        values.put(KEY_KETERANGAN, param.getKeterangan());

        return database.update(TABLE_DOA, values, KEY_ID + " = ?", new String[]{String.valueOf(param.getId())});
    }

    public boolean hapusDoa(Hari hari) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_NAMA, KEY_ID + "=" + hari.getId(), null) > 0;
    }

    public int simpanNama(Nama param) {
        int result = 0;
        SQLiteDatabase database = getWritableDatabase();
        database.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_NAMA, param.getNama());
            values.put(KEY_KETERANGAN, param.getKeterangan());
            values.put(KEY_IMAGE, param.getImage());

            result = (int) database.insertOrThrow(TABLE_NAMA, null, values);
            database.setTransactionSuccessful();
            Log.d("DatabaseHelper", "SAVE TABLE_DOA SUCCESS");
        } catch (Exception e) {
            Log.d("DatabaseHelper", "Error while trying to add Category to database");
        } finally {
            database.endTransaction();
        }

        return result;
    }

    public int ubahNama(Nama param) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, param.getNama());
        values.put(KEY_IMAGE, param.getImage());
        values.put(KEY_KETERANGAN, param.getKeterangan());

        return database.update(TABLE_NAMA, values, KEY_ID + " = ?", new String[]{String.valueOf(param.getId())});
    }

    public boolean hapusNama(Nama nama) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_NAMA, KEY_ID + "=" + nama.getId(), null) > 0;
    }

    public int simpanShiroh(Shiroh param) {
        int result = 0;
        SQLiteDatabase database = getWritableDatabase();
        database.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_NAMA, param.getNama());
            values.put(KEY_KETERANGAN, param.getKeterangan());
            values.put(KEY_VIDEO, param.getVideo());

            result = (int) database.insertOrThrow(TABLE_SHIROH, null, values);
            database.setTransactionSuccessful();
            Log.d("DatabaseHelper", "SAVE TABLE_SHIROH SUCCESS");
        } catch (Exception e) {
            Log.d("DatabaseHelper", "Error while trying to add Category to database");
        } finally {
            database.endTransaction();
        }

        return result;
    }

    public int ubahShiroh(Shiroh param) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, param.getNama());
        values.put(KEY_VIDEO, param.getVideo());
        values.put(KEY_KETERANGAN, param.getKeterangan());

        return database.update(TABLE_SHIROH, values, KEY_ID + " = ?", new String[]{String.valueOf(param.getId())});
    }

    public boolean hapusShiroh(Shiroh shiroh) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_SHIROH, KEY_ID + "=" + shiroh.getId(), null) > 0;
    }

    // TODO FIND CONTENT
    public List<Hari> selectDoa() {
        List<Hari> categories = new ArrayList<>();
        String SELECT_QUERY = "SELECT * FROM " + TABLE_DOA + " ";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Hari hari = new Hari();
                    hari.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                    hari.setNama(cursor.getString(cursor.getColumnIndex(KEY_NAMA)));
                    hari.setImage(cursor.getString(cursor.getColumnIndex(KEY_IMAGE)));
                    hari.setKeterangan(cursor.getString(cursor.getColumnIndex(KEY_KETERANGAN)));

                    categories.add(hari);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d("DatabaseHelper", "Error while trying to get Hari from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return categories;
    }

    public List<Nama> selectNama() {
        List<Nama> categories = new ArrayList<>();
        String SELECT_QUERY = "SELECT * FROM " + TABLE_NAMA + " ";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Nama nama = new Nama();
                    nama.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                    nama.setNama(cursor.getString(cursor.getColumnIndex(KEY_NAMA)));
                    nama.setImage(cursor.getString(cursor.getColumnIndex(KEY_IMAGE)));
                    nama.setKeterangan(cursor.getString(cursor.getColumnIndex(KEY_KETERANGAN)));

                    categories.add(nama);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d("DatabaseHelper", "Error while trying to get Nama from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return categories;
    }

    public List<Shiroh> selectShiroh() {
        List<Shiroh> categories = new ArrayList<>();
        String SELECT_QUERY = "SELECT * FROM " + TABLE_SHIROH + " ";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Shiroh shiroh = new Shiroh();
                    shiroh.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                    shiroh.setNama(cursor.getString(cursor.getColumnIndex(KEY_NAMA)));
                    shiroh.setVideo(cursor.getString(cursor.getColumnIndex(KEY_VIDEO)));
                    shiroh.setKeterangan(cursor.getString(cursor.getColumnIndex(KEY_KETERANGAN)));

                    categories.add(shiroh);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d("DatabaseHelper", "Error while trying to get Shiroh from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return categories;
    }
}
