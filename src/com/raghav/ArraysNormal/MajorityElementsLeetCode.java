package com.raghav.ArraysNormal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class MajorityElementsLeetCode {
	
	/*
	 * Given an array nums of size n, return the majority element. The majority
	 * element is the element that appears more than ⌊n / 2⌋ times. You may assume
	 * that the majority element always exists in the array.
	 * 
	 * 	Example 1:
					Input: nums = [3,2,3]
					Output: 3
		Example 2:
					Input: nums = [2,2,1,1,1,2,2]
					Output: 2
	 */
	public static int approach2(int[] arr) {
		int length = arr.length;
		Map<Integer,Integer> obj = new HashMap<>();
		//1. iterate array and store in a hashMap
		for(int i:arr) {
			if(!obj.containsKey(i)) {
				obj.put(i,1);
			}
			else {
				obj.put(i, obj.get(i)+1);
			}//end else
		}//end for
		
		//2. stream the hashtable and return that element which is > n/2, n = arr.length;
		Optional<Entry<Integer, Integer>> filter = obj.entrySet().stream().filter(entry -> entry.getValue() > length/2).findFirst();
		return filter.isPresent()? filter.get().getKey():Integer.MIN_VALUE;
	}//end approach 2
	
	public static int approach1(int[] arr) {
		int length = arr.length;
		//we'll just sort the array
		Arrays.sort(arr);
		//we'll return the element at mid
		int mid = 0 + (length-1-0)/2;
		return arr[mid];
	}//end approach1

	public static void main(String[] args) {
		int[] arr = {2,3,2}; //Test case 1 O/p = 2
		int[] arr1 = {2,2,1,1,1,2,2}; // Test case 2 O/p = 2
		int majorityElement = approach2(arr1);
		System.out.println("Majority Element found :: "+ majorityElement);
	}//end main
}//end class
