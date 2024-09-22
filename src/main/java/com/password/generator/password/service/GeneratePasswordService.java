package com.password.generator.password.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class GeneratePasswordService {
	
	
	private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = UPPER.toLowerCase();
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+{}[]";
    
    private static final String ALL_CHARS = UPPER + LOWER + DIGITS + SPECIAL_CHARS;

    private static SecureRandom random = new SecureRandom();
	
	public String generatepasswithlength(int len) {
		String pass="";
		
		StringBuffer password = new StringBuffer(len);

        // At least one uppercase letter
        password.append(UPPER.charAt(random.nextInt(UPPER.length())));
        // At least one lowercase letter
        password.append(LOWER.charAt(random.nextInt(LOWER.length())));
        // At least one digit
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        // At least one special character
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        // Remaining characters randomly selected from all characters
        for (int i = 4; i < len; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }
        
        if(password!=null) {
        	pass =password.toString();
        }
		
		return pass;
		
		
		
	}
	
	public String generatepasswithlengthAndName(int len,String name) {
		String pass="";
		
		 // Get the first 3 letters of the name and capitalize the first letter
		  String initials = name.substring(0, 1).toUpperCase() + name.substring(1, Math.min(name.length(), 3));

		  StringBuffer password = new StringBuffer(len);
		  StringBuffer resp = new StringBuffer();
	        // At least one uppercase letter
	        password.append(UPPER.charAt(random.nextInt(UPPER.length())));
	        // At least one lowercase letter
	        password.append(LOWER.charAt(random.nextInt(LOWER.length())));
	        // At least one digit
	        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
	        // At least one special character
	        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

	        // Remaining characters randomly selected from all characters
	        for (int i = 4; i < len; i++) {
	            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
	        }
	        resp.append(initials);
	        resp.append(password.toString());
	        if(!resp.isEmpty()) {
	        	pass =resp.toString();
	        }
	        
		
		
		return pass;
		
		
		
	}

}
