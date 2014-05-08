package com.example.fieldbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteDataHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
    //Table Name
    private static final String TABLE_DATA = "Data";
    //For Database declaration
    private SQLiteDatabase db1;
    // Data Table Column names
    private static final String DATA_DATAID = "DataID";
    private static final String DATA_PROPERTYMETHODASSN = "PropertyMethodAssn";
    private static final String DATA_VALUE = "Value";
    private static final String DATA_USERIDNO = "UserIDNo";
    private static final String DATA_DATETIME = "DateTime";
    private static final String DATA_DEVICEID = "DeviceID";
    private static final String DATA_LONGITUDE = "Longitude";
    private static final String DATA_LATITUDE = "Latitude";
    private static final String DATA_ACTIVE = "Active";
    private static final String DATA_BLOCKED = "Blocked";
    private static final String DATA_SEQID = "SeqID";
    
    //Columns per table
    private static final String[] DATA_COLUMNS = {DATA_DATAID, DATA_PROPERTYMETHODASSN, DATA_VALUE, DATA_USERIDNO, 
		DATA_DATETIME, DATA_DEVICEID, DATA_LONGITUDE, DATA_LATITUDE, DATA_ACTIVE, 
		DATA_BLOCKED, DATA_SEQID};

	public MySQLiteDataHelper(Context context) { // constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
	@Override
    public void onCreate(SQLiteDatabase db) {     
        // SQL statement to create Data table
        String CREATE_DATA_TABLE = "CREATE TABLE Data ( " +
                "DATA_DATAID TEXT PRIMARY KEY, " + 
                "DATA_PROPERTYMETHODASSN TEXT, "+
                "DATA_VALUE TEXT," +
                "DATA_USERIDNO TEXT,"+
                "DATA_DATETIME TEXT,"+
                "DATA_DEVICEID TEXT,"+
                "DATA_LONGITUDE TEXT,"+
                "DATA_LATITUDE TEXT,"+
                "DATA_ACTIVE TEXT," +
                "DATA_BLOCKED TEXT," +
                "DATA_SEQID INTEGER AUTOINCREMENT)";
        this.db1 = db; 
        // create all the tables
        db.execSQL(CREATE_DATA_TABLE);
	}
	
	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS Data");
        // create fresh user table
        this.onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
    
    public String getTableName(){
    	return TABLE_DATA;
    }
    
    public String getDatabaseName(){
    	return DATABASE_NAME;
    }
    
    public String[] getColHeads(){
    	return DATA_COLUMNS;
    }
}



