package systemImp;

import java.util.Arrays;

public class PriorityQueue<T extends Comparable<T>> {
    private T[] heap;
    private int size; //logical size of the heap
    private boolean isMinHeap;

    public PriorityQueue(T[] arr, boolean isMinHeap) {
    	if(arr == null || arr.length <= 1 || arr[0] != null) {
    		throw new IllegalArgumentException("Invalid Array");
    	}
    	//sets instance variables to the arguments passed through
    	this.heap = arr;
    	this.isMinHeap = isMinHeap;
    	//heapify the array but don't log steps
    	HeapUtils.heapify(heap, isMinHeap, null);
    	this.size = 0;
    	for(T item: heap) {
    		if(item != null) {
    			size++;
    		}
    	}
    }
    
    public T peek() {
    	//checks if empty, by checking the priority element.
    	if(heap[1] == null) {
    		throw new IllegalStateException("PriorityQueue is empty.");
    	}
    	return heap[1];
    }
    
    public T remove(StringBuffer log) {
    	if(heap.length == 1 || heap[1] == null) {
    		throw new IllegalStateException("PriorityQueue is empty.");
    	}
    	
    	T removed = heap[1];
    	int lInd = heap.length - 1;
    	while(lInd > 0 && heap[lInd] == null) {
    		lInd--;
    	}
        HeapUtils.swap(heap, 1, lInd, log, "Remove");
        heap[lInd] = null;
        HeapUtils.siftDown(heap, 1, lInd - 1, isMinHeap, log, "Remove");
        //logging array after remove
        if(log != null) {
            log.append("Array after removal: " + Arrays.toString(heap) + "\n");
        }
        size--;
        return removed;
    }
    
    public void insert(T item, StringBuffer log) {
    	int i = 1;
        while(i < heap.length && heap[i] != null) {
            i++;
        }
        //if no space left
        if(i == heap.length) {
            throw new IllegalStateException
            ("PriorityQueue is full. Cannot insert.");
        }
        heap[i] = item;
    	HeapUtils.siftUp(heap, i, isMinHeap, log, "Insert");
    	if(log != null) {
            log.append("Array after insertion: "
            		+ Arrays.toString(heap) + "\n");
        }
    	size++;
    }
}
