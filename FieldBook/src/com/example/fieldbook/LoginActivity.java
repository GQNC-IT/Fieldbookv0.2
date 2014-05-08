/*
 * The activity executed after the user clicked/tapped the login button
 */

package com.example.fieldbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
  
public class LoginActivity extends ActionBarActivity {
	
	private static final int DISCOVER_DURATION = 300;
	private static final int REQUEST_BLU = 1;
	public File fp = new File(Environment.getExternalStorageDirectory().getPath() + "/excelfiles", "sampleDB.xls");
	String[] databaseNames;
	static Context context;
	
	boolean inTry;
	 FileInputStream fis;
	List<Map<String,String>> data = new ArrayList<Map<String,String>>();
	Map<String, String> datum = new HashMap<String, String>(2);
	
	ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
	private SimpleAdapter sa;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_login);
		context = this;
		loadActivity();
		
		
		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
	}

	public void loadActivity(){
		
		File dir = new File("data/data/com.example.fieldbook/fieldbooks"); //Not dynamic yet
		if(!(dir.isDirectory())){
			dir.mkdirs();
			File dir2 = new File("data/data/com.example.fieldbook/fieldbooks/Fieldbook 1.db");
			try {
				dir2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		File[] filelist = dir.listFiles();
		String[] namesOfFiles = new String[filelist.length];
		this.databaseNames =  new String[filelist.length];
		String temp1;
		
		HashMap<String,String> item;

		
		String md5 = "";
		
		for (int i = 0; i < namesOfFiles.length; i++) {
			   temp1 = filelist[i].getName();
			   databaseNames[i] = filelist[i].getName();
			  
			  
			try {
				fis = new FileInputStream(new File("data/data/com.example.fieldbook/fieldbooks" + "/" + temp1));
				md5 = new String(Hex.encodeHex(DigestUtils.md5(temp1)));
				inTry = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			   
			   namesOfFiles[i] = temp1.replaceAll(".db$","");
			  // if(inTry){
			//	   namesOfFiles[i] = namesOfFiles[i] + "\n" + md5;
			  // }
			   
			   item = new HashMap<String,String>();
			   item.put( "line1", namesOfFiles[i]);
			   item.put( "line2", md5);
			   list.add( item );

			   
			   
			   inTry = false;
			   //datum.put("First Line",namesOfFiles[i]);
			   //datum.put("Second Line",md5);
			   //data.add(datum);
		}
		
		
		final ListView listView = (ListView) findViewById(R.id.listView1);
		
		sa = new SimpleAdapter(this, list,
		R.layout.listview_twolines,
		new String[] { "line1","line2" },
		new int[] {R.id.line_a, R.id.line_b});
		listView.setAdapter( sa );
		
		listView.setOnItemClickListener(new OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id){
			Toast.makeText(getApplicationContext(),
	                 "Item clicked", Toast.LENGTH_LONG)
	                 .show();
			goDataCollection();
			}
	
		});
		
		
		
		 listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			 
           //  @Override
             public boolean onItemLongClick(AdapterView<?> parent, View view,
                int position, long id) {
             TextView textView = (TextView) view.findViewById(R.id.line_a);
             String itemValue = (String) textView.getText();
             //String  itemValue    = (String) listView.getItemAtPosition(position);
                 
               // Show Alert 
              
              renamePrompt(itemValue);
              
              return true;
            
             }

        }); 
		
	}
	
	
	public void goDataCollection(){
		Intent intent = new Intent(this, DataCollection.class);
		startActivity(intent);
		
	}
	
	public void logOut(){
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	public void renamePrompt(final String oldstring){
		Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Rename Database");
		builder.setMessage("Name: ");
		
		final EditText input = new EditText(this);
		builder.setView(input);
		
		builder.setPositiveButton("Rename", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			  String value = input.getText().toString();
			  reNaming(oldstring,value);
			  // Do something with value!
			  }
			});
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
		//loadActivity();
		
	}
	
	public void reNaming(String oldstring, String newstring){
		File file = new File("data/data/com.example.fieldbook/fieldbooks/" + oldstring + ".db");
		File file2 = new File("data/data/com.example.fieldbook/fieldbooks/" + newstring + ".db");
		boolean success = file.renameTo(file2);
		if(success){
			Toast.makeText(getApplicationContext(),
	                 "Sucessfully changed name from " + oldstring + " to " + newstring, Toast.LENGTH_LONG)
	                 .show();
		}
		finish();
		reappear();
		//loadActivity();
		
	}
	
	public void createNew(View view){
		Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Create New Database");
		builder.setMessage("Name: ");
		
		final EditText input = new EditText(this);
		builder.setView(input);
		
		builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			  String value = input.getText().toString();
			  File file = new File("data/data/com.example.fieldbook/fieldbooks/" + value + ".db");
			  try {
				if (file.createNewFile()){
				        System.out.println("File is created!");
				        finish();
						reappear();
				      }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  // Do something with value!
			  }
			});
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
		//loadActivity();
		
		
	}
	
	public void generateXLS(View view){
		
		String sdCard = Environment.getExternalStorageDirectory().getPath();
		File directory = new File (sdCard + "/excelfiles");
		
		Log.i("Excel",sdCard+ "/excelfiles");
		
		directory.mkdirs();
		
		
		final String [] items = this.databaseNames;
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("Which to share?");
		
		builder.setItems(items, new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				String sdCard = Environment.getExternalStorageDirectory().getPath();
				File directory = new File (sdCard + "/BTFiles");	
				String extended = databaseNames[which];
				String[] filename = extended.split(".");
				fileSetter(directory, filename[0]+".xls");
				Toast.makeText(null, "File set", Toast.LENGTH_SHORT).show();
			}
		});

		builder.show();
		
		MySQLiteUserHelper dbHelper = new MySQLiteUserHelper(this);
		SQLiteDatabase db = openOrCreateDatabase("puta.db", MODE_PRIVATE, null);
		Cursor cursor = db.rawQuery("select * from users", null);
		//	int rowCount = cursor.getCount();
		if(cursor != null)
			cursor.moveToFirst();
		
		String[] colHeads = dbHelper.getColHeads(); 
		
		
		try{
			WritableWorkbook workbook = Workbook.createWorkbook(this.fp);
			WritableSheet worksheet = workbook.createSheet("users", 0);
			int colCount = cursor.getColumnCount();
			for(int i = 0; i < colCount; i++){
				Label label = new Label(i, 0, colHeads[i]);
				worksheet.addCell(label);
			}
			
			int rows = 0;
			cursor.moveToFirst();
			while(cursor.isAfterLast() == false){
				rows++;
				for(int i = 0; i < colCount; i++){
					Label label = new Label(i, rows, cursor.getString(i));
					
					worksheet.addCell(label);
				}
				cursor.moveToNext();
			}
			
			
			cursor.close();
			workbook.write();
			workbook.close();
			Toast toast = Toast.makeText(getApplicationContext(), "Excel file has been made", Toast.LENGTH_SHORT);
			toast.show();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void generateTSV(View view){

		String sdCard = Environment.getExternalStorageDirectory().getPath();
		File directory = new File (sdCard + "/tsvfiles");
		
		Log.i("Excel",sdCard+ "/tsvfiles");
		
		directory.mkdirs();
		
		final String [] items = this.databaseNames;
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("Which to share?");
		
		builder.setItems(items, new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				String sdCard = Environment.getExternalStorageDirectory().getPath();
				File directory = new File (sdCard + "/BTFiles");		
				String extended = databaseNames[which];
				String[] filename = extended.split(".");
				fileSetter(directory, filename[0]+".tsv");
				Toast.makeText(null, "File set", Toast.LENGTH_SHORT).show();
			}
		});

		builder.show();
		
		MySQLiteUserHelper dbHelper = new MySQLiteUserHelper(this);
		SQLiteDatabase db = openOrCreateDatabase(fp.getName(), MODE_PRIVATE, null);
		Cursor cursor = db.rawQuery("select * from users", null);
