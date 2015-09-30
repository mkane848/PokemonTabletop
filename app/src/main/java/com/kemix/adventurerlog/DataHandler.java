package com.kemix.adventurerlog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kemix on 9/29/2015.
 */
public final class DataHandler {
    FeedReaderDbHelper mDbHelper;
    SQLiteDatabase db;
    Context ctx;
    public DataHandler(Context ctx)
    {
        this.ctx=ctx;
        mDbHelper=new FeedReaderDbHelper(ctx);
    }
    public static final String TABLE_NAME = "Classes";
    public static final String COLUMN_NAME_CLASSID = "classID"
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_PREREQ1 = "prerequesite1";
    public static final String COLUMN_NAME_PREREQ2 = "prerequisite2";
    public static final String COLUMN_NAME_BONUS1 = "bonus1";
    public static final String COLUMN_NAME_BONUS2 = "bonus2";
    public static final String COLUMN_NAME_PENALTY = "penalty";

    private static final String CREATE_TABLE= "CREATE TABLE "+ TABLE_NAME + " ("+COLUMN_NAME_CLASSID+ " TEXT NOT NULL,"+ COLUMN_NAME_NAME + " TEXT NOT NULL,"+ COLUMN_NAME_PREREQ1 + " TEXT NOT NULL,"+ COLUMN_NAME_PREREQ2 +
        "TEXT NOT NULL,"+ COLUMN_NAME_BONUS1 + "TEXT NOT NULL," + COLUMN_NAME_BONUS2 + "TEXT NOT NULL,"+ COLUMN_NAME_PENALTY + "TEXT NOT NULL);";
    private static final String SQL_DELETE_ENTRIES ="DROP TABLE IF EXISTS " + TABLE_NAME;

    public class FeedReaderDbHelper extends SQLiteOpenHelper
    {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "FeedReader.db";

        public FeedReaderDbHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(CREATE_TABLE);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }
    }
    public DataHandler open()
    {
        db=mDbHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }
    public void Insert(String id, String name, String pre1, String pre2, String bonus1, String bonus2, String pen)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_CLASSID, id);
        values.put(COLUMN_NAME_NAME, name);
        values.put(COLUMN_NAME_PREREQ1, pre1);
        values.put(COLUMN_NAME_PREREQ2, pre2);
        values.put(COLUMN_NAME_BONUS1, bonus1);
        values.put(COLUMN_NAME_BONUS2, bonus2);
        values.put(COLUMN_NAME_PENALTY, pen);

        db.insert(TABLE_NAME, null, values);
    }
    public Cursor returnData()
    {
        return db.query(TABLE_NAME, new String[]{COLUMN_NAME_CLASSID, COLUMN_NAME_NAME, COLUMN_NAME_PREREQ1, COLUMN_NAME_PREREQ2, COLUMN_NAME_BONUS1, COLUMN_NAME_BONUS2, COLUMN_NAME_PENALTY}, null, null, null, null, null);
    }

}
