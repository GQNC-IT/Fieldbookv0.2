package com.example.fieldbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOrgUnitHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
    //Table Name
    private static final String TABLE_ORGUNIT = "OrgUnit";
    //For Database declaration
    private SQLiteDatabase db1; 
    // OrgUnit Table Column names
    private static final String ORGUNIT_ORGUNITID= "OrgUnitID";
    private static final String ORGUNIT_ORGUNITDESCRIPTION = "OrgUnitDescription";
    private static final String ORGUNIT_ORGUNITABBR = "OrgUnitAbbr";
    private static final String ORGUNIT_SEQID = "SeqID";
    
    //Columns per table
    private static final String[] ORGUNIT_COLUMNS = {ORGUNIT_ORGUNITID, ORGUNIT_ORGUNITDESCRIPTION, ORGUNIT_ORGUNITABBR, ORGUNIT_SEQID};
	
    public MySQLiteOrgUnitHelper(Context context) { // constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
	@Override
    public void onCreate(SQLiteDatabase db) {     
		// SQL statement to create OrgUnit table
        String CREATE_ORGUNIT_TABLE = "CREATE TABLE if not exists OrgUnit( " +
                "ORGUNIT_ORGUNITID TEXT PRIMARY KEY, " + 
                "ORGUNIT_DESCRIPTION TEXT, "+
                "ORGUNIT_ORGUNITABBR TEXT," +
                "ORGUNIT_SEQID INTEGER AUTOINCREMENT)";
        this.db1 = db; 
        // create all the tables
        db.execSQL(CREATE_ORGUNIT_TABLE);
	}
	
	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS OrgUnit");
        // create fresh user table
        this.onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
    
    public String getTableName(){
    	return TABLE_ORGUNIT;
    }
    
    public String getDatabaseName(){
    	return DATABASE_NAME;
    }
    
    public String[] getColHeads(){
    	return ORGUNIT_COLUMNS;
    }
}