//		int rowCount = cursor.getCount();
		if(cursor != null)
			cursor.moveToFirst();
		
		String[] colHeads = dbHelper.getColHeads(); 
				
		try{
			File tsvFile = this.fp;
			BufferedWriter bw = new BufferedWriter(new FileWriter(tsvFile));
			
			int colCount = cursor.getColumnCount();
			for(int i = 0; i < colCount; i++){
				bw.write(colHeads[i]+"\t");
			}
			bw.write("\n");
			cursor.moveToFirst();
			while(cursor.isAfterLast() == false){
				for(int i = 0; i < colCount; i++){
					bw.write(cursor.getString(i)+"\t");
				}
				bw.write("\n");
				cursor.moveToNext();
			}
			cursor.close();
			bw.flush();
			bw.close();
			
			Toast toast = Toast.makeText(getApplicationContext(), "TSV File made", Toast.LENGTH_SHORT);
			toast.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void fileSetter(File directory, String filename){
		this.fp = new File(directory, filename); 
	}
	
	public void transferBT(View view){
		BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
		if (btAdapter == null) {
			Toast.makeText(this, "Bluetooth is not supported", Toast.LENGTH_LONG).show();
		}
		else{
			// bring up Android chooser
			
			
			final String [] items=new String []{"Excel","Tab Separated File", "Database File"};
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setTitle("Which to share?");
			
			builder.setItems(items, new OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				String sdCard = Environment.getExternalStorageDirectory().getPath();
				File directory = new File (sdCard + "/BTFiles");		
				
				if(which == 0){
					fileSetter(directory, "ExcelFile-0.1.xls");
				}
				else if(which == 1){
					fileSetter(directory, "TSVFile-0.1.tsv");
				}
				else if(which == 2){
					fileSetter(directory, "Fieldbook 1.db");
				}
			}
			});

			builder.show();
			
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_SEND);
			intent.setType("application/pdf");
			intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(fp));
			//...
			//list of apps that can handle our intent
			PackageManager pm = getPackageManager();
			List<ResolveInfo> appsList = pm.queryIntentActivities(intent, 0);
			if(appsList.size() > 0) {
			// proceed
				//select bluetooth
				String packageName = null;
				String className = null;
				boolean found = false;
				for(ResolveInfo info: appsList){
					packageName = info.activityInfo.packageName;
					Toast.makeText(this, packageName, Toast.LENGTH_SHORT).show();
					if(packageName.equals("com.mediatek.bluetooth") || packageName.equals("com.android.bluetooth")){
						className = info.activityInfo.name;
						found = true;
						break;// found
					}
				}
				if(!found){
					Toast.makeText(this, "Apps not found",Toast.LENGTH_SHORT).show();
					//enableBlu();
				}
				else{
					Toast.makeText(this, "Starting intent...", Toast.LENGTH_LONG).show();
					intent.setClassName(packageName, className);
					startActivity(intent);
					/*
					ContentValues values = new ContentValues();
					values.put(BluetoothShare.URI, "content://"+Uri.fromFile(file));
					values.put(BluetoothShare.DESTINATION, value);
					*/
					
				}
			}
			else{
				Toast.makeText(this, "Applist empty", Toast.LENGTH_SHORT).show();
				Toast.makeText(this, "Sharing terminated", Toast.LENGTH_LONG).show();
			}
			
		}
	}
	
	public void enableBlu(){
		// enable device discovery - this will automatically enable Bluetooth
		Intent discoveryIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
		discoveryIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, DISCOVER_DURATION);
		startActivityForResult(discoveryIntent, REQUEST_BLU);
	}
	
	protected void onActivityResult (int requestCode, int resultCode, Intent data) {
		if (resultCode == DISCOVER_DURATION	&& requestCode == REQUEST_BLU) {
			// processing code goes here
			Toast.makeText(this, "SENDING FILE", Toast.LENGTH_SHORT).show();
		}
		else{ // cancelled or error
			Toast.makeText(this, "Sharing cancelled", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void sendEmail(View view){
		//Intent emailIntent = new Intent(this, EmailActivity.class);
		//startActivity(emailIntent);
		final Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setData(Uri.parse("mailto:"));
		emailIntent.setType("text/plain");
		AlertDialog.Builder popUp1 = new AlertDialog.Builder(this);
		LayoutInflater inflater = this.getLayoutInflater();
		popUp1.setView(inflater.inflate(R.layout.pop_up_layout, null));
		popUp1.setPositiveButton("Send", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
//	        	   EditText toET = (EditText) findViewById(R.id.to);
	        	   //String to = toET.getText().toString();
	        	   //String from = findViewById(R.id.from).toString();	// to be fetched from user db as user's eadd
/*	        	   
	        	   MySQLiteUserHelper dbHelper = new MySQLiteUserHelper(LoginActivity.context);
	        	   SQLiteDatabase db = openOrCreateDatabase("puta.db", MODE_PRIVATE, null);
	        	   Cursor cursor = db.rawQuery("select * from users", null);
*/	        	   
	        	   String from = "jeobmallari@gmail.com";
//	        	   EditText bodyET = (EditText) findViewById(R.id.body);
	        	   //String body = bodyET.getText().toString();
	        	   String body = "";	// email body
//	        	   EditText subjET = (EditText) findViewById(R.id.subject);
	        	   //String subject = subjET.getText().toString();
	        	   String subject = "";			// email subject
	               emailIntent.putExtra(Intent.EXTRA_EMAIL, from);
	               emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
	               emailIntent.putExtra(Intent.EXTRA_TEXT, body);
	               
	               try{
	            	   startActivity(Intent.createChooser(emailIntent, "Choose an option:"));
	            	   finish();
	            	   Log.i("Finished sending Email.", "");
	               }catch(ActivityNotFoundException e){
	            	   Toast.makeText(null, "Cannot find installed email client", Toast.LENGTH_SHORT).show();
	               }catch(Exception e){
	            	   Toast.makeText(null, "Some other error occured", Toast.LENGTH_SHORT).show();
	               }
	           }
	       });
		popUp1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	               // User cancelled the dialog
	           }
	       });
		AlertDialog alertDialog = popUp1.create();
		alertDialog.show();
	}
	
	public void reappear(){
		Intent intent = new Intent(this,LoginActivity.class);
		startActivity(intent);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.login, menu);
		//return true;
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
	//	int id = item.getItemId();
		switch (item.getItemId()) {
		case R.id.action_share:
			final String [] items=new String []{"Excel","Tab Separated File", "Bluetooth", "Email"};
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setTitle("Items alert");

			builder.setItems(items, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
				if(which == 0){
					generateXLS(new View(getApplicationContext()));
				}
				else if(which == 1){
					generateTSV(new View(getApplicationContext()));
				}
				else if(which == 2){
					transferBT(new View(getApplicationContext()));
				}
				else if(which == 3){
					sendEmail(new View(getApplicationContext()));
				}
			}
			});

			builder.show();
            return true;
		case R.id.action_import_export:
            //logout();
            return true;
        case R.id.action_logout:
            logOut();
            return true;
        case R.id.action_settings:
            //openSettings();
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
			View rootView = inflater.inflate(R.layout.fragment_login,
					container, false);
			return rootView;
		}
	}

}
