package com.raghav.prac;

public class BasicSortings {
	
	public static void countingSort(int[] arr) {
		int length = arr.length;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<length; i++) {
			max = Math.max(max, arr[i]);
		}//traversing on param array to get the length for count array
		
		int[] count = new int[max+1];
		for(int i=0; i<length; i++) {
			count[arr[i]]++;
		}//end of count array iteration
		
		int j = 0;
		for(int i=0; i<count.length; i++) {
			while(count[i] > 0) {
				arr[j] = i;
				j++;
				count[i]--;
			}//end of while
		}//end of for
		printArray(arr);
	}//end of the method
	
	public static void insertionSort(int[] arr) {
		
		/*
		 *  The logic behind insertion sort is to pick an element from the unsorted part and place into
		 *  the right position in sorted part.
		 */
		int length = arr.length;
		for(int i=1; i<length; i++) {
			int currentPosition = arr[i]; //our currentPosition variable is holding the value itself
			int previousPosition = i-1;
			while(previousPosition >= 0 && arr[previousPosition] > currentPosition) {
				arr[previousPosition + 1] = arr[previousPosition];
				previousPosition--;
			}//end of while
			//insertion
			arr[previousPosition + 1] = currentPosition;
		}//end for loop
		printArray(arr);
	}//end of the method
	
	public static void selectionSort(int[] arr) {
		int length = arr.length;
		for(int i=0; i<length-1; i++) {
			int minimunPos = i; //assuming that the minimum value is already present.
			for(int j=i+1; j<length; j++) {
				if(arr[minimunPos] > arr[j]) {
					minimunPos = j;
				}//end if
			}//end inner for
			//putting swap logic here
			int temp = arr[minimunPos];
			arr[minimunPos] = arr[i];
			arr[i] = temp;
		}//end of outer for
		printArray(arr);
	}//end of the method
	
	public static void printArray(int[] arr) {
		int length = arr.length;
		for(int i=0; i<length; i++) {
			System.out.print(arr[i] + " ");
		}//end of for
		System.out.println();
	}//end of method

	public static void bubbleSort(int[] arr) {
		/*Idea behind bubble sort is to arrange the array elements either in Increasing or Decreasing order while swapping 
		 * the greater element with the adjacent shortest one and vice-versa in case of Decreasing order.
		 */
		int length = arr.length;
		for(int i=0; i<length-1; i++) {
			int swaps = 0;
			for(int j=0; j<length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					//swapping logic
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swaps++;
				}//end if
			}//end inner for
			if(swaps == 0) break; // this swaps will helps us to tell whether the passed array is already sorted or not
		}//end outer for
		printArray(arr);
	}//end of method
	
	public static void main(String[] args) {
		//Initializing and Declaring an Array of Size 5
		
		int[] arr = {8,5,1,2,3,9};
		System.out.println("Unsorted Array ::");
		printArray(arr);
		System.out.println("Sorted Array ::" );
//		bubbleSort(arr);
//		selectionSort(arr);
//		insertionSort(arr);
	}

}
