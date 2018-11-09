package com.andromeda.casediary.utility;

import com.google.gson.Gson;

public class CommonUtilities {
	private static Gson gson= new Gson();
	public static <T> T jsonToObjectMapper(String jsonString,Class<T> classType) {
		if (jsonString == null || classType == null)
        {
            return null;
        }
		
		return gson.fromJson(jsonString, classType);
		
	}
	
	public static String ObjectToJsonString(Object o) {
		 if (o == null)
	        {
	            return null;
	        }
		 
		 return gson.toJson(o);
	}
}
