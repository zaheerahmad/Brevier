/**
 * 
 */
package com.android.brevier.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.res.AssetManager;

/**
 * @author khurram Farooq
 *
 */
public class TextParser {

	static public List<String> readFile(AssetManager am,String fileName) {
		List<String> returnString = null;
		try {
			InputStream is = am.open(fileName);
			returnString = new ArrayList<String>();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String stringLine = "";
			while ((stringLine = br.readLine()) != null) {
				returnString.add(stringLine);
			}
		} catch (Exception ex) {

		}
		return returnString;
	}
	
	public QuizData splitData(String randString) {
		QuizData returnData = null;
		String[] spliString;
		String[] option;
		try {
			if (randString != null) {
				spliString = randString.split(";");
				option = spliString[3].split("/");
				returnData = new QuizData();
				returnData.quizId = Integer.parseInt(spliString[0]);
				returnData.correctOption = spliString[1];
				returnData.name = spliString[2];
				returnData.option1 = option[0];
				returnData.option2 = option[1];
				returnData.option3 = option[2];
			}
		} catch (Exception ex) {

		}
		return returnData;
	}
	
	public LearnData splitDataLearnQuote1(String str){
		String []splitString;
		try{
			
		}
		catch(Exception ex){
			
		}
		return new LearnData();
	}
}
