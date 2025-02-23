package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	// Read properties file//

	public static String ReadProperties(Env env, String PropertyName) {

		Properties properties = new Properties();
		File PropFile = new File(
				System.getProperty("user.dir") + File.separator + "config" + File.separator + "" + env + ".properties");

		try {

			FileReader fileReader = new FileReader(PropFile);

			properties.load(fileReader);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Value = properties.getProperty(PropertyName.toUpperCase());
		return Value;
	}

}
