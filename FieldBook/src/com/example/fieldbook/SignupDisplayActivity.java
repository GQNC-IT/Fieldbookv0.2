/*
 * Activity after the signup link where user can input the fields
 */
package com.example.fieldbook;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SignupDisplayActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		MySQLiteUserHelper db = new MySQLiteUserHelper(this); // database
		
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		//catches the field inputs
	    String Username = intent.getStringExtra("Username");
	    String Password = intent.getStringExtra("Password");
	    String UserIDNo = intent.getStringExtra("UserIDNo");
	    String FirstName = intent.getStringExtra("FirstName");
	    String MiddleName = intent.getStringExtra("MiddleName");
	    String LastName = intent.getStringExtra("LastName");
	    String OrgUnitID = intent.getStringExtra("OrgUnitID");

	    //setting the display style
	    TextView textView = new TextView(this);
	    textView.setTextSize(11);
	    
	    try{//adding the new user info
	    	
	    	Log.i("TRACE", "umabot dito");
	    	
	    	db.addUser(new User(UserIDNo, Username, Password, FirstName, MiddleName, LastName, OrgUnitID,1));
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	  
        // get all users
        List<User> a = db.getAllUsers();
        String b = a.toString();
        textView.setText(b);
            
	    setContentView(textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signup_display, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
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
			View rootView = inflater.inflate(R.layout.fragment_signup_display,
					container, false);
			return rootView;
		}
	}
}