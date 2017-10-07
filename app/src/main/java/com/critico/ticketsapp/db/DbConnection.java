package com.critico.ticketsapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.StringTokenizer;

public class DbConnection extends SQLiteOpenHelper
{

    private static DbConnection instance;

    private Context context;
    private String[] updates;

    private static final String DB_NAME = "com.critico.ticketsapp.db";
    private static final int DB_VERSION = 1;

    private DbConnection(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        updates = new String[DB_VERSION];
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        for (String query : updates)
        {
            executeDDL(query, sqLiteDatabase);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        for(int i = oldVersion; i < newVersion; i++)
            executeDDL(updates[i], db);
    }

    private void executeDDL(int commands, SQLiteDatabase db)
    {
        String sql = context.getResources().getString(commands);
        executeDDL(sql, db);
    }

    private void executeDDL(String sql, SQLiteDatabase db)
    {
        StringTokenizer queries = new StringTokenizer(sql,";");
        while(queries.hasMoreTokens())
        {
            String q = queries.nextToken();
            db.execSQL(q);
        }
    }

    public int insert(Table table, ContentValues values)
    {
        SQLiteDatabase db = getWritableDatabase();

        int id = (int) db.insertOrThrow(table.toString(), null, values);
        return id;
    }

    public void update(Table table, ContentValues values, String whereExpression, String[] whereArgs)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.update(table.toString(), values, whereExpression, whereArgs);
    }

    public void delete(Table table, String whereClause, String[] whereArgs)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(table.toString(), whereClause, whereArgs);
    }

    public Cursor executeQuery(Table table, String[] columns, String whereExpression, String[] selectionArgs)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(table.toString(), columns, whereExpression, selectionArgs, null, null, null);
        return cursor;
    }

    public Cursor executeQuery(int query, String[] selectionArgs)
    {
        SQLiteDatabase db = getReadableDatabase();
        String strQuery = this.context.getResources().getString(query);
        Cursor cursor = db.rawQuery(strQuery , selectionArgs);
        return cursor;
    }

    public synchronized static DbConnection getInstance()
    {
        if(instance == null)
        {
            //instance = new DbConnection(AppContext.getInstance()); //Change with Applicacion Context
        }
        return instance;
    }

    public static boolean dataBaseExist()
    {
        //File database = AppContext.getInstance().getDatabasePath(DB_NAME);
        boolean exist = false;
      /*  if (!database.exists())
        {
            exist = false;
        }
        else
        {
            exist = true;
        }*/
        return exist;
    }

}
