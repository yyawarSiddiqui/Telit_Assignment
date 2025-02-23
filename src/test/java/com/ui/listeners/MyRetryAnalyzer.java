package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	// private final static int MAX_No_OF_ATTEMPTS = Integer
	// .parseInt(PropertiesUtil.ReadProperties(Env.QA, "MAX_No_OF_ATTEMPTS"));

	private final static int MAX_No_OF_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_No_OF_ATTEMPTS();
	private static int Current_Attempt = 1;

	public boolean retry(ITestResult result) {

		if (Current_Attempt <= MAX_No_OF_ATTEMPTS) {

			Current_Attempt++;
			return true;
		}
		return false;
	}

}
