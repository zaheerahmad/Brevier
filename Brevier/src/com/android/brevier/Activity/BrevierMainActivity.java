package com.android.brevier.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class BrevierMainActivity extends SherlockFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brevier_activity_main_layout);
		/*ActionBar ab = getSupportActionBar();
		ab.setDisplayHomeAsUpEnabled(true);*/
		
		Button btnStart = (Button)findViewById(R.mainActivityLayout.StartButton);
		
		btnStart.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(BrevierMainActivity.this, SelectCategoryActivity.class);
				startActivity(intent);
			}
		});
	}

	/*@Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    	 // First Menu Button
    	menu.add("Home")
        .setOnMenuItemClickListener(this.HomeButtonHandler)
                .setIcon(R.drawable.white_home) // Set the menu icon
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        
        menu.add("More")
		.setOnMenuItemClickListener(this.DebugButtonHandler)
		.setIcon(R.drawable.info) // Set the menu icon
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        
        menu.add("Settings")
		.setOnMenuItemClickListener(this.SettingButtonHandler)
		.setIcon(R.drawable.settings) // Set the menu icon
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        
        
        menu.add("Refresh")
		.setOnMenuItemClickListener(this.RefreshButtonHandler)
        .setIcon(R.drawable.refresh) // Set the menu icon
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        
        return super.onCreateOptionsMenu(menu);
    }
    
    OnMenuItemClickListener RefreshButtonHandler = new OnMenuItemClickListener() {

		public boolean onMenuItemClick(MenuItem item) {

			// Create a simple toast message
			Constants.showToast(getApplicationContext(), "Refresh Button", Constants.TOAST_TYPE_DEBUG);
			Intent dataServiceIntent = new Intent(MainActivity.this, DataService.class);
			dataServiceIntent.putExtra(DataService.DATA_TRAN_TYPE,Constants.TranTypes.MANUAL);
			startService(dataServiceIntent);
			// Do something else
			return false;
		}
	};
	
	OnMenuItemClickListener DebugButtonHandler = new OnMenuItemClickListener() {

		public boolean onMenuItemClick(MenuItem item) {

			// Create a simple toast message
			Constants.showToast(getApplicationContext(), "More Button", Constants.TOAST_TYPE_DEBUG);
			Intent debugActivityIntent = new Intent(MainActivity.this, DebugActivity.class);			
			startActivity(debugActivityIntent);
			// Do something else
			return false;
		}
	};
	
	OnMenuItemClickListener HomeButtonHandler = new OnMenuItemClickListener() {

		public boolean onMenuItemClick(MenuItem item) {

			// Create a simple toast message
			Constants.showToast(getApplicationContext(), "Home Button", Constants.TOAST_TYPE_DEBUG);
			try {
				new GetFAQs(MainActivity.this, RequestType.GetFAQs, "4G", getApplicationContext()).execute().get(15, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	};
	
	OnMenuItemClickListener SettingButtonHandler = new OnMenuItemClickListener() {

		public boolean onMenuItemClick(MenuItem item) {

			// Create a simple toast message
			Constants.showToast(getApplicationContext(), "Setting Button", Constants.TOAST_TYPE_DEBUG);
			Intent debugActivityIntent = new Intent(MainActivity.this, SettingActivity.class);			
			startActivity(debugActivityIntent);
			// Do something else
			return false;
		}
	};
*/
}
