package com.raghav.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class BasicCodingQuestions {
	
	static List<Integer> primeList = new ArrayList<>();
	
	public static void isPrime(int num) {
		//work
		if(num == 2) {
			System.out.println(num + " is prime");
			primeList.add(num);
		}else {
			boolean isPrime = true;
			for(int i=2; i<=Math.sqrt(num); i++) {
				if(num%i==0) {
					isPrime = false;
				}//end if
			}//end for
			
			if(isPrime == true) {
				System.out.println(num + " is prime");
				primeList.add(num);
			}else {
				System.out.println(num + " is not prime");
			}//end inner else
		}//end else
	}//end isPrime
}//end BasicCodingQuestions

public class DsaBasics {
	
 static final int MAX_CHAR = 256;

 static void getOccurringChar(String str)
 {
      
     // Create an array of size 256 
     // i.e. ASCII_SIZE
	 //Although we can iterate the str to find the max char ASCII and on the basis of that we can create the array
     int count[] = new int[MAX_CHAR];

     int len = str.length();

     // Initialize count array index
     for (int i = 0; i < len; i++)
         count[str.charAt(i)]++;

     // Create an array of given String size
     char ch[] = new char[str.length()];
     for (int i = 0; i < len; i++) {
         ch[i] = str.charAt(i);
         int find = 0;
         for (int j = 0; j <= i; j++) {

             // If any matches found
             if (str.charAt(i) == ch[j])
                 find++;
         }//end for inner

         if (find == 1)
             System.out.println(
                 "Number of Occurrence of " + str.charAt(i) + " is:" + count[str.charAt(i)]);
     }//end for outer
 }//end getOccuringChar method
 
 static void getOccuringUsingMap(String passStr) {
		/*
		 *  In this program an approach using Hashmap in Java has been
		 * discussed.
		 * 
		 * 1. Declare a Hashmap in Java of {char, int}. Traverse in the string, check if
		 * the Hashmap already contains the traversed character or not. If it is
		 * present, then increase its count using get() and put() function in Hashmap.
		 * Once the traversal is completed, traverse in the Hashmap and print the
		 * character and its frequency.
		 */ 
	 //Declaring char Array
	 char[] charStr = passStr.toCharArray();
	 //Declaring HashMap<Character,Integer>
	 Map<Character,Integer> occurMap = new HashMap<>();
	 //check if the char is already present in the map, if yes add+1 to the value and if not add value with 1
	 for(char c: charStr) {
		 if(occurMap.containsKey(c)) {
			 occurMap.put(c, occurMap.get(c)+1);
		 }else
			 occurMap.put(c, 1);
	 }
	 
	 //Our code is very efficiently handling the white spaces if any in the passed strings
	Map<Character, Integer> filteredMap = occurMap.entrySet().stream()
             .filter(entry -> !Character.isWhitespace(entry.getKey()))
             .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	 
	 for(Map.Entry<Character, Integer> chr: filteredMap.entrySet()) {
		 System.out.println(chr.getKey() + " " + chr.getValue());
	 }
 }//end getOccuringUsingMap

 
 public static void main(String[] args)
 {
//	 BasicCodingQuestions.isPrime(53);
//     String str = "geeks for geeks";
//     getOccurringChar(str);
//     getOccuringUsingMap(str);
	 for(int i=51; i<=100; i++) {
		 BasicCodingQuestions.isPrime(i);
	 }
 }
}