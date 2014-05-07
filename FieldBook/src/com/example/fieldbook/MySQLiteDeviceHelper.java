package com.example.fieldbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteDeviceHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
    //Table Name
    private static final String TABLE_DEVICE = "Device";
    //For Database declaration
    private SQLiteDatabase db1;
    // Device Table Column names
    private static final String DEVICE_DEVICEID= "DeviceID";
    private static final String DEVICE_DEVICEDESCRIPTION = "DeviceDescription";
    private static final String DEVICE_ACTIVE = "Active";
    private static final String DEVICE_SEQID = "SeqID";
    
    //Columns per table
    private static final String[] DEVICE_COLUMNS = {DEVICE_DEVICEID, DEVICE_DEVICEDESCRIPTION, DEVICE_ACTIVE, DEVICE_SEQID};
	public MySQLiteDeviceHelper(Context context) { // constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
	@Override
    public void onCreate(SQLiteDatabase db) {     
		// SQL statement to create Device table
        String CREATE_DEVICE_TABLE = "CREATE TABLE if not exists Device ( " +
                "DEVICE_DEVICEID TEXT PRIMARY KEY, " + 
                "DEVICE_DEVICEDESCRIPTION TEXT, "+
                "DEVICE_ACTIVE TEXT," +
                "DEVICE_SEQID INTEGER AUTOINCREMENT)";
        this.db1 = db; 
        // create all the tables
        db.execSQL(CREATE_DEVICE_TABLE);
	}
	
	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS Device");
        // create fresh user table
        this.onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
    
    public String getTableName(){
    	return TABLE_DEVICE;
    }
    
    public String getDatabaseName(){
    	return DATABASE_NAME;
    }
    
    public String[] getColHeads(){
    	return DEVICE_COLUMNS;
    }
}



