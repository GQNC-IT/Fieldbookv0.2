package com.example.fieldbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DataCollection extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_data_collection);

		
	}
	
	public void cancel(View view){
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		
	}
	
	public void submit(View view){
		Spinner dropdown = (Spinner) findViewById(R.id.spinner2);
		EditText data = (EditText) findViewById(R.id.editText2);
		EditText value = (EditText) findViewById(R.id.editText1);
		
		String dropdownValue, dataValue, valueValue;
		dropdownValue = String.valueOf(dropdown.getSelectedItem());
		dataValue = data.getText().toString();
		valueValue = value.getText().toString();
		
		Toast.makeText(getApplicationContext(),
                "Data: " + dataValue + "\nProperty: " + dropdownValue + "\nValue: " + valueValue, Toast.LENGTH_LONG)
                .show();
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
