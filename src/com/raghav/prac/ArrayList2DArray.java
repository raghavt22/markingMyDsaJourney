package com.raghav.prac;

import java.util.ArrayList;
import java.util.List;

public class ArrayList2DArray {
	
	public static void list2DArray(List<Integer> list) {
List<List<Integer>> mainList = new ArrayList<>();
		//Creating 2D AraayList's using ArrayList
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		mainList.add(list1);mainList.add(list2);mainList.add(list3);
		/*
		 * we want to store :-	1	2	3	4	5 (if you see this is table of 1 till 5)
		 * 						2	4	6	8	10 (if you see this is table of 2 till 5)
		 * 						3	6	9	12	15 (if you see this is table of 3 till 5)
		 */
		//or a better way to do this
		for(int i=1; i<=5; i++) {
			list1.add(i*1);
			list2.add(i*2);
			list3.add(i*3);
		}
		
		for(int i=0; i<mainList.size(); i++) {
			List<Integer> lists = mainList.get(i);
			for(int j=0; j<lists.size(); j++) {
				System.out.print(lists.get(j) + " ");
			}//end inner for
			System.out.println();
		}//end outer for

	}
	
	public static int containerWithMostWater2PointerApproach(List<Integer> arrList) {
		//Time Complexity will be O(n)
		int max = 0, lPointer = 0, rPointer = arrList.size()-1,height,width;
		while(lPointer<rPointer) {
			height = Math.min(arrList.get(lPointer),arrList.get(rPointer));
			width = rPointer-lPointer;
			max = Math.max(max, height*width);
			
			if(arrList.get(lPointer) < arrList.get(rPointer))
			lPointer++;
			else
			rPointer--;
		}
		return max;
	}//end method
	
	public static int containerWithMostWaterBruteForce(List<Integer> arrList) {
		//Time complexity will be O(n)2
		int max = 0, height, width;
		for(int i=0; i<arrList.size(); i++) {
			for(int j=i+1; j<arrList.size(); j++) {
				height = Math.min(arrList.get(i),arrList.get(j));
				width = j-i;
				max = Math.max(max, height*width);
			}//end inner for
		}//end outer for
		return max;
	}

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);list1.add(8);list1.add(6);list1.add(2);list1.add(5);list1.add(4);list1.add(8);list1.add(3);list1.add(7);
// 		int total = containerWithMostWaterBruteForce(list1);
		int total = containerWithMostWater2PointerApproach(list1);
 		System.out.println(total);
	}//end main

}
