/*
public class DataType3 {
	
	public static void A(int n) {
		if (n > 0) {
			System.out.println(n);
			A(n-1);
		}
			
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;
		A(x);      
		}

	}
	

*/

public class DataType3 {
	
	public static long fact1(int n) {	
		long tmp = 1;
		for(int i =2;  i <= n; i++) {
			tmp = i*tmp;
		}
			return tmp;
		
	}
	
	public static long fact2(int n) {
		if (n == 0)
			return 1;
		else
			return n * fact2(n-1);

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact1(5));
		System.out.println(fact2(5));

	}
}