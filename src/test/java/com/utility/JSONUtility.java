package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static Environment readJSON(Env env) {

		Gson gson = new Gson();
		FileReader fileReader = null;

		File jsonFile = new File(
				System.getProperty("user.dir") + File.separator + "config" + File.separator + "config.json");

		try {
			fileReader = new FileReader(jsonFile);
			System.out.println(jsonFile.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get("QA");
		return environment; 

	}
}
