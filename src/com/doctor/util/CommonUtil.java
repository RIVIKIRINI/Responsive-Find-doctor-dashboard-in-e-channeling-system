package com.doctor.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class CommonUtil {

	public static final Properties properties = new Properties();
	
	static  {
		
		try {
			
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		}catch(IOException e){
			System.out.println(e.getMessage());
			
		}
	}
	 public static String generateDoctorIds(ArrayList<String>ids) {
	    	
	    	String id;
	    	
	    	int next = ids.size();
	    	
	    	id = CommonConstants.DOCTOR_ID_PREFIX + next;
	    	
	    	if(ids.contains(id)) {
	    		
	    		next ++;
	    		
	    		id = CommonConstants.DOCTOR_ID_PREFIX + next;
	    		
	    	}
	    	return id;
	    }
}
