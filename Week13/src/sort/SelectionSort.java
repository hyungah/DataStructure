package sort;
class SelectionSort{
   public void selection(int a[]) {
      int i, j, min;   
      for(i = 0; i <a.length-1; i++) {
         min = i;
         for(j = i+1; j < a.length; j++) {
            if(a[j] < a[min])
               min = j;
         }
         swap(a, min, i);
         System.out.printf("\n선택 정렬 %d 단계", i + 1);
         for(j = 0; j < a.length; j++)
            System.out.printf("%5d", a[j]);
      }
   }
   public void swap(int[] a, int i, int j) {
      int temp;
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   public void bubble(int a[]) {
      int i, j, temp;
      for(i = a.length - 1; i > 0; i--) {
         System.out.printf("\n 버블 단계 %d 단계 : ", a.length - i);
         for(j = 0; j < i; j++) {
            if(a[j] > a[j+1]) {
               temp = a[j];    
               a[j] = a[j+1];
               a[j+1] = temp;
            }
         }

         for(int k = 0; k < a.length; k++) 
            System.out.printf("%5d", a[k]);
      }
   }
   
   public void insertion(int[] a) {
	   int i, j, temp;
	   for(i = 1; i < a.length; i ++) {
		   temp = a[i];
		    j= i;
		    while(j > 0 && a[j-1]> temp) {
		    	a[j] = a[j-1];
		    	j--;
		    }
		    a[j] = temp;
		    System.out.printf("\n삽입 정렬 %d 단계 : ", i);
		    for(int t = 0; t < a.length; t++) {
		    	System.out.printf("%5d", a[t]);
		    }
		    System.out.println();
	   }
	   int i = 0; 
	   public int partition(int [] a, int begin, int end) {
		   int L, R, t, temp, pivot;
		   L = begin;
		   R = end;
		   pivot = (begin + end) / 2;
		   System.out.printf("\n퀵 정렬 %d 단계 : pivot = %d\n", ++i, a[pivot]);
		   while(L < R) {
			   while((a[L] < a[pivot]) && (L < R)) L++;
			   while((a[R] >= a[pivot]) && (L < R)) R--;
			   if(L < R) {
				   temp = a[L];
				   a[L] = a[R];
				   a[R] = temp;
			   }
		   }
		   temp = a[pivot];
		   a[pivot] = a[R];
		   a[R] = temp;
		   for(t = 0; t < a.length; t++)
			   System.out.printf("%5d", a[t]);
		   System.out.println();
		   return L;
   }
	   public void quickSort(int[]a, int begin, int end) {
		   if(begin < end) {
			   int p;
			   p = partition(a, begin, end);
			   quickSort(a, begin, p-1);
			   quickSort(a, p + 1, end);
			   
		   }
	   }
}


public class SelectionTest {
   public static void main(String[] args) {
      int[] a = {69, 10, 30, 2, 16, 8, 31, 22};
      SelectionSort s = new SelectionSort();
      System.out.println("정렬할 원소");
      for(int i = 0; i < a.length; i++)
         System.out.printf("%5d", a[i]);
      System.out.println();
      s.bubble(a);
      //s.selection(a);
      
      
   }
}