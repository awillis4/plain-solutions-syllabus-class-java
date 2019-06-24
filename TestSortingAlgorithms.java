
import java.util.Arrays;

public class TestSortingAlgorithms {	
    public static void main(String args[]) {
    	
    	int sequence1[] = {5, 4, 3, 2, 1};
    	// test bubble sort
    	BubbleSort bubbleSrt = new BubbleSort();
        sequence1 = bubbleSrt.bubbleSort(sequence1);
        System.out.println("Bubble sort: " + Arrays.toString(sequence1));
        
        // test selection sort
        SelectionSort selectionSrt = new SelectionSort();
        int sequence2[] = {5, 3, 1, 8, 9};
        sequence2 = selectionSrt.selectionSort(sequence2);
        System.out.println("Selection sort: " + Arrays.toString(sequence2));
        
        // test insertion sort
        InsertionSort insertionSrt = new InsertionSort();
        int sequence3[] = {5, 3, 1, 8, 9};
        sequence3 = insertionSrt.insertionSort(sequence3);
        System.out.println("Insertion sort: " + Arrays.toString(sequence3));
    
        // test quick sort (out-of-place)
        OutPlaceQuickSort outPlaceQuickSrt = new OutPlaceQuickSort();
        SinglyLinkedQueue<Integer> sequence4 = new SinglyLinkedQueue<>();
        sequence4.enqueue(19);
        sequence4.enqueue(19);
        sequence4.enqueue(13);
        sequence4.enqueue(7);
        sequence4.enqueue(9);
        sequence4 = outPlaceQuickSrt.outPlaceQuickSort(sequence4);
        System.out.print("Out-of-place quick sort: ");
        System.out.println(sequence4.toString());
        
        // test quick sort (in-place)
        InPlaceQuickSort inPlaceQuickSrt = new InPlaceQuickSort();
        int sequence5[] = {2, 8, 7, 9, 6, 1, 5, 3, 4};
        sequence5 = inPlaceQuickSrt.inPlaceQuickSort(sequence5, 0, 8);
        System.out.println("In-place quick sort: " + Arrays.toString(sequence5));
        
        // test quick sort (randomized)
        RandomizedQuickSort randQuickSrt = new RandomizedQuickSort();
        sequence5 = randQuickSrt.randomQuickSort(sequence5, 0, 8);
        System.out.println("Randomized in-place quick sort: " + Arrays.toString(sequence5)); 
        
        // test merge sort (array): 
        MergeSort mergeSrt = new MergeSort();
        sequence5 = mergeSrt.mergeSort(sequence5);
        System.out.println("Merge sort: " + Arrays.toString(sequence5));
        
    }
}
