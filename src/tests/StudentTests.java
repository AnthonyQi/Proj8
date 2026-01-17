package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import systemImp.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class StudentTests {
	
	//Testing HeapUtils Class
	@Test
	public void testingHeapifyHeapOrder() {
		//testing with unsorted array for minHeap
		Integer[] test1 = {null, 5, 3, 4, 1, 2};
		StringBuffer log = new StringBuffer();
		HeapUtils.heapify(test1, true, log);
		//after heapify, minHeap should have smallest element at index 1
		assertEquals((Integer)1, test1[1]);
		assertTrue(log.toString().contains("Heapify swap"));
		//testing with unsorted array for maxHeap
		Integer[] test2 = {null, 2, 4, 1, 5, 3};
		StringBuffer log2 = new StringBuffer();
		HeapUtils.heapify(test2, false, log2);
		//after heapify, maxHeap should have largest element at index 1
		assertEquals((Integer) 5, test2[1]);
		assertTrue(log.toString().contains("Heapify swap"));
		//testing with null element in between
		Integer[] test3 = {null, 1, null, 2, 3};
		StringBuffer log3 = new StringBuffer();
		//minHeap first
		System.out.println("minHEAP");
		System.out.println(Arrays.toString(test3));
		HeapUtils.heapify(test3, true, log3);
		System.out.println(log3.toString() + "\n"
				+ Arrays.toString(test3));
		System.out.println("HeapSort");
		HeapUtils.heapSort(test3, log3);
		System.out.println(log3.toString() + "\n"
				+ Arrays.toString(test3));
		//maxHeap
		Integer[] test4 = {null, 1, null, 2, 3};
		StringBuffer log4 = new StringBuffer();
		System.out.println("maxHEAP");
		System.out.println(Arrays.toString(test4));
		HeapUtils.heapify(test4, false, log4);
		System.out.println(log4.toString() + "\n"
				+ Arrays.toString(test4));
		System.out.println("HeapSort");
		HeapUtils.heapSort(test4, log4);
		System.out.println(log4.toString() + "\n"
				+ Arrays.toString(test4));
		//testing with array filled with only null elements
		System.out.println("NULL");
		Integer[] test5 = {null, null, null, null};
		StringBuffer log5 = new StringBuffer();
		System.out.println(Arrays.toString(test5));
		HeapUtils.heapify(test5, true, log5);
		System.out.println(log5.toString() + "\n"
				+ Arrays.toString(test5));

	}
	
	@Test
	public void testingHeapSort() {
		//already sorted array
		Integer[] test1 = {null, 1, 2, 3, 4, 5};
		StringBuffer log1 = new StringBuffer();
		HeapUtils.heapSort(test1, log1);
		Integer[] ans1 = {null, 1, 2, 3, 4, 5};
		assertArrayEquals(ans1, test1);
		//reverse sorted array
		Integer[] test2 = {null, 9, 7, 5, 3, 1};
		StringBuffer log2 = new StringBuffer();
		HeapUtils.heapSort(test2, log2);
		Integer[] ans2 = {null, 1, 3, 5, 7, 9};
		assertArrayEquals(ans2, test2);
		//array with duplicates
		Integer[] test3 = {null, 4, 2, 4, 1, 2};
		StringBuffer log3 = new StringBuffer();
		HeapUtils.heapSort(test3, log3);
		Integer[] ans3 = {null, 1, 2, 2, 4, 4};
		assertArrayEquals(ans3, test3);
		//one element
		Integer[] test4 = {null, 42};
		StringBuffer log4 = new StringBuffer();
		HeapUtils.heapSort(test4, log4);
		Integer[] ans4 = {null, 42};
		assertArrayEquals(ans4, test4);
		//empty array (only null at index 0)
		Integer[] test5 = {null};
		StringBuffer log5 = new StringBuffer();
		HeapUtils.heapSort(test5, log5);
		Integer[] ans5 = {null};
		assertArrayEquals(ans5, test5);
		//array with negative values
		Integer[] test6 = {null, -3, -1, -7, -2};
		StringBuffer log6 = new StringBuffer();
		HeapUtils.heapSort(test6, log6);
		Integer[] ans6 = {null, -7, -3, -2, -1};
		assertArrayEquals(ans6, test6);
		//array with all same values
		Integer[] test7 = {null, 5, 5, 5, 5, 5};
		StringBuffer log7 = new StringBuffer();
		HeapUtils.heapSort(test7, log7);
		Integer[] ans7 = {null, 5, 5, 5, 5, 5};
		assertArrayEquals(ans7, test7);
	}
	
	//Testing PriorityQueue Class
	
	@Test
	public void testingPriorityQueueConstructor() {
		//testing invalid arrays
		//this array tests for non-null 0 index
		try {
			Integer[] wrongArr = {1, 2, 3, 4, 5};
			PriorityQueue<Integer> pq =
					new PriorityQueue<Integer>(wrongArr, true);
		} catch(Exception e) {
			String err = "Invalid Array";
			assertEquals(err, e.getMessage());
		}
		//testing length <= 1
		try {
			Integer[] wrongArr = {null};
			PriorityQueue<Integer> pq =
					new PriorityQueue<Integer>(wrongArr, true);
		} catch(Exception e) {
			String err = "Invalid Array";
			assertEquals(err, e.getMessage());
		}
		//testing with null array
		try {
			Integer[] wrongArr = null;
			PriorityQueue<Integer> pq =
					new PriorityQueue<Integer>(wrongArr, true);
		} catch(Exception e) {
			String err = "Invalid Array";
			assertEquals(err, e.getMessage());
		}
	}
	
	@Test
	public void testingRemove() {
		System.out.println("HEHEHEHA");
		//testing remove with one element 
		StringBuffer log1 = new StringBuffer();
		Integer[] arr1 = {null, 1};
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(arr1, true);
		Integer res1 = pq1.remove(log1);
		Integer ans1 = 1;
		assertEquals(ans1, res1);
		String res2 = log1.toString();
		String ans2 = "Swapped index 1 (1) with index 1 (1)\n"
				+ "Array after removal: [null, null]\n";
		assertEquals(ans2, res2);
		StringBuffer log2 = new StringBuffer();
		Integer[] arr2 = {null, 1, null, 2, 3};
		System.out.println(Arrays.toString(arr2));
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(arr2, true);
		System.out.println(Arrays.toString(arr2));
		System.out.println(pq2.remove(log2));
		System.out.println(Arrays.toString(arr2));
		//just testing insert here to test 2 things with one stone
		pq2.insert((Integer) 4, log2);
		System.out.println(Arrays.toString(arr2));
		System.out.println(log2.toString());
		//testing with invalid array
		//empty array
		try {
			StringBuffer errLog = new StringBuffer();
			Integer[] err = {null, 1};
			PriorityQueue<Integer> test = 
					new PriorityQueue<Integer>(err, true);
			test.remove(errLog);
			test.remove(errLog);
		} catch(Exception e) {
			String err = "PriorityQueue is empty.";
			assertEquals(err, e.getMessage());
		}
	}
	
	@Test
	public void testingInsert() {
		//inserting into a valid queue
		StringBuffer log = new StringBuffer();
		Integer[] test = {null, 1, 2, 3, 4, 5};
		PriorityQueue<Integer> pq = new PriorityQueue<>(test, true);
		pq.remove(log);
		pq.remove(log);
		pq.remove(log);
		pq.remove(log);
		pq.insert(10, log);
		pq.insert(20, log);
		Integer[] ans = {null, 5, 10, 20, null, null};
		assertArrayEquals(ans, test);
		//inserting into full queue
		try {
			Integer[] full = {null, 1, 2};
			PriorityQueue<Integer> errPQ = new PriorityQueue<>(full, true);
			errPQ.insert(3, new StringBuffer());
		} catch(Exception e) {
			String err = "PriorityQueue is full. Cannot insert.";
			assertEquals(err, e.getMessage());
		}
	}
}