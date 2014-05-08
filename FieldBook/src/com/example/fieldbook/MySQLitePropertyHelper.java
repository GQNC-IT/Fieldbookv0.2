package com.example.fieldbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLitePropertyHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
    //Table Name
    private static final String TABLE_PROPERTY = "Property";
    //For Database declaration
    private SQLiteDatabase db1;
    // Property Table Column names
    private static final String PROPERTY_PROPERTYID = "PropertyID";
    private static final String PROPERTY_PROPERTYDESCRIPTION = "PropertyDescription";
    private static final String PROPERTY_ACTIVE = "Active";
    private static final String PROPERTY_SEQID = "SeqID";
    
    //Columns per table
    private static final String[] PROPERTY_COLUMNS = {PROPERTY_PROPERTYID, PROPERTY_PROPERTYDESCRIPTION, 
    								PROPERTY_ACTIVE, PROPERTY_SEQID};
	public MySQLitePropertyHelper(Context context) { // constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
	@Override
    public void onCreate(SQLiteDatabase db) {     
		// SQL statement to create Property table
        String CREATE_PROPERTY_TABLE = "CREATE TABLE Property ( " +
                "PROPERTY_PROPERTYID TEXT PRIMARY KEY, " + 
                "PROPERTY_PROPERTYDESCRIPTION TEXT, "+
                "PROPERTY_ACTIVE," +
                "PROPERTY_SEQID INTEGER AUTOINCREMENT)";
        this.db1 = db; 
        // create all the tables
        db.execSQL(CREATE_PROPERTY_TABLE);
	}
	
	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS Property");
        // create fresh user table
        this.onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
    
    public String getTableName(){
    	return TABLE_PROPERTY;
    }
    
    public String getDatabaseName(){
    	return DATABASE_NAME;
    }
    
    public String[] getColHeads(){
    	return PROPERTY_COLUMNS;
    }
}



