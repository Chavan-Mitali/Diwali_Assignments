package com.demo.codechallenge;

public class FindLongestString {
	
	    public static void main(String[] args) {
	        String[] states = {"Maharashtra", "Goa", "Madhya Pradesh", "Gujrat", "Manipur", "Panjab"};

	        int maxLength = 0;
	        
	        String longestString = "";
	        
	        for (int i = 0; i < states.length; i++) {
	            int length = states[i].length(); 

	            if (length > maxLength) {
	                maxLength = length;
	                longestString = states[i];
	            }
	        }

	        System.out.println("Length of the longest string: " + maxLength);
	        System.out.println("The longest string is: " + longestString);
	    }
	}


