package com.raghav.divideAndConquer;

public class DivideAndConquer {
	
	public static void printArr(int[] arr) {
		int length = arr.length;
		for(int i=0; i<length; i++) {
			System.out.print(arr[i] + " ");
		}//end for
	}//end countArr
	
	public static void mergeSort(int[] arr, int startIndex, int endIndex) {
		/*
		 * VERY IMPORTANT POINT TO REMEMBER ABOUT MERGE SORT
		 * TIME COMPLEXITY WILL BE 	nlog(n) --> much efficient
		 * SPACE COMPLEXITY WILL BE O(n) 
		 * THUS WHEN WE DON'T HAVE ANY EXTRA SPACE TO WORK WITH, WE SHOULD NOT USE MERGE SORT 
		 */
		//base case for avoiding infinite loop of recursion
		if(startIndex >= endIndex) {
			return;
		}
		//work
		int mid = startIndex + (endIndex - startIndex) / 2;
		mergeSort(arr, startIndex, mid); //for left sub array
		mergeSort(arr, mid+1, endIndex); // for right sub array
		merge(arr,startIndex,mid,endIndex);
	}//end mergeSort

	public static void merge(int[] arr, int startIndex, int mid, int endIndex) {
		int[] tempArr = new int[endIndex-startIndex+1]; // creating a temp array
		/*
		 * why endIndex - startIndex + 1 --> suppose you've a array having index arr[0,3] total indexes is 4
		 * other array arr1[4,6]  total index is 3 
		 * thus total 4+3 = 7 but if you do
		 * endIndex - startIndex than the total size will be 6-0 = 6 and we require 7 indexes thus +1 is required
		 * while creating an temporary array.
		 */
		
		//now we will create indexes to track out sorted arrays that we get from mergeSort function 
		//i.e
		int i = startIndex; // for the left sorted array
		int j = mid+1; // for the right sorted array
		int k = 0; // for tracking the indexes of our temporary array
		
		while(i <= mid && j <= endIndex) {
			if(arr[i] < arr[j])
				tempArr[k++] = arr[i++];
			else
				tempArr[k++] = arr[j++];
		}//end while
		
		//but for the left over elements if any for our left array
		while(i <= mid) {
			tempArr[k++] = arr[i++];
		}//end for left sorted
		
		//but for the left over elements if any for our left array
		while(j <= endIndex) {
			tempArr[k++] = arr[j++];
		}//end for right sorted
		
		//copy the tempArray into the original one
		for( k=0, i=startIndex; k<tempArr.length; k++, i++) {
			arr[i] = tempArr[k];
		}//end 
	}//end merge

	public static void main(String[] args) {
		int[] arr = {6,3,9,5,2,8};
		mergeSort(arr, 0, arr.length-1);
		printArr(arr);
	}

}
