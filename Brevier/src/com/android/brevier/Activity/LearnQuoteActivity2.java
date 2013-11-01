/**
 * 
 */
package com.android.brevier.Activity;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.android.brevier.Service.LearnData;
import com.android.brevier.Service.TextParser;


/**
 * @author Zaheer Ahmad
 *
 */
public class LearnQuoteActivity2 extends SherlockFragmentActivity 
{
	boolean isRadioButton1Selected = false;
	boolean isRadioButton2Selected = false;
	
	RadioButton rdBtn1 = null;
	RadioButton rdBtn2 = null;
	ImageButton nextButton = null;
	ImageButton prevButton = null;
	EditText firstDescription = null;
	EditText secondDescription = null;
	TextView subTitle = null;
	List<String> fileStrings = null;
	int learnCounter = 0;
	LearnData learnData = null;
	int quoteSize = 0;
	int currentSizeFileString = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_quote_activity_layout);
		
		rdBtn1 = (RadioButton)findViewById(R.id.learnQuoteActivityLayout_radioButton1);
		rdBtn2 = (RadioButton)findViewById(R.id.learnQuoteActivityLayout_radioButton2);
		subTitle = (TextView)findViewById(R.id.learnQuoteActivityLayout_subtitleTextView);
		firstDescription = (EditText)findViewById(R.id.learnQuoteActivityLayout_firstDescriptionText);
		secondDescription = (EditText)findViewById(R.id.learnQuoteActivityLayout_secondDescriptionText);	
		nextButton = (ImageButton)findViewById(R.id.learnQuoteActivityLayout_nextButton);
		prevButton = (ImageButton)findViewById(R.id.learnQuoteActivityLayout_previousButton);
		
		nextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				clearOption();
				setNextQuote();
			}
		});
		
		prevButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				clearOption();
				setPreviousQuote();
			}
		});				
		
		fileStrings = TextParser.readFile(getAssets(), "2ReiferGoethe.txt");
		quoteSize = fileStrings.size();		
		setFirstQuote();
		nextButton.setVisibility(View.VISIBLE);
		prevButton.setVisibility(View.INVISIBLE);
		
	}
	
	public void setFirstQuote(){		
		learnData = TextParser.splitDataLearnQuote1(fileStrings.get(learnCounter));
		subTitle.setText(learnData.subtitle);		
		rdBtn1.setChecked(true);
		firstDescription.setText(learnData.firstDisplayText);
	}
	
	public void updateCurrentFileStringCounter(){
		currentSizeFileString = learnCounter;
	}
	
	public void checkVisibleButton(int count){
		boolean isPrev = true;
		boolean isNext = true;
		if(count == 0){
			prevButton.setVisibility(View.INVISIBLE);
			isPrev = false;
		}		
		else if(count == (fileStrings.size() - 1)){
			nextButton.setVisibility(View.INVISIBLE);
			isNext = false;
		}
		
		if(isPrev){
			prevButton.setVisibility(View.VISIBLE);
		}
		
		if(isNext){
			nextButton.setVisibility(View.VISIBLE);
		}
	}
	
	public void setNextQuote() {
		if (learnCounter < fileStrings.size()) {
			if((learnCounter) < (fileStrings.size() - 1)){
				learnCounter = learnCounter + 1;
			}
			checkVisibleButton(learnCounter);
			learnData = TextParser.splitDataLearnQuote1(fileStrings
					.get(learnCounter));			
		}
		subTitle.setText(learnData.subtitle);
		rdBtn1.setChecked(true);
		firstDescription.setText(learnData.firstDisplayText);
	}
	
	public void setPreviousQuote() {
		if (learnCounter >= 0) {
			if((learnCounter - 1) >= 0){
				learnCounter = learnCounter - 1;
			}
			checkVisibleButton(learnCounter);
			learnData = TextParser.splitDataLearnQuote1(fileStrings
					.get(learnCounter));
			
		}
		subTitle.setText(learnData.subtitle);
		rdBtn1.setChecked(true);
		firstDescription.setText(learnData.firstDisplayText);
	}
	
	public void clearOption(){
		firstDescription.setText("");
		secondDescription.setText("");
		rdBtn1.setChecked(false);
		rdBtn2.setChecked(false);
		isRadioButton1Selected = false;
		isRadioButton2Selected = false;
	}
	
	public void FetchResult(View view)
	{
		switch (view.getId()) 
		{
			case R.id.learnQuoteActivityLayout_radioButton1:
				rdBtn1.setChecked(true);
				firstDescription.setText(learnData.firstDisplayText);
			break;
			case R.id.learnQuoteActivityLayout_radioButton2:
				rdBtn2.setChecked(true);
				secondDescription.setText(learnData.secondDisplayText);
			break;
		}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    	 // First Menu Button
    	menu.add("MENÜ")
        .setOnMenuItemClickListener(this.MenuButtonHandler)
/*//                .setIcon(R.drawable.white_home) // Set the menu icon
*/                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        
        
        return super.onCreateOptionsMenu(menu);
    }
	
	OnMenuItemClickListener MenuButtonHandler = new OnMenuItemClickListener() {

		public boolean onMenuItemClick(MenuItem item) {

			// Create a simple toast message
			//Toast.makeText(getApplicationContext(), "Going back to Menu", Toast.LENGTH_SHORT).show();
			finish();
			// Do something else
			return false;
		}
	};

}
