import java.util.Arrays;

public class ReverseArray2 {
	public int[] reverseArray(int A[]) {
		// create an auxiliary stack
		SinglyLinkedStack<Integer> sls = new SinglyLinkedStack<>();
		for (int i=0; i < A.length; i++) {
			sls.push(A[i]);
		}
		
		for (int i=0; i < A.length; i++) {
			A[i] = sls.pop();
		}
		return A;
	}
	
	public static void main(String args[]) {
		ReverseArray2 ra = new ReverseArray2();
		// create an array to test it
		int[] A = new int[9];
		for (int i=1; i<=9; i++) {
			A[i-1] = i;
		}
		System.out.println("Before reversing: " + Arrays.toString(A));
		A = ra.reverseArray(A);
		System.out.println("After reversing: " + Arrays.toString(A));
	}
}
