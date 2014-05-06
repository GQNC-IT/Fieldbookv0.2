package com.example.fieldbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	//For Database declaration
    private SQLiteDatabase db1;
    
	// Logcat tag
    private static final String LOG = "DatabaseHelper";
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
 
    // Table Names
    private static final String TABLE_DATA = "Data";
    private static final String TABLE_DEVICE = "Device";
    private static final String TABLE_METHOD = "Method";
    private static final String TABLE_ORGUNIT = "OrgUnit";
    private static final String TABLE_OUTLIERDATA = "OutlierData";
    private static final String TABLE_PROPERTY= "Property";
    private static final String TABLE_PMA = "PropertyMethodAssn";
    private static final String TABLE_VALIDATION = "Validation";
    private static final String TABLE_USER = "User";
    
    // Common column names
    private static final String KEY_SEQID = "SeqID";
    private static final String KEY_PMAID = "PropertyMethodAssnID";
    private static final String KEY_USERIDNO = "UserIDNo";
    private static final String KEY_DEVICEID = "DeviceID";
    private static final String KEY_PROPERTYID = "PropertyID";
    private static final String KEY_METHODID= "MethodID";
    private static final String KEY_VALIDATIONID = "ValidationID";
    private static final String KEY_ORGUNITID = "OrgUnitID";
    private static final String KEY_VALUE = "Value";
    private static final String KEY_ACTIVE = "Active";
    private static final String KEY_BLOCKED = "Blocked";
    
    // DATA Table - column names
    private static final String KEY_DATAID= "DataID";
    private static final String KEY_DATETIME = "DateTime";
    private static final String KEY_LONGITUDE = "Longitude";
    private static final String KEY_LATITUDE = "Latitude";
 
    // PropertyMethodAssn Table - column names
    
    // Method Table - column names
    private static final String KEY_METHOD_DESCRIPTION = "MethodDescription";
 
    // Property Table - column names
    private static final String KEY_PROPERTY_DESCRIPTION = "PropertyDescription";
    
    // OutlierData Table - column names
    
    // Device Table - column names
    private static final String KEY_DEVICE_DESCRIPTION = "DeviceDescription";
    
    // Validation Table - column names
    private static final String KEY_VALIDATION_DESCRIPTION = "ValidationDescription";
    private static final String KEY_VALIDATION_TYPE= "ValidationType";
    
    // OrgUnit Table - column names
    private static final String KEY_ORG_UNIT_DESCRIPTION = "OrgUnitDescription";
    private static final String KEY_ORG_UNIT_ABBR = "OrgUnitAbbr";
    
    // User Table - column names
    private static final String KEY_USERNAME= "Username";
    private static final String KEY_PASSWORD = "Password";
    private static final String KEY_FIRSTNAME = "FirstName";
    private static final String KEY_MIDDLENAME = "MiddleName";
    private static final String KEY_LASTNAME= "LastName";
    
    
    //Columns per table
    private static final String[] DATA_COLUMNS = {KEY_DATAID, KEY_PMAID, KEY_VALUE, KEY_USERIDNO, 
    	KEY_DATETIME, KEY_DEVICEID, KEY_LONGITUDE, KEY_LATITUDE, KEY_ACTIVE, 
    	KEY_BLOCKED, KEY_SEQID};
    
    private static final String[] DEVICE_COLUMNS = {KEY_DEVICEID, KEY_DEVICE_DESCRIPTION, KEY_ACTIVE, KEY_SEQID};
    
    private static final String[] METHOD_COLUMNS = {KEY_METHODID, KEY_METHOD_DESCRIPTION, KEY_ACTIVE, KEY_SEQID};
    
    private static final String[] ORGUNIT_COLUMNS = {KEY_ORGUNITID, KEY_ORG_UNIT_DESCRIPTION, KEY_ORG_UNIT_ABBR, KEY_SEQID};
	
    private static final String[] OUTLIERDATA_COLUMNS = {KEY_PMAID, KEY_VALIDATIONID, KEY_VALUE, KEY_SEQID};
    
    private static final String[] PMA_COLUMNS = {KEY_PMAID, KEY_PROPERTYID, KEY_METHODID, KEY_VALIDATIONID, KEY_SEQID};
    
    private static final String[] PROPERTY_COLUMNS = {KEY_PROPERTYID, KEY_PROPERTY_DESCRIPTION, KEY_ACTIVE, KEY_SEQID};
    
    private static final String[] USER_COLUMNS = {KEY_USERIDNO, KEY_USERNAME, KEY_PASSWORD, KEY_FIRSTNAME, KEY_MIDDLENAME, KEY_LASTNAME, KEY_ORGUNITID, KEY_SEQID};
    
    private static final String[] VALIDATION_COLUMNS = {KEY_VALIDATIONID, KEY_VALIDATION_DESCRIPTION, KEY_VALIDATION_TYPE, KEY_VALUE, KEY_ACTIVE, KEY_SEQID};
    // Table Create Statements
    
    // DATA create statement 
    private static final String CREATE_TABLE_DATA = "CREATE TABLE if not exists" + TABLE_DATA + "(" 
    		+ KEY_DATAID + " TEXT PRIMARY KEY," 
    		+ KEY_PMAID + " TEXT," 
    		+ KEY_VALUE + " TEXT," 
    		+ KEY_USERIDNO + " TEXT" 
    		+ KEY_DATETIME + " DATETIME"
    		+ KEY_DEVICEID + " TEXT"
    		+ KEY_LONGITUDE + " TEXT"
    		+ KEY_LATITUDE + " TEXT"
    		+ KEY_ACTIVE + " TEXT"
    		+ KEY_BLOCKED + " TEXT"
    		+ KEY_SEQID + " INTEGER AUTOINCREMENT"
    		+ ")";
    
    // PMA create statement 
    private static final String CREATE_TABLE_PMA = "CREATE TABLE if not exists" + TABLE_PMA + "(" 
    		+ KEY_PMAID + " TEXT PRIMARY KEY," 
    		+ KEY_PROPERTYID + " TEXT," 
    		+ KEY_METHODID + " TEXT," 
    		+ KEY_VALIDATIONID + " TEXT"
    		+ KEY_SEQID + " INTEGER AUTOINCREMENT"
    		+ ")";
    
    // METHOD create statement 
    private static final String CREATE_TABLE_METHOD = "CREATE TABLE if not exists" + TABLE_METHOD + "(" 
    		+ KEY_METHODID + " TEXT PRIMARY KEY," 
    		+ KEY_METHOD_DESCRIPTION + " TEXT," 
    		+ KEY_ACTIVE + " TEXT," 
    		+ KEY_SEQID + " INTEGER AUTOINCREMENT"
    		+ ")";
    
    // PROPERTY create statement 
    private static final String CREATE_TABLE_PROPERTY  = "CREATE TABLE if not exists" + TABLE_PROPERTY + "(" 
    		+ KEY_PROPERTYID + " TEXT PRIMARY KEY," 
    		+ KEY_PROPERTY_DESCRIPTION + " TEXT," 
    		+ KEY_ACTIVE + " TEXT," 
    		+ KEY_SEQID + " INTEGER AUTOINCREMENT"
    		+ ")";
    
    // OUTLIERDATA create statement 
    private static final String CREATE_TABLE_OUTLIERDATA  = "CREATE TABLE if not exists" + TABLE_OUTLIERDATA + "(" 
    		+ KEY_SEQID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
    		+ KEY_PMAID + " TEXT," 
    		+ KEY_VALIDATIONID + " TEXT," 
    		+ KEY_VALUE + " TEXT"
    		+ ")";
    
    // DEVICE create statement 
    private static final String CREATE_TABLE_DEVICE   = "CREATE TABLE if not exists" + TABLE_DEVICE + "(" 
    		+ KEY_DEVICEID + " TEXT PRIMARY KEY," 
    		+ KEY_DEVICE_DESCRIPTION + " TEXT," 
    		+ KEY_ACTIVE + " TEXT," 
    		+ KEY_SEQID + " INTEGER AUTOINCREMENT"
    		+ ")";
    
    // ORGUNIT create statement 
    private static final String CREATE_TABLE_ORGUNIT= "CREATE TABLE if not exists" + TABLE_ORGUNIT + "(" 
    		+ KEY_ORGUNITID + " TEXT PRIMARY KEY," 
    		+ KEY_ORG_UNIT_DESCRIPTION + " TEXT," 
    		+ KEY_ORG_UNIT_ABBR + " TEXT," 
    		+ KEY_SEQID + " INTEGER AUTOINCREMENT"
    		+ ")";
    
    // VALIDATION create statement 
    private static final String CREATE_TABLE_VALIDATION   = "CREATE TABLE if not exists" + TABLE_VALIDATION + "(" 
    		+ KEY_VALIDATIONID + " TEXT PRIMARY KEY," 
    		+ KEY_VALIDATION_DESCRIPTION + " TEXT," 
    		+ KEY_VALIDATION_TYPE + " TEXT,"
    		+ KEY_VALUE + " TEXT," 
    		+ KEY_ACTIVE + " TEXT," 
    		+ KEY_SEQID + " INTEGER AUTOINCREMENT"
    		+ ")";
    
    // USER create statement 
    private static final String CREATE_TABLE_USER= "CREATE TABLE if not exists" + TABLE_USER + "(" 
    		+ KEY_USERIDNO + " TEXT PRIMARY KEY," 
    		+ KEY_USERNAME + " TEXT," 
    		+ KEY_PASSWORD + " TEXT," 
    		+ KEY_FIRSTNAME + " TEXT" 
    		+ KEY_MIDDLENAME + " DATETIME"
    		+ KEY_LASTNAME + " TEXT"
    		+ KEY_ORGUNITID + " TEXT"
    		+ KEY_SEQID + " INTEGER AUTOINCREMENT"
    		+ ")";
    
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
 
        // creating required tables
        db.execSQL(CREATE_TABLE_DATA);
        db.execSQL(CREATE_TABLE_METHOD);
        db.execSQL(CREATE_TABLE_PMA);
        db.execSQL(CREATE_TABLE_PROPERTY);
        db.execSQL(CREATE_TABLE_VALIDATION);
        db.execSQL(CREATE_TABLE_DEVICE);
        db.execSQL(CREATE_TABLE_ORGUNIT);
        db.execSQL(CREATE_TABLE_OUTLIERDATA);
        db.execSQL(CREATE_TABLE_USER);
        this.db1 = db;
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_METHOD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PMA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROPERTY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VALIDATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEVICE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORGUNIT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OUTLIERDATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
 
        // create new tables
        onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
   
    public String getDatabaseName(){
    	return DATABASE_NAME;
    }
    
    /* DATA */
    public String getTableData(){
    	return TABLE_DATA;
    }
    
    public String[] getColData(){
    	return DATA_COLUMNS;
    }
    
    /* DEVICE */
    public String getTableDevice(){
    	return TABLE_DEVICE;
    }
    
    public String[] getColDevice(){
    	return DEVICE_COLUMNS;
    }
    
    /* PROPERTY */
    public String getTableProperty(){
    	return TABLE_PROPERTY;
    }
    
    public String[] getColProperty(){
    	return PROPERTY_COLUMNS;
    }

    /* PMA*/
    public String getTablePMA(){
    	return TABLE_PMA;
    }
    
    public String[] getColPMA(){
    	return PMA_COLUMNS;
    }
    
    /* METHOD */
    public String getTableMethod(){
    	return TABLE_METHOD;
    }
    
    public String[] getColMethpd(){
    	return METHOD_COLUMNS;
    }
 
    /* USER */
    public String getTableUser(){
    	return TABLE_USER;
    }
    
    public String[] getColUser(){
    	return USER_COLUMNS;
    }

    /* Validation */
    public String getTableValidation(){
    	return TABLE_VALIDATION;
    }
    
    public String[] getColValidation(){
    	return VALIDATION_COLUMNS;
    }
    
    /* OUTLIERDATA */
    public String getTableOutlierData(){
    	return TABLE_OUTLIERDATA;
    }
    
    public String[] getColOutlierData(){
    	return OUTLIERDATA_COLUMNS;
    }
    
    /* ORGUNIT */
    public String getTableOrgUnit(){
    	return TABLE_ORGUNIT;
    }
    
    public String[] getColOrgUnit(){
    	return ORGUNIT_COLUMNS;
    }
    
}