/**
 * 
 */
package com.android.brevier.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;

/**
 * @author Zaheer Ahmad
 *
 */
public class LearnQuoteActivity3 extends SherlockFragmentActivity {
	boolean isRadioButton1Selected = false;
	boolean isRadioButton2Selected = false;
	
	RadioButton rdBtn1 = null;
	RadioButton rdBtn2 = null;
	EditText firstDescription = null;
	EditText secondDescription = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_quote_activity_layout);
		
		rdBtn1 = (RadioButton)findViewById(R.id.learnQuoteActivityLayout_radioButton1);
		rdBtn2 = (RadioButton)findViewById(R.id.learnQuoteActivityLayout_radioButton2);
		
		firstDescription = (EditText)findViewById(R.id.learnQuoteActivityLayout_firstDescriptionText);
		secondDescription = (EditText)findViewById(R.id.learnQuoteActivityLayout_secondDescriptionText);
	}
	
	public void FetchResult(View view)
	{
		switch (view.getId()) 
		{
			case R.id.learnQuoteActivityLayout_radioButton1:
			
				if(isRadioButton1Selected)
				{
					isRadioButton1Selected = false;
					rdBtn1.setChecked(false);
					firstDescription.setText("");
				}
				else
				{
					isRadioButton1Selected = true;
					firstDescription.setText("This is dummy Text for Description 1...");
				}
			break;
			case R.id.learnQuoteActivityLayout_radioButton2:
				if(isRadioButton2Selected)
				{
					isRadioButton2Selected = false;
					rdBtn2.setChecked(false);
					secondDescription.setText("");
				}
				else
				{
					isRadioButton2Selected = true;
					secondDescription.setText("This is dummy Text for Description 2...");
				}
			break;
		}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    	 // First Menu Button
    	menu.add("Menu")
        .setOnMenuItemClickListener(this.MenuButtonHandler)
/*//                .setIcon(R.drawable.white_home) // Set the menu icon
*/                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        
        
        return super.onCreateOptionsMenu(menu);
    }
	
	OnMenuItemClickListener MenuButtonHandler = new OnMenuItemClickListener() {

		public boolean onMenuItemClick(MenuItem item) {

			// Create a simple toast message
			Toast.makeText(getApplicationContext(), "Going back to Menu", Toast.LENGTH_SHORT).show();
			finish();
			// Do something else
			return false;
		}
	};
}
