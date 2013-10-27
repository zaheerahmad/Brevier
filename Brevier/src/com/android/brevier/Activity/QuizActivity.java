/**
 * 
 */
package com.android.brevier.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Zaheer Ahmad
 *
 */
public class QuizActivity extends Activity 
{
	RadioButton option1 = null;//(RadioButton)findViewById(R.quizActivity.option1);
	RadioButton option2 = null;//(RadioButton)findViewById(R.quizActivity.option2);
	RadioButton option3 = null;//(RadioButton)findViewById(R.quizActivity.option3);
	TextView timeText = null;
	ProgressDialog progressDialog = null;
	ImageView optionResultImage = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.quiz_activity_layout);
		progressDialog = new ProgressDialog(this);
		option1 = (RadioButton)findViewById(R.id.quizActivity_option1);
		option2 = (RadioButton)findViewById(R.id.quizActivity_option2);
		option3 = (RadioButton)findViewById(R.id.quizActivity_option3);
		timeText = (TextView)findViewById(R.id.quizActivity_timeText);
		optionResultImage = (ImageView)findViewById(R.id.quizActivity_optionResultImage);
		Button stopBtn = (Button)findViewById(R.id.quizActivity_stopButton);
		stopBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub	
				String time = timeText.getText().toString();
				String []timeArr = time.split("\\:");
				String hours = "0";
				String minutes = "00";
				String seconds = "00";
				if(timeArr.length > 3)
				{
					
				}
				else
				{
					minutes = timeArr[1].trim();
					seconds = timeArr[2].trim();
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
			}
		});
	}
	
	public void ToggleRadioButton(View view) 
	{
		progressDialog.setMessage("Checking...");
		progressDialog.show();
		//progressDialog.setCancelable(false);
		switch (view.getId()) 
		{
			case R.id.quizActivity_option1:
				checkRadioButton(option1);
				uncheckRadioButton(option2);
				uncheckRadioButton(option3);
				optionResultImage.setImageResource(R.drawable.option_checkmark);
			break;
			case R.id.quizActivity_option2:
				checkRadioButton(option2);
				uncheckRadioButton(option1);
				uncheckRadioButton(option3);
				optionResultImage.setImageResource(-1);
			break;
			case R.id.quizActivity_option3:
				checkRadioButton(option3);
				uncheckRadioButton(option2);
				uncheckRadioButton(option1);
				optionResultImage.setImageResource(-1);
			break;
		}
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.brevier_main, menu);
		return true;
	}
}
