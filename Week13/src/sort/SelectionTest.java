package sort;

public class SelectionTest {
	int i = 0;
		public int partition(int[] a, int begin, int end) {
			int L, R, temp, pivot;
			L = begin;
			R = end;
			pivot = (begin + end) /2;
			System.out.printf("\n 퀵 정렬 %d 단계, pivot = %d\n", ++i, a[pivot]);
			while(L < R) {
				temp = a[L];
				a[L] = a[R];
				a[R] = temp;
				
			}
			
		}
		temp = a[pivot];
		a[pivot] = a[R];
		a[R] = temp;
		for(t = 0; t < a.length; t++)
			
		
}