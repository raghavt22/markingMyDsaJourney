package com.raghav.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java Collection Framework

class AllMethods{
	
	public static void swapUsingCollections(int index1, int index2, List<Integer> list) {
		if(index1 > list.size() || index2 > list.size() || index1 > index2 || index1 < 0 || index2 < 0) {
			System.out.println("Please check your passing values, ensure the right index format");
		}else {
			int temp = list.get(index1);
			index1 = list.set(index1, list.get(index2));
			index2 = list.set(index2, temp);
		}
		System.out.println(list);
	}//end swapUsingCollection
	
	public static void findMaxUsingCollections(List<Integer> list) {
		
		  	//finding max
			int findMax = 0, max = Integer.MIN_VALUE;
			for(int i=0;i<list.size(); i++) {
				findMax = Math.max(list.get(i),max);
			}//end for
			System.out.println(findMax);
	}//end findMaxUsingCollections
	
	public static void pairSumUsingBruteForce(List<Integer> list, int target) {
		int size = list.size(), possiblePairs=0;
		//Condition to find pair sum is the list needs to be sorted
		Collections.sort(list);
		//we're applying brute force to calculate the possible pairs having sum equals to target
		for(int i=0; i<size; i++) {
			for(int j=i+1; j<size; j++) {
				if(list.get(i) + list.get(j) == target)
					possiblePairs++;
			}//end inner for
		}//end outer for
		
		if(possiblePairs > 0)
			System.out.println("we have " + possiblePairs + " possible pairs in out list which have sum equals to " + target);
		else
			System.out.println("No possible pairs in out list which have sum equals to " + target);
	}//end pairSumUsingBruteForce
	
}
public class ArrayLisstPrac {

	//Add O(1), GetO(1), RemoveO(n), SetO(n), ContainsO(n)
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
//		AllMethods.swapUsingCollections(-9, -9, list);
		AllMethods.pairSumUsingBruteForce(list, 5);

	}//end main
}//end class
