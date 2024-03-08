 package com.raghav.commonStringQuestions;

import java.util.Arrays;

class StringOperations{
	
	public static String longestCommonPrefix(String[] arr) {
		int length = arr.length;
		
		if(length == 0)
			return "";
		
		if(length == 1)
			return arr[0];
		
		Arrays.sort(arr);
		int prefixLength = Math.min(arr[0].length(), arr[length-1].length());
		int i=0;
		while(i < prefixLength && arr[0].charAt(i) == arr[length-1].charAt(i))
			i++;
		
		if(arr[0].substring(0, i).length() != 0)
			return arr[0].substring(0, i);
		else
			return "Ooohoo!.. No such common prefix found";
	}//end method
	
	public static void printStringArray(String[] str) {
		int length = str.length;
		for(int i=0; i<length; i++) {
			System.out.print(str[i] + "  ");
		}//end for
	}//end print string array
	
	public static void reverseString(String str) {
		String[] splitArray = str.split(" ");
		StringBuilder strBld = new StringBuilder(); //to manipulate the string in the same object
		int length = splitArray.length;
		for(int i=length-1; i>=0; i--) {
			strBld.append(splitArray[i] + " ");
		}//end for
		System.out.println(strBld.toString());
	}//end reverseString
}//end string operations

public class StringPractise {
	
	public static void main(String[] args) {
		//data
		String str = "the overwhelming part of coding is that you start building logic";
		String str1 = "dishonesty is the cancer for discipline";
		String[] str2 = {"twinning","twinkle","tweerk","twist"};
		String[] str3 = {"ABCD", "BCDE", "ACDE", "ABCEFGHIJKL"};
		System.out.println(new StringBuilder("Raghvendra").reverse());
		
		//operations
//		StringOperations.reverseString(str1);
//		System.out.println("Common Prefix --> " + StringOperations.longestCommonPrefix(str2));
		}//end main
}//end stringPractise
