package Week12;

//JAVA program for the above approach:

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

//Node class to describe
//basic node structure
class LinkedListNode {
 int data;
 LinkedListNode next;
 LinkedListNode(int data,
                LinkedListNode node)
 {
     this.data = data;
     next = node;
 }
}

public class LinkedlsitHeap {

 private static final int SIZE = 10;

 private static final SortByValueComparator
     sortByValueComparator
     = new SortByValueComparator();

 // Function to utilise the heapsort
 public static void heapsort(LinkedListNode node)
 {
     LinkedListNode head = node;
     int i = 0;

     // Array to copy the linked list data
     LinkedListNode[] arr
         = new LinkedListNode[SIZE];
     while (head != null) {
         arr[i++] = head;
         head = head.next;
     }
     sortArray(arr);
     System.out.println("\nLinkedList after sorting: ");
     while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
     }
 }

 // Function to sort the array
 public static void sortArray(LinkedListNode[] arr)
 {
     int n = arr.length;

     // Build heap
     for (int i = n / 2 - 1; i >= 0; i--)
         heapify(arr, n, i);

     for (int i = n - 1; i > 0; i--) {

         // Moving current root to end
         int temp = arr[0].data;
         arr[0].data = arr[i].data;
         arr[i].data = temp;

         heapify(arr, i, 0);
     }
 }

 // Method that will return a random
 // LinkedList of size = 6.
 public static LinkedListNode createLinkedList()
 {
     Random random = new Random();
     LinkedListNode head
         = new LinkedListNode(SIZE, null);
     LinkedListNode node = head;
     for (int i = SIZE - 1; i > 0; i--) {
         node.next = new LinkedListNode(random.nextInt(),
                                        null);
         node = node.next;
     }
     System.out.println("LinkedList before sorting: ");
     node = head;
     while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
     }
     return head;
 }

 // Function to heapify
 private static void heapify(LinkedListNode[] arr,
                             int n, int i)
 {
     int largest = i;
     int right = 2 * i + 2;
     int left = 2 * i + 1;

     // Check if left child is larger
     // than root
     if (left < n
         && sortByValueComparator.compare(arr[left],
                                          arr[largest])
                > 0)
         largest = left;

     // Check if right child is larger
     // than the largest till now
     if (right < n
         && sortByValueComparator.compare(arr[right],
                                          arr[largest])
                > 0)
         largest = right;

     // Swap if largest is not root
     if (largest != i) {
         int swap = arr[i].data;
         arr[i].data = arr[largest].data;
         arr[largest].data = swap;

         // Recursively heapify the subTree
         heapify(arr, n, largest);
     }
 }

 // Driver code
 public static void main(String[] args)
 {
     LinkedListNode node = createLinkedList();

     // Function call
     heapsort(node);
 }
}

//sortByValueComparator implements
//Comparator interface to sort the data.
//Comparator sort the data on the bases
//of returned value as mentioned below.
//if return value < 0 that means
//node1.data < node2.data
//if return value > 0 that means
//node1.data > node2.data
//if return value = 0 that means
//node1.data == node2.data
class SortByValueComparator
 implements Comparator<LinkedListNode> {
 public int compare(LinkedListNode node1,
                    LinkedListNode node2)
 {
     // If we interchange return value
     // -1 and 1 then LinkedList will be
     // sorted in reverse/descending order.
     if (node1.data < node2.data) {
         return -1;
     }
     else if (node1.data > node2.data) {
         return 1;
     }
     return 0;
 }
}