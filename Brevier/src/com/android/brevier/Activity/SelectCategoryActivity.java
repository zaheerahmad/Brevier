/**
 * 
 */
package com.android.brevier.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * @author Zaheer Ahmad
 *
 */
public class SelectCategoryActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectcategoryactivity_layout);
		
		Button startQuiz = (Button)findViewById(R.id.selectCategoryActivityLayout_btnStartQuiz);
		startQuiz.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SelectCategoryActivity.this, QuizActivity.class);
				startActivity(intent);
				
			}
		});
		
		Button learnQuoteBtn1 = (Button)findViewById(R.id.selectCategoryActivityLayout_btnCategoryLearn1);
		learnQuoteBtn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SelectCategoryActivity.this, LearnQuoteActivity1.class);
				startActivity(intent);
				
			}
		});
		
		Button learnQuoteBtn2 = (Button)findViewById(R.id.selectCategoryActivityLayout_btnCategoryLearn2);
		learnQuoteBtn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SelectCategoryActivity.this, LearnQuoteActivity2.class);
				startActivity(intent);
				
			}
		});
		
		Button learnQuoteBtn3 = (Button)findViewById(R.id.selectCategoryActivityLayout_btnCategoryLearn3);
		learnQuoteBtn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SelectCategoryActivity.this, LearnQuoteActivity3.class);
				startActivity(intent);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.brevier_main, menu);
		return true;
	}

}
