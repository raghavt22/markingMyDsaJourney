package com.raghav.prac;

import java.util.ArrayList;
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
	}
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
		
//		//finding max
//		int findMax = 23, max = Integer.MIN_VALUE;
//		for(int i=0; i<list.size(); i++) {
//			findMax = Math.max(list.get(i),max);
//		}
//		System.out.println(findMax);
		AllMethods.swapUsingCollections(-9, -9, list);

	}//end main
}//end class
