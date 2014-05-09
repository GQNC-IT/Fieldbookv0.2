package com.example.fieldbook;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DataCollection extends ActionBarActivity {

	
	Spinner spinner1;
	DatabaseHelper db;
	String dbName;
	String username;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		
		dbName = intent.getStringExtra("dbName");
		username = intent.getStringExtra("username");
		
				Toast.makeText(getApplicationContext(),
	                username, Toast.LENGTH_LONG)
	                .show();
		db = new DatabaseHelper(this, dbName);
		db.createTables();
		//db.createDummyProperties();
		
		
		
		
		
		setContentView(R.layout.fragment_data_collection);

		//Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);
		loadSpinnerData();
		//List<String> list = new ArrayList<String>();
		 
		 
		 
		
	}
	

	public void loadSpinnerData(){
		DatabaseHelper db = new DatabaseHelper(getApplicationContext(),dbName);
		
		List<String> labels = db.getAllLabelsProperty();
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);
		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);
		
		spinner1.setAdapter(dataAdapter);
		
	}
	
	public void cancel(View view){
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		
	}
	
	public void submit(View view){
		DatabaseHelper db = new DatabaseHelper (this);
		MySQLiteUserHelper db2 = new MySQLiteUserHelper(this);
		
		Spinner dropdown = (Spinner) findViewById(R.id.spinner2);
		EditText data = (EditText) findViewById(R.id.editText2);
		EditText value = (EditText) findViewById(R.id.editText1);
		
		String dropdownValue, dataValue, valueValue;
		dropdownValue = String.valueOf(dropdown.getSelectedItem());
		dataValue = data.getText().toString();
		valueValue = value.getText().toString();
		String validID = "";
		String[] validValues;
		String valuesValidation = "";
		boolean validCheck = false;
		int ratioCheck = 0;
		int[] ratioArray = new int[2];
		int parseValueInput = 1;
		
		Date date = new Date();
		
		try{//adding the new user info
	    	
	    	Log.i("TRACE", "umabot dito");
	    	int dataCount = db.countData() + 1;
	    	String userID = db2.getIDNoFromUsername(username);
	    	
	    	Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String dateString = formatter.format(date);
	    	
	    	validID = db.findValidationIDFromPMA(dropdownValue);
	    	validValues = db.getPossibleValues(validID);
	    	valuesValidation = db.findValidationType(validID);	
	    	
	    	if(valuesValidation.equals("categorical")){
	    		for(String singleCheck: validValues){
	    			if(singleCheck.equals(valueValue)){
	    				validCheck = true;
	    			}
	    		}
	    	}
	    	
	    	else if(valuesValidation.equals("ratio")){
	    		for(String singleCheck: validValues){
	    			if(ratioCheck == 0){
	    				ratioArray[0] = Integer.parseInt(singleCheck);
	    			}
	    			else if(ratioCheck > 0){
	    				ratioArray[1] = Integer.parseInt(singleCheck);
	    			}
	    			ratioCheck++;
	    		}
	    		parseValueInput = Integer.parseInt(valueValue);
	    	
	    		if(parseValueInput >= ratioArray[0] && parseValueInput <= ratioArray[1]){
	    			validCheck = true;
	    		}
	    		
	    	}
    	
	    	if(validCheck){
	    		db.insertIntoData(new Data(dataValue,dropdownValue,valueValue,userID,dateString,"a","b","c","1","0",dataCount));
	    		Toast.makeText(getApplicationContext(),
	                    "Data: " + dataValue + "\nProperty: " + dropdownValue + "\nValue: " + valueValue, Toast.LENGTH_LONG)
	                    .show();
	    	}
	    	else{
	    		Toast.makeText(getApplicationContext(),
	                    "Invalid value.", Toast.LENGTH_LONG)
	                    .show();
	    	}
	    	Log.i("TRACE", "please");
		}catch(Exception e){
	    	e.printStackTrace();
	    }
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.data_collection_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
		switch (item.getItemId()) {
		case R.id.action_share:
            //logout();
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
		
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_data_collection,
					container, false);
			return rootView;
		}
	}

}
