package com.example.fieldbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLitePMAHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
    //Table Name
    private static final String TABLE_PMA = "PropertyMethodAssn";
    //For Database declaration
    private SQLiteDatabase db1;
    // PropertyMethodAssn Table Column names
    private static final String PMA_PROPERTYMETHODASSNID = "PropertyMethodAssn";
    private static final String PMA_PROPERTYID= "PropertyID";
    private static final String PMA_METHODID= "MethodID";
    private static final String PMA_VALIDATIONID= "Validation";
    private static final String PMA_SEQID= "SeqID";
    
    //Columns per table
    private static final String[] PMA_COLUMNS = {PMA_PROPERTYMETHODASSNID, PMA_PROPERTYID, PMA_METHODID, PMA_VALIDATIONID, PMA_SEQID};
	public MySQLitePMAHelper(Context context) { // constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
	@Override
    public void onCreate(SQLiteDatabase db) {     
		// SQL statement to create Method table
		// SQL statement to create PropertyMethodAssn table
        String CREATE_PMA_TABLE = "CREATE TABLE if not exists PMA ( " +
                "PMA_PROPERTYMETHODASSNID TEXT PRIMARY KEY, " + 
                "PMA_PROPERTYID TEXT, "+
                "PMA_METHODID TEXT," +
                "PMA_VALIDATIONID TEXT," +
                "PMA_SEQID INTEGER AUTOINCREMENT)";
        this.db1 = db; 
        // create all the tables
        db.execSQL(CREATE_PMA_TABLE);
	}
	
	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS PMA");
        // create fresh user table
        this.onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
    
    public String getTableName(){
    	return TABLE_PMA;
    }
    
    public String getDatabaseName(){
    	return DATABASE_NAME;
    }
    
    public String[] getColHeads(){
    	return PMA_COLUMNS;
    }
}