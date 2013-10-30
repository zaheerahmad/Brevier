/**
 * 
 */
package com.android.brevier.Activity;

import java.util.List;
import java.util.Random;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.android.brevier.Service.QuizData;
import com.android.brevier.Service.TextParser;

/**
 * @author Zaheer Ahmad
 *
 */
public class QuizActivity extends SherlockFragmentActivity 
{
	RadioButton option1 = null;//(RadioButton)findViewById(R.quizActivity.option1);
	RadioButton option2 = null;//(RadioButton)findViewById(R.quizActivity.option2);
	RadioButton option3 = null;//(RadioButton)findViewById(R.quizActivity.option3);
	TextView timeText = null;
	TextView questionText = null;
	TextView questionNumberText = null;
	List<String> fileText = null;
	QuizData quizData = null;
	Random random = new Random();
	ProgressDialog progressDialog = null;
	ImageView optionResultImage = null;
	int questionNumber = 1;
	boolean isFirstGame = true;
	
	private long startTime = 0L;
	long timeInMilliseconds = 0L;
	long timeSwapBuff = 0L;
	long updatedTime = 0L;

	private Handler customHandler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.quiz_activity_layout);
		progressDialog = new ProgressDialog(this);
		option1 = (RadioButton)findViewById(R.id.quizActivity_option1);
		option2 = (RadioButton)findViewById(R.id.quizActivity_option2);
		option3 = (RadioButton)findViewById(R.id.quizActivity_option3);
		timeText = (TextView)findViewById(R.id.quizActivity_timeText);
		questionText = (TextView)findViewById(R.id.quizActivity_questionTextInWhite);
		optionResultImage = (ImageView)findViewById(R.id.quizActivity_optionResultImage);
		questionNumberText = (TextView)findViewById(R.id.quizActivity_questionNoText);
		Button stopBtn = (Button)findViewById(R.id.quizActivity_stopButton);
		
		final Runnable updateTimerThread = new Runnable() {

			public void run() {

				timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
				updatedTime = timeSwapBuff + timeInMilliseconds;
				int secs = (int) (updatedTime / 1000);
				int mins = secs / 60;
				secs = secs % 60;
				int milliseconds = (int) (updatedTime % 1000);
				timeText.setText("Time " + String.format("%02d", mins) + ":"
						+ String.format("%02d", secs));
				customHandler.postDelayed(this, 0);

			}

		};
		startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);   
		stopBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub	
				String time = timeText.getText().toString();
				time.replace("Time", "");
				String []timeArr = time.split(":");
				String hours = "0";
				String minutes = "00";
				String seconds = "00";
				if(timeArr.length > 3)
				{
					
				}
				else
				{
					minutes = timeArr[0].trim();
					seconds = timeArr[1].trim();
				}
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuizActivity.this);
				// set dialog message
				alertDialogBuilder
						.setMessage("Du hast in "+ minutes +" Minuten, "+ seconds +" Sekunden, "+ hours +" mal gut gegoethelt.")
						.setCancelable(false)
						.setPositiveButton("Weiter",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// if this button is clicked, close
										// current activity
										finish();
									}
								});
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
				// show it
				alertDialog.show();
				customHandler.removeCallbacks(updateTimerThread);
			}
		});
		
	  
		
		loadFileText();
		setNextQuizQuestion();		
	}
	
	public void loadFileText() {	
		fileText = TextParser.readFile(getAssets(),"4PraepAnschl.txt");		
	}
	
	public void setNextQuizQuestion() {		
		
		quizData = TextParser.splitData(fileText.get((random.nextInt(fileText
				.size() - 1) - 0) + 0));
		questionNumberText.setText("Q." + Integer.toString(questionNumber++));	
		questionText.setText(quizData.name);
		option1.setText(quizData.option1);
		option2.setText(quizData.option2);
		option3.setText(quizData.option3);		

	}

	public void showDialogBox(){
		progressDialog.setMessage("Uploading Next Question, Please Wait...");
		progressDialog.show();
		progressDialog.setCancelable(false);
	}
	public void checkUserAnswer(String selectedOption,String correctAnswer){
		
	}
	
	public void ToggleRadioButton(View view) 
	{
		
		boolean isNextQuestion = false;
		RadioButton radioButton = null;		
		String selectedOption = "";
		//progressDialog.setCancelable(false);
		switch (view.getId()) {
			case R.id.quizActivity_option1:
				checkRadioButton(option1);
				uncheckRadioButton(option2);
				uncheckRadioButton(option3);
			radioButton = (RadioButton) findViewById(view.getId());
			selectedOption = radioButton.getText().toString();
			if (selectedOption.equals(quizData.correctOption)) {
				optionResultImage.setImageResource(R.drawable.option_checkmark);
				showDialogBox();
				final Handler handler = new Handler();
				handler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						clearOption();
						setNextQuizQuestion();
					}
				}, 1000);
				
					
			}
			break;
			case R.id.quizActivity_option2:
				checkRadioButton(option2);
				uncheckRadioButton(option1);
				uncheckRadioButton(option3);
			radioButton = (RadioButton) findViewById(view.getId());
			selectedOption = radioButton.getText().toString();
			if (selectedOption.equals(quizData.correctOption)) {
				optionResultImage.setImageResource(R.drawable.option_checkmark);
				showDialogBox();
				final Handler handler = new Handler();
				handler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						clearOption();
						setNextQuizQuestion();
					}
				}, 1000);
				
			}
			break;
			case R.id.quizActivity_option3:
				checkRadioButton(option3);
				uncheckRadioButton(option2);
				uncheckRadioButton(option1);
			radioButton = (RadioButton) findViewById(view.getId());
			selectedOption = radioButton.getText().toString();
			if (selectedOption.equals(quizData.correctOption)) {
				optionResultImage.setImageResource(R.drawable.option_checkmark);
				showDialogBox();
				final Handler handler = new Handler();
				handler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						clearOption();
						setNextQuizQuestion();
					}
				}, 1000);
				
			}
			break;
		}

		if(isNextQuestion){
			clearOption();
		}		
	
	}
	
	public void clearOption() {
		uncheckRadioButton(option1);
		uncheckRadioButton(option2);
		uncheckRadioButton(option3);
		optionResultImage.setImageResource(-1);
		progressDialog.dismiss();			
	}
	
	public void uncheckRadioButton(RadioButton btn)
	{
		btn.setChecked(false);
		btn.setTextColor(Color.BLACK);
		btn.setTypeface(null, Typeface.NORMAL);
	}
	public void checkRadioButton(RadioButton btn)
	{
		btn.setTextColor(Color.BLUE);
		btn.setTypeface(null, Typeface.BOLD);
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
