import java.util.*;

public class ChildClass extends ParentClass {
	public int value;
	/** @override **/
	public void f() {
		f();
		value = 200;
		System.out.println("ChildClass.value = " + value);
		System.out.println(value);
	}
	
	public static void main(String args[]) {
		ChildClass cc = new ChildClass();
		cc.f();
	}
}
