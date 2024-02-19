package com.raghav.ArraysNormal;

public class PairsInArray {

	//to implement pairs of array we should understand the concept of nested arrays
	public static void main(String[] args) {
		int[] arr = {2,4,6,8,10};
		pairsOfArray(arr);
	}

	private static void pairsOfArray(int[] arr) {
		int length = arr.length; // storing the length so that we calculate it only once
		/*Requirement to print
		 * [2,4] [2,6] [2,8] [2,10] 
		 * [4,6] [4,8] [4,10] 
		 * [6,8] [6,10]
		 * [8,10]
		 */
		for(int i=0; i<length-1; i++) {
			for(int j=i+1; j<length; j++) {
				System.out.print("["+arr[i]+ "," + arr[j] + "]" + " ");
			}//end inner for
			System.out.println();
		}//end outer for
	}//end method
}//end class
