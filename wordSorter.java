import java.util.Scanner;

public class wordSorter {

	   public static void main(String[] args)
	   {
	      
		   Scanner scan = new Scanner(System.in);
		   String[] userStrings = new String[10];
		   String breakInput = "done";
		   int stringCount = 0;
		   
		   System.out.println("Welcome to the sorting machine!");
		   System.out.println("Enter up to 10 strings or \"DONE\" to finish \n");
		   
		   //loop that assigns the user's strings to an array
		   for (int i=0; i<10; i++) {
			   int stringNum = i+1;
			   System.out.print("Enter string " + stringNum + ">> ");
			   String userInput = scan.nextLine();
			   
			   if(breakInput.equalsIgnoreCase(userInput)) {
				   break;
			   }
			   
			   userStrings[i] =  userInput;
			   ++stringCount;
		   }
		   
		   //allows the user to select how they would like to sort their strings
		   String choice = null;
		   final String quit = "q";
		   do {
			   System.out.println("Print strings as entered                       [0]");
			   System.out.println("Print strings in ACENDING alphabetical order   [1] ");
			   System.out.println("Print strings in DECENDING alphabetical order  [2] ");
			   System.out.print("choose an option or enter \"Q\" to quit: ");
			   
			   choice = scan.nextLine();
			   outputChoice(userStrings, stringCount, choice);
		   }while(!choice.equalsIgnoreCase(quit));
		   
		   scan.close();
	   }

	   public static void outputChoice(String[] arr, int countTo, String choice) {
		   int low = 0;
		   int high = countTo - 1;
		   
		   //creates a new array that is the size of the entered strings
		   String[] shortArray = new String[countTo];
	       for (int i=0; i<countTo; ++i)
	            shortArray[i] = arr[i];
		   
		   //output choices for the user's selection
		   if (choice.equals("0")) {
			   System.out.println("Input Strings:");
		       for (int i=0; i<countTo; ++i)
		            System.out.println(arr[i]);
		       
			   System.out.println("\n");
		   }
		   
		   else if (choice.equals("1")) {
			   String[] sortedArray = acendingSort(shortArray, low, high);
		       System.out.printf("%-20s%-20s\n", "Input Strings:", "Sorted Strings:");
			   for (int i=0; i<countTo; ++i)
		           System.out.printf("%-20s%-20s\n", arr[i], sortedArray[i]);
			   System.out.println("\n");
		   }
		  
		   else if (choice.equals("2")) {
			   String[] sortedArray = decendingSort(shortArray, low, high);
		       System.out.printf("%-20s%-20s\n", "Input Strings:", "Sorted Strings:");
			   for (int i=0; i<countTo; ++i)
		           System.out.printf("%-20s%-20s\n", arr[i], sortedArray[i]);
			   System.out.println("\n");
		   }
		   
		   else if (choice.equalsIgnoreCase("q")){}
		  
		   else {
			   System.out.println("Invalid Choice. Please try again:");
			   System.out.println("\n");
		   }
	   }
	   

	    public static String[] acendingSort(String[] arr, int low, int high) 
	    {
	        //determines and assigns a pivot from the array
	        int pivotIndex = low + (high - low) / 2;
	        int i = low; 
	        int j = high;        
	        String pivot = arr[pivotIndex];
	 
	        //first iteration of the quicksort algorithm that splits the list and puts the first element into place
	        while (i <= j) 
	        {
	            //Check until all values on right side array are lower than pivot
	            while (arr[i].compareToIgnoreCase(pivot) < 0) 
	            {
	                i++;
	            }
	            //Check until all values on left side array are greater than pivot
	            while (arr[j].compareToIgnoreCase(pivot) > 0) 
	            {
	                j--;
	            }
	            //compare and swap
	            if (i <= j) 
	            {
	                swap (arr, i, j);
	                i++;
	                j--;
	            }
	        }
	        //the sorting algorithm is recursively called to sort the arrays on the left and right
	        if (low < j){
	        	acendingSort(arr, low, j);
	        }
	        if (high > i){
	        	acendingSort(arr, i, high);
	        }

	        return arr;
	    }
	    
	    public static String[] decendingSort(String[] arr, int low, int high) 
	    {
	        //determines and assigns a pivot from the array
	        int pivotIndex = low + (high - low) / 2;
	        int i = low; 
	        int j = high;        
	        String pivot = arr[pivotIndex];
	 
	        //first iteration of the quicksort algorithm that splits the list and puts the first element into place
	        while (i <= j) 
	        {
	            //Check until all values on left side array are lower than pivot
	            while (arr[i].compareToIgnoreCase(pivot) > 0) 
	            {
	                i++;
	            }
	            //Check until all values on right side array are greater than pivot
	            while (arr[j].compareToIgnoreCase(pivot) < 0) 
	            {
	                j--;
	            }
	            //compare and swap
	            if (i <= j) 
	            {
	                swap (arr, i, j);
	                i++;
	                j--;
	            }
	        }
	        //the sorting algorithm is recursively called to sort the arrays on the left and right
	        if (low < j){
	        	decendingSort(arr, low, j);
	        }
	        if (high > i){
	        	decendingSort(arr, i, high);
	        }

	        return arr;
	    }
	     
	    //used to swap array values in the quicksort methods
	    public static void swap (String array[], int x, int y)
	    {
	        String temp = array[x];
	        array[x] = array[y];
	        array[y] = temp;
	    }

	}

