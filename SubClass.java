import java.util.*;

public class SubClass extends SuperClass{
	private int n;
	SubClass (int n) {
		System.out.println("SubClass's n: " + n);
		this.n = n;
	}
	SubClass () {
		super(300);
		System.out.println("SubClass()");
	}
	
	public static void main(String[] args) {
		SubClass sc1 = new SubClass();
		SubClass sc2 = new SubClass(400);
	}
}
