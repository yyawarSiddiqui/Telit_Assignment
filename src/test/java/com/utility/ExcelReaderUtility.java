package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> ReadExcelFile(String filename) {

		File file = new File(
				System.getProperty("user.dir") + File.separator + "TestData" + File.separator + filename + ".xlsx");
		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator = null;
		List<User> userList = null;
		Row row;
		Cell Firstcell;
		Cell Secondcell;
		User user;

		try {

			xssfWorkbook = new XSSFWorkbook(file);
			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();
			userList = new ArrayList<User>();
			
			while (rowIterator.hasNext()) {

				row = rowIterator.next();
				Firstcell = row.getCell(0);
				Secondcell = row.getCell(1);

				
				user = new User(Firstcell.toString(), Secondcell.toString());
				userList.add(user);
				xssfWorkbook.close();
			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userList.iterator();
	}

}
