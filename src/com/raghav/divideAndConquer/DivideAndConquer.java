package com.raghav.divideAndConquer;

public class DivideAndConquer {
	
	public static void printArr(int[] arr) {
		int length = arr.length;
		for(int i=0; i<length; i++) {
			System.out.print(arr[i] + " ");
		}//end for
	}//end countArr
	
	public static int searcInRotatedSortedArray(int[] arr, int target , int startIndex , int endIndex) {
		/*
		 * TIME COMPLEXITY WILL BE nlog(n)
		 */
		//BASE CASE
		if(startIndex > endIndex) {
			return -1;
		}
		
		//calculating mid
		int mid = startIndex + (endIndex - startIndex)/2;
		
		if(arr[mid] == target) { // best case where we found the target at mid itself
			return mid;
		}//end if 
		
		//search on Line1
		if(arr[startIndex] <= arr[mid]) {
			if(arr[startIndex] <= target && target <= arr[mid]) {
				//case a : left search on line 1
				return searcInRotatedSortedArray(arr, target, startIndex, mid-1);
			}else
				//case b : right search on line 2
				return searcInRotatedSortedArray(arr, target, mid+1, endIndex);
		}//end if
		//search on Line2
		else {
			if(arr[mid] <= target && target <= arr[endIndex]){
				return searcInRotatedSortedArray(arr, target, mid+1, endIndex);
			}else {
				return searcInRotatedSortedArray(arr, target, startIndex, mid-1);
			}//end else
		}// end outer else
	}//end sorted
	
	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		/*
		 * VERY IMPORTANT POINT TO REMEMBER ABOUT QUICK SORT
		 * TIME COMPLEXITY WILL BE 	nlog(n) --> IN AVERAGE CASES BUT IN WORST IT CAN GO UPTO O(N)2
		 * SPACE COMPLEXITY WILL BE O(1) MEANS WHILE USING QUICK SORT WE DON'T USE EXTRA SPACES 
		 * 
		 * THUS IF WE DON'T HAVE ANY SPACES TO WORK WITH AND STILL WE NEED MUCH EFFICIENT SORTING THAN
		 * IN THAT CASES WE SHOULD GO FOR QUICK SORT, AND REMEMBER THAT ARE VERY LESS CHANCES TO HIT FOR
		 * WORST TIME COMPLEXITY OTHERWISE IT ALWAYS PERFORMS WITH IT'S BEST
		 */
		
		//terminating condition for the infinite loop
		if(startIndex >= endIndex)
			return;
		
		//work 
		//we're considering our last index is our PIVOT
		int pIndex = partition(arr,startIndex,endIndex); // will get the right position from partition function
		quickSort(arr, startIndex, pIndex-1);
		quickSort(arr, pIndex+1, endIndex);
	}//end quick sort
	
	public static int partition(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[endIndex]; //here i'm creating my pivot based on which our array will be sorted
		int i = startIndex-1; // i will work for creating the spaces for the values that are lower than the pivot in the same array
		
		for(int j=startIndex; j<endIndex; j++) {
			if(arr[j] <= pivot) {
				i++;
				//swap
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}//end if	
		}//end for
		//doing this swap again to put the pivot in the right index
		i++;
		int temp = pivot;
		arr[endIndex] = arr[i];
		arr[i] = temp;
		return i; // returning the right position of pivot
	}//end partition
	
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
		int[] arr1 = {4,5,6,7,0,1,2};
//		mergeSort(arr, 0, arr.length-1);
//		quickSort(arr, 0, arr.length-1);
		System.out.println("Found at :: " + searcInRotatedSortedArray(arr1, 7, 0, arr1.length-1));
//		printArr(arr);
	}

}
