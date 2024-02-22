package com.raghav.ArraysNormal;

public class PairsInArray {

	//to implement pairs of array we should understand the concept of nested arrays
	public static void main(String[] args) {
		int[] arr = {2,4,6,8,10};
		int[] arr1 = {1,-2,6,-1,3};
		int[] arr2 = {-2,-3,4,-1,-2,1,5,-3};
		int[] arr3 = {4,2,0,6,3,2,5};
		int[] arr4 = {7,1,5,3,6,4};
//		pairsOfArray(arr);
//		printSubArrays(arr1);
//		printSubArraysPrefixArrayApproach(arr1);
//		printSubArraysUsingKadanesAlgorithm(arr2);
//		trappingRainWater(arr3);
//		buyAndSellStocks(arr4);		
	}
	
	public static void buyAndSellStocks(int[] arr) {
		//profit = sellingPrice(Higher) - buyingPrice(lower)
		int buyingPrice = Integer.MAX_VALUE, maxProfit = 0;
		for(int i=0; i<arr.length; i++) {
			if(buyingPrice < arr[i]) {
				int profit = arr[i] - buyingPrice; //calculating today's profit
				maxProfit = Math.max(maxProfit, profit); // procuring global profit in maxProfit variable
			}else {
				buyingPrice = arr[i]; //updating buyingPrice variable if it's value is greater than that days value
			}//end else
		}//end for
		System.out.println("Profit earned :: " + maxProfit);
	}//end buyAndSellStocks

	public static void trappingRainWater(int[] arr) {
		//Medium level question of DSA in LeetCode i.e TrappingRainWater
		/*
		 * Logic to solve this RainWater Problem :-
		 * We're going to use Auxiliary Arrays for solving the problem
		 * 1. We will create both leftBoundary an rightBoundary auxiliary arrays of same length having our parameter array.
		 * 2. Now we will store the max of left boundary and right boundary comparing with each indexes of our array.
		 * 3. we will now just need to subtract the height of each index i.e value from the minimum of left and right boundary
		 * 4. we have to store the trapped rain water in a handle and we'll keep adding the result into some other variable
		 * 5. in our code the variable is Total Trapped Rain Water which will tell us the amount of water that can be trapped.
		 * 
		 */
		int length = arr.length;
		int[] leftBound = new int[length];
		leftBound[0] = arr[0];
		//preparing auxiliary array for left boundary
		for(int i=1; i<length; i++) {
			leftBound[i] = Math.max(arr[i], leftBound[i-1]);
		}//end left for
		
		int[] rightBound = new int[length];
		rightBound[length-1] = arr[length-1];
		//preparing auxiliary array for right boundary
		for(int i=length-2; i>=0; i--) {
			rightBound[i] = Math.max(arr[i], rightBound[i+1]);
		}//end left for
		
		int trappedWater = 0, totalTrappedWater = 0;
		//considering width is 1
		for(int i=0; i<length; i++) {
			trappedWater = (Math.min(leftBound[i],rightBound[i]) - arr[i]) * 1;
			totalTrappedWater+=trappedWater;
		}//end for
		System.out.println("Total Trapped water inside is :: " + totalTrappedWater);
	}

	public static void printSubArraysUsingKadanesAlgorithm(int[] arr1) {
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

	public static void printSubArraysPrefixArrayApproach(int[] arr) {
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

	public static void printSubArrays(int[] arr) {
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

	public static void pairsOfArray(int[] arr) {
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
