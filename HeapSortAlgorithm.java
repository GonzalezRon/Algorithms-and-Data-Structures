package com.mycompany.Algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class HeapSortAlgorithm {
	
	public void buildMaxHeap(ArrayList <Integer> A ){

		int startIndex = (A.size()/2)-1; //sart at the half way point minus one for Indexing 
		
		for (int i = startIndex; i >= 0; i--) {  //classic indexing example 

                    MaxHeapify(A, i); //size of array and index are passed 
		}
	}

       
        /**
         * largest = i 
         * L = left child index 
         * R = right child index 
         * 
         */ 
	 
	private void MaxHeapify(ArrayList <Integer> arraylist, int i) {
		int L = (2*i + 1);//Left most element 
		int R = (2*i + 2);// right most element 
                int largest = i; //largest element// also root element;  
                            
                //this comparison check if the element on the left is larger that the indexed element 
		if ( L < arraylist.size()   && arraylist.get(L) > arraylist.get(i) ) {
			largest = L; 
                        
		}                                       
                //largest index not element
	
              
 
                        
                 //check for the right side element        
		if (R < arraylist.size()   && arraylist.get(R) > arraylist.get(largest) ) {
			largest = R; 
			
                                                                 
                //swap anything larger than i between              
                // to swap an array then : int swap = array[i]; etc. array[i] = array[largest]                
		}if (largest != i) {
			Collections.swap(arraylist, i, largest);

                        MaxHeapify(arraylist, largest);	
                }
}
        
        //rebuild BuildHeap and MaxHeap
	public void HeapifyArray (int [] array)  {
            //get the size and array
            int length = array.length;
            //starting point 
            int start = (length/2)-1; 
            //always check zeros 
            if (length == 0) {
            }
            //loop and call max heapify
            for (int i = start; i >= 0; i--){
                makeItAMaxHeap(array, i);
            //calls method for max heap of an array
            }
        }
        
       private void makeItAMaxHeap(int[] array, int i) {
           //a heap has a left and a right child 
           //we calculate those when we have an empty zero space as: 
           int left_child = 2*i + 1;
           int right_child = 2*i + 2; 
           //we also need a perent node or root at the starting point
           int root = i; 
           
           //array element comparisons !
           //left child is greater than right child in max heap 
           //root is greater than both children
           
           if (left_child < array.length && array[left_child] > array[i]){
               root = left_child;
               
           //if the left child is greater it is root
           }
           
           if (right_child < array.length && array[right_child] > array[root]){
               root = right_child;
           //if the right child is greater it is root      
           }
           //else if the root has changed from i: swap elements 
           if (root != i ){
               //to swap get the root element and user a third value 
               int holder = array[i];//copy the smaller element 
               array[i] = array[root];//copy the larger element onto array[i] space
               array[root]= holder; //the smaller element is not where the larger element was
               //the smaller element replaces bigger element after the bigger elements was coppied 
               //onto the starting position   
               
               //after the swap has been done the function is called again
               //to sort the children and parent nodes
               makeItAMaxHeap(array, root);
           }
           
           
           
           
    }    
	
	public static void main (String [] args) {
		
		HeapSortAlgorithm am = new HeapSortAlgorithm(); 
		ArrayList <Integer> arrayList = new ArrayList(); 
                
                //array of integers
                int [] array = {1,3,5,4,6,13,10,9,8,15,17};
		
		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(5);
		arrayList.add(4);
		arrayList.add(6);
		arrayList.add(13);
		arrayList.add(10);
		arrayList.add(9);
                arrayList.add(8); 
                arrayList.add(15); 
                arrayList.add(17); 

		am.buildMaxHeap(arrayList);
                //call the new practice method 
                am.HeapifyArray(array);
                
                //call the new array and print its content 
                for(int i = 0; i < array.length; i++){
                    System.out.println(array[i]);
                }
                
		
//		for (Integer j : arrayList) 
//			System.out.println(j);
	}

 
	
}
