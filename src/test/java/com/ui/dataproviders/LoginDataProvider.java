package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() {

		Gson gson = new Gson();

		File testDataFile = new File(
				System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "logindata.json");
		FileReader filereader = null;

		try {

			filereader = new FileReader(testDataFile);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		TestData testData = gson.fromJson(filereader, TestData.class);// Mapping logindata.json to TestData.class
		List<Object[]> dataToReturn = new ArrayList<Object[]>();

		for (User user : testData.getData()) {

			dataToReturn.add(new Object[] { user });
		}
		return dataToReturn.iterator();
	}

	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {

		return CSVReaderUtility.readCSVFile("loginData");
	}
	
	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {

		return ExcelReaderUtility.ReadExcelFile("LoginData");
	}
}
