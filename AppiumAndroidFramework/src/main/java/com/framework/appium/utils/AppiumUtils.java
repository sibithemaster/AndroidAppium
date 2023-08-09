package com.framework.appium.utils;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppiumUtils{


	public List<HashMap<String,String>> gettingJsonData(String jsonfilePath) throws IOException
	{
		
		String jsonContent=FileUtils.readFileToString(new File(jsonfilePath));
		
		ObjectMapper mapper = new  ObjectMapper();
		List<HashMap<String,String>> jsonData=mapper.readValue(jsonContent, 
				new TypeReference<List<HashMap<String,String>>>() {
				});
		return jsonData;
		
	}
	
	
}
