package com.example.fieldbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteValidationHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
    //Table Name
    private static final String TABLE_VALIDATION = "Validation";
    //For Database declaration
    private SQLiteDatabase db1;
    // Validation Table Column names
    private static final String VALIDATION_VALIDATIONID = "ValidationID";
    private static final String VALIDATION_VALIDATIONDESCRIPTION = "ValidationDescription";
    private static final String VALIDATION_VALIDATIONTYPE= "ValidationType";
    private static final String VALIDATION_VALUES= "Values";
    private static final String VALIDATION_ACTIVE= "Active";
    private static final String VALIDATION_SEQID = "SeqID";
    
    //Columns per table
    private static final String[] VALIDATION_COLUMNS = {VALIDATION_VALIDATIONID, VALIDATION_VALIDATIONDESCRIPTION, VALIDATION_VALIDATIONTYPE, 
		VALIDATION_VALUES, VALIDATION_ACTIVE, VALIDATION_SEQID};
	public MySQLiteValidationHelper(Context context) { // constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
	@Override
    public void onCreate(SQLiteDatabase db) {     
		// SQL statement to create Validation table
        String CREATE_VALIDATION_TABLE = "CREATE TABLE if not exists Validation ( " +
                "VALIDATION_VALIDATIONID TEXT PRIMARY KEY, " + 
                "VALIDATION_VALIDATIONDESCRIPTION TEXT, "+
                "VALIDATION_VALIDATIONTYPE TEXT," +
                "VALIDATION_VALUES TEXT," +
                "VALIDATION_ACTIVE TEXT," + 
                "DEVICE_SEQID INTEGER AUTOINCREMENT)";
        this.db1 = db; 
        // create all the tables
        db.execSQL(CREATE_VALIDATION_TABLE);
	}
	
	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS Validation");
        // create fresh user table
        this.onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
    
    public String getTableName(){
    	return TABLE_VALIDATION;
    }
    
    public String getDatabaseName(){
    	return DATABASE_NAME;
    }
    
    public String[] getColHeads(){
    	return VALIDATION_COLUMNS;
    }
}



