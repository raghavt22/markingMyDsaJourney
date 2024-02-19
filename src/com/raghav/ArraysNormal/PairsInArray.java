package com.raghav.ArraysNormal;

public class PairsInArray {

	//to implement pairs of array we should understand the concept of nested arrays
	public static void main(String[] args) {
		int[] arr = {2,4,6,8,10};
		int[] arr1 = {1,-2,6,-1,3};
		int[] arr2 = {-2,-3,4,-1,-2,1,5,-3};
//		pairsOfArray(arr);
//		printSubArrays(arr1);
//		printSubArraysPrefixArrayApproach(arr1);
		printSubArraysUsingKadanesAlgorithm(arr2);
	}
	
	private static void printSubArraysUsingKadanesAlgorithm(int[] arr1) {
		/*
		 * KADANE's ALGORITHM SAYS that:- --> Time Complexity will be O(n) much efficient than the other 2 solutions
		 * 	1. if you have both positive numbers than you'll get the result in positive--> perfect.
		 * 	2. if you have a big positive number and a small negative number than also the result will be positive --> perfect
		 *  3. but if you have a less positive number and a large negative number than this is not favorable --> not good
		 *  keeping all these 3 conditions we're going to prepare the solution
		 */
		int length = arr1.length, currSum = 0, max = Integer.MIN_VALUE;
		for(int i=0; i<length; i++) {
			currSum = (arr1[i] + currSum) < 0 ? 0: arr1[i]+currSum;
			max = Math.max(max, currSum);
		}//end for
		
		System.out.println("Max Sum in the Sub array :: " + max );
	}

	private static void printSubArraysPrefixArrayApproach(int[] arr) {
		//time complexity O(n)2 --> Still we can improve it 
		int length = arr.length, currSum = 0 ,max = Integer.MIN_VALUE;
		//creating prefix array 
		int[] otherArr = new int[length];
		otherArr[0] = arr[0];
		//preparing prefix array approach
		for(int i=1; i<length; i++) {
			otherArr[i] = arr[i] + otherArr[i-1];
		}//end for --> ready with otherArr
		
		for(int i=0; i<length; i++) {
			for(int j=i; j<length; j++) {
				currSum = i==0 ? otherArr[j] : otherArr[j] - otherArr[i-1];
				System.out.println(currSum);
				max = Math.max(max, currSum);
			}//end j for
			System.out.println();
		}//end i for
		System.out.println(" Max in the subArray :: " + max);
	}//end method

	private static void printSubArrays(int[] arr) {
		//Worst time complexity O(n)3 
		int length = arr.length, count = 0, sumOfSubArrays = 0 , max = Integer.MIN_VALUE;
		for(int i=0; i<length; i++) {
			for(int j=i; j<length; j++) {
				for(int k=i; k<=j; k++) {
//					System.out.print(arr[k] + ",");
					sumOfSubArrays += arr[k];
					max = Math.max(max, sumOfSubArrays);
				}//end k for
				System.out.println(sumOfSubArrays);
				sumOfSubArrays=0;
//				System.out.println();
				count++;
			}//end j for
			System.out.println();
		}//end i for
		System.out.println("Sub Arrays count :: "+ count + "/ Max in the subArray :: " + max);
	}//end method

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
