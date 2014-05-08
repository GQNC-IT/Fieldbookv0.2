package com.example.fieldbook;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/*
 * A class file where the database was initialized and defined
 */
public class MySQLiteUserHelper extends SQLiteOpenHelper {

	// Database Version
    private static final int DATABASE_VERSION = 3;
    // Database Name
    private static final String DATABASE_NAME = "DataObjectDB.db";
    //Table Name
    private static final String TABLE_USER = "User";
    
    //For Database declaration
    private SQLiteDatabase db1;
    
    // User Table Column names
    private static final String USER_USERIDNO = "UserIDNo";
    private static final String USER_USERNAME = "Username";
    private static final String USER_PASSWORD = "Password";
    private static final String USER_FIRSTNAME = "FirstName";
    private static final String USER_MIDDLENAME = "MiddleName";
    private static final String USER_LASTNAME = "LastName";
    private static final String USER_ORGUNITID = "OrgUnitID";
    private static final String USER_SEQID = "SeqID";

    //Columns per table
    private static final String[] USER_COLUMNS = {USER_USERIDNO, USER_USERNAME, USER_PASSWORD, USER_FIRSTNAME, 
    											USER_MIDDLENAME, USER_LASTNAME, USER_ORGUNITID, USER_SEQID};
  
    public MySQLiteUserHelper(Context context) { // constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create User table
        String CREATE_USER_TABLE = "CREATE TABLE if not exists User ( " +
                " UserIDNo TEXT PRIMARY KEY, " + 
                " Username TEXT ,"+
                " Password TEXT ," +
                " FirstName TEXT ,"+
                " MiddleName TEXT ,"+
                " LastName TEXT ,"+
                " OrgUnitID TEXT ,"+
                " SeqID INTEGER"+
                " )";
  
        this.db1 = db; 
        // create all the tables
        db.execSQL(CREATE_USER_TABLE);
   
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS User");
        // create fresh user table
        this.onCreate(db);
    }
    
    public SQLiteDatabase getDB(){
    	return this.db1;
    }
    
    public int countUsers(){
     	 String selectQuery = "SELECT * FROM " + TABLE_USER;
       	 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor.getCount();
       	
       }
    
    public void addUser(User User){
        //for logging
    	Log.d("addUser", User.toString()); 

    	// 1. get reference to writable DB
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	Log.i("TRACE", "umabot dito");
    	// 2. create ContentValues to add key "column"/value
    	ContentValues values = new ContentValues();
		values.put(USER_USERIDNO, User.getUserIDNo());   
		values.put(USER_USERNAME, User.getUsername()); 
		values.put(USER_PASSWORD, User.getPassword());  
		values.put(USER_FIRSTNAME, User.getFirstName()); 
		values.put(USER_MIDDLENAME, User.getMiddleName()); 
		values.put(USER_LASTNAME, User.getLastName());  
		values.put(USER_ORGUNITID, User.getOrgUnitID());
		
		int numberUsers = countUsers() + 1;
		values.put(USER_SEQID, numberUsers);
		
		// 3. insert
		db.insert(TABLE_USER, // table
		        null, //nullColumnHack
		        values); // key/value -> keys = column names/ values = column values
		
		// 4. close
		db.close(); 
    	}
    
    public User getUser(String SeqID){
    	 
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
     
        // 2. build query
        Cursor cursor = 
                db.query(TABLE_USER, // a. table
                USER_COLUMNS, // b. column names
                " SeqID = ?", // c. selections 
                new String[] { String.valueOf(SeqID) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
     
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build user object
        User User = new User();
        
        User.setUserIDNo(cursor.getString(0));
        User.setUsername(cursor.getString(1));
        User.setPassword(cursor.getString(2));
        User.setFirstName(cursor.getString(3));
        User.setMiddleName(cursor.getString(4));
        User.setLastName(cursor.getString(5));
        User.setOrgUnitID(cursor.getString(6));
      //  User.setSeqID(Integer.parseInt(cursor.getString(7)));
        
        //log 
        Log.d("getUser("+SeqID+")", User.toString());
     
        // 5. return User
        return User;
    }
    
    public List<User> getAllUsers() {
        List<User> Users = new LinkedList<User>();
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_USER;
  
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
  
        // 3. go over each row, build user and add it to list
        User User = null;
        if (cursor.moveToFirst()) {
            do {
            	User = new User();
            	
            	User.setUserIDNo(cursor.getString(0));
                User.setUsername(cursor.getString(1));
                User.setPassword(cursor.getString(2));
                User.setFirstName(cursor.getString(3));
                User.setMiddleName(cursor.getString(4));
                User.setLastName(cursor.getString(5));
                User.setOrgUnitID(cursor.getString(6));
           //     User.setSeqID(Integer.parseInt(cursor.getString(7)));
  
                // Add user to users
                Users.add(User);
            } while (cursor.moveToNext());
        }
  
        Log.d("getAllUsers()", User.toString()); //logcat
  
        // return Users
        return Users;
    }
    
    public int updateUser(User User) {
    	 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
     
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
		values.put("UserIDNo", User.getUserIDNo());   
		values.put("Username", User.getUsername()); 
		values.put("Password", User.getPassword());  
		values.put("FirstName", User.getFirstName()); 
		values.put("MiddleName", User.getMiddleName()); 
		values.put("LastName", User.getLastName());  
		values.put("OrgUnitID", User.getOrgUnitID());
		
        // 3. updating row
        int i = db.update(TABLE_USER, //table
                values, // column/value
                USER_SEQID+" = ?", // selections
                new String[] { String.valueOf(User.getSeqID()) }); //selection args
     
        // 4. close
        db.close();
     
        return i;
    }
    
    public void deleteUser(User User) {
    	 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_USER, //table name
                USER_SEQID+ " = ?",  // selections
                new String[] { String.valueOf(User.getSeqID()) }); //selections args
 
        // 3. close
        db.close();
 
        //log
        Log.d("deleteUser", User.toString());
    }
    
    public boolean Login(String Username, String Password) throws SQLException{ // validation if the user input a valid account
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE Username = ? AND Password = ?", new String[]{Username, Password});
    		if (mCursor != null) {
    			if(mCursor.getCount() > 0){
    				mCursor.close();
    				return true;
    			}
    		}
    		mCursor.close();
    		return false;
    }
    
    public String getIDNoFromUsername(String username1){
    	SQLiteDatabase db = this.getWritableDatabase();
    	String returnvalue = "";
    	Cursor uCursor = db.rawQuery("SELECT * from " + TABLE_USER + " WHERE Username = ?", new String[]{username1});
    	if(uCursor != null){
    		if (uCursor.moveToFirst()) {
       		 do {
       			 returnvalue = uCursor.getString(7);
       		 } while (uCursor.moveToNext());
       	 }
    		
    	}
    	uCursor.close();
    	return returnvalue;
    }
    public String getTableName(){
    	return TABLE_USER;
    }
    
    public String getDatabaseName(){
    	return DATABASE_NAME;
    }
    
    public String[] getColHeads(){
    	return USER_COLUMNS;
    }
    
}