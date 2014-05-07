package com.example.fieldbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOutlierDataHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
    //Table Name
    private static final String TABLE_OUTLIERDATA = "OutlierData";
    //For Database declaration
    private SQLiteDatabase db1;
 // OutlierData Table Column names
    private static final String OUTLIERDATA_PROPERTYMETHODASSNID= "PropertyMethodAssnID";
    private static final String OUTLIERDATA_VALIDATIONID= "ValidationID";
    private static final String OUTLIERDATA_VALUE= "Value";
    private static final String OUTLIERDATA_SEQID = "SeqID";
    
    //Columns per table
    private static final String[] OUTLIERDATA_COLUMNS = {OUTLIERDATA_PROPERTYMETHODASSNID, OUTLIERDATA_VALIDATIONID, OUTLIERDATA_VALUE, OUTLIERDATA_SEQID};
	public MySQLiteOutlierDataHelper(Context context) { // constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
	@Override
    public void onCreate(SQLiteDatabase db) {     
        // SQL statement to create OutlierData table
        String CREATE_OUTLIERDATA_TABLE = "CREATE TABLE if not exists OutlierData ( " +
                "OUTLIERDATA_PROPERTYMETHODASSNID TEXT PRIMARY KEY, " + 
                "OUTLIERDATA_VALIDATIONID TEXT, "+
                "OUTLIERDATA_VALUE TEXT," +
                "OUTLIER_SEQID INTEGER AUTOINCREMENT)";
        
        this.db1 = db; 
        // create all the tables
        db.execSQL(CREATE_OUTLIERDATA_TABLE);
	}
	
	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS OutlierData");
        // create fresh user table
        this.onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
    
    public String getTableName(){
    	return TABLE_OUTLIERDATA;
    }
    
    public String getDatabaseName(){
    	return DATABASE_NAME;
    }
    
    public String[] getColHeads(){
    	return OUTLIERDATA_COLUMNS;
    }
}



