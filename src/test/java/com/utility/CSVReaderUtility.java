package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String FileName) {

		File file = new File(
				System.getProperty("user.dir") + File.separator + "TestData" + File.separator + FileName + ".csv");
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> UserList = null;
		User userdata;

		try {
			fileReader = new FileReader(file);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();
			UserList = new ArrayList<User>();

			while ((line = csvReader.readNext()) != null) {

				userdata = new User(line[0], line[1]);

				UserList.add(userdata);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (CsvValidationException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return UserList.iterator();
	}
}
