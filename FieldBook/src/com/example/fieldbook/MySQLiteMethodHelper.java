package com.example.fieldbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteMethodHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
    //Table Name
    private static final String TABLE_METHOD = "Method";
    //For Database declaration
    private SQLiteDatabase db1;
    // Method Table Column names
    private static final String METHOD_METHODID= "MethodID";
    private static final String METHOD_METHODDESCRIPTION = "MethodDescription";
    private static final String METHOD_ACTIVE = "Active";
    private static final String METHOD_SEQID = "SeqID";
    
    //Columns per table
    private static final String[] METHOD_COLUMNS = {METHOD_METHODID, METHOD_METHODDESCRIPTION, METHOD_ACTIVE, METHOD_SEQID};
	public MySQLiteMethodHelper(Context context) { // constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
	@Override
    public void onCreate(SQLiteDatabase db) {     
		// SQL statement to create Method table
        String CREATE_METHOD_TABLE = "CREATE TABLE if not exists Method ( " +
                "METHOD_METHODID TEXT PRIMARY KEY, " + 
                "METHOD_METHODDESCRIPTION TEXT, "+
                "METHOD_ACTIVE TEXT," +
                "METHOD_SEQID INTEGER AUTOINCREMENT)";
        this.db1 = db; 
        // create all the tables
        db.execSQL(CREATE_METHOD_TABLE);
	}
	
	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS Method");
        // create fresh user table
        this.onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
    
    public String getTableName(){
    	return TABLE_METHOD;
    }
    
    public String getDatabaseName(){
    	return DATABASE_NAME;
    }
    
    public String[] getColHeads(){
    	return METHOD_COLUMNS;
    }
}



