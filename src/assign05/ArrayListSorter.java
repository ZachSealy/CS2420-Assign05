package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListSorter {
    private static int insertionSortThreshold = 3;
    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list){

        // Create a temporary list that will be used for merge
        ArrayList<T> tempList = new ArrayList<>(List.copyOf(list));

        // Call the recursive method with the left boundary set to the beginning of the array and the right at the end.
        mergeRecursion(list, tempList, 0, list.size());

    }

    private static <T extends Comparable<? super T>> void mergeRecursion(ArrayList<T> list, ArrayList<T> tempList, int l, int r) {

        // If the size of the subarray is at the threshold, call insertion sort
        if((r - l) == insertionSortThreshold) {
            insertionSort(list);
            return;
        }

        // Calculate the middle of the subarray
        int middle = ((r - l) / 2) + l;

        // Set the values to both sides
        for (int i = l; i < r; i++) {
            tempList.set(i, list.get(i));
        }

        // Call the recursive methods on both sides, one goes from left to middle, the other from middle to right
        mergeRecursion(tempList, tempList, l, middle);
        mergeRecursion(tempList, tempList, middle, r);

        // Merge the subarrays
        merge(list, tempList, l, r);
    }

    public static <T extends Comparable<? super T>> void merge(ArrayList<T> list, ArrayList<T> tempList, int l, int r) {

        // Calculate where the arrays are seperated
        int middle = (r - l) / 2;

        // Initialize the indexes
        int leftIndex = 0, rightIndex = middle, listIndex = 0;

        // While the loop is inside both subarrays, compare the values and add while keeping track of the positions
        while (leftIndex < middle && rightIndex < r) {
            if (tempList.get(leftIndex).compareTo(tempList.get(rightIndex)) < 0) {
                list.set(listIndex, tempList.get(leftIndex));
                leftIndex++;
            } else {
                list.set(listIndex, tempList.get(rightIndex));
                rightIndex++;
            }
            listIndex++;
        }

        // Once one of the arrays is done being added, add the rest of the other
        while(rightIndex < r) {
            list.set(listIndex, tempList.get(rightIndex));
            rightIndex++;
            listIndex++;
        }
        while(leftIndex < middle) {
            list.set(listIndex, tempList.get(leftIndex));
            leftIndex++;
            listIndex++;
        }
    }
    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list){

        splitRecursion(list);

        System.out.println("\n");
        System.out.println("Here");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    
    private static <T extends Comparable<? super T>> void splitRecursion(ArrayList<T> list) {
    	
    	if(list.size() <= 3)
    	{
    		insertionSort(list);
    		return;
    	}
    	
//    	int pivot = pivotMethod1(list);
    	var pivot = pivotMethod2(list);
//    	int pivot = pivotMethod3(list);
    	
    	ArrayList<T> smaller = new ArrayList<T>();
    	ArrayList<T> bigger = new ArrayList<T>();
    	
    	for(T value: list)
    	{
    		if( value.compareTo(pivot) < 0)
    			smaller.add(value);
    		else
    			bigger.add(value);
    	}
    	
    	splitRecursion(smaller);
    	splitRecursion(bigger);
    	
    	ArrayList<T> combined = new ArrayList<T>();
        int listPos = 0;
    	for(int i = 0; i < smaller.size() ; i++) {
            list.set(listPos, smaller.get(i));
            listPos++;
        }
//    		combined.add(smaller.get(i));
//        combined.add(pivot);
    	for(int i = 0; i < bigger.size() ; i++) {
            list.set(listPos, bigger.get(i));
            listPos++;
        }

    }
    
    private static <T extends Comparable<? super T>> T pivotMethod1(ArrayList<T> list) {
    	// returns middle index of array
    	return list.get(0);
    }
    
    private static <T extends Comparable<? super T>> T pivotMethod2(ArrayList<T> list) {
    	//return random index in array
    	return list.get((int)(Math.random() * list.size()));

    }
 
    private static <T extends Comparable<? super T>> T pivotMethod3(ArrayList<T> list) {


        return null;
    }
    
    
    
    public static ArrayList<Integer> generateAscending(int size){
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Add integers to the array
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }

        return list;
    }
    public static ArrayList<Integer> generatePermuted(int size){
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Add integers to the array
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }

        // Shuffle the list
        Collections.shuffle(list);

        return list;
    }
    public static ArrayList<Integer> generateDescending(int size){
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Add integers to the array in descending order
        for (int i = size; i >= 1; i--) {
            list.add(i);
        }

        return list;
    }

    private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> list)
    {
        // Set pointers
        for(int i = 1; i < list.size(); i++)
        {
            int j = i;

            // Keep swapping until in the correct position
            while(j !=0 && list.get(j).compareTo(list.get(j - 1)) < 0)
            {
                // Swap the two
                var temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j-1, temp);
                j--;
            }
        }
    }

}
