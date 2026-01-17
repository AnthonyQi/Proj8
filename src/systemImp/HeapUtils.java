package systemImp;

public class HeapUtils {
	
	public static <T extends Comparable<T>> void heapify
		(T[] arr, boolean isMinHeap, StringBuffer log) {
		//get the size of the array
		int size = arr.length - 1;
		int n = 1;
		for(int j = 1; j < arr.length; j++) {
			if(arr[j] != null) {
				if(arr[n] != arr[j]) {
					arr[n] = arr[j];
					arr[j] = null;
				}
				n++;
			}
		}
		//for all elements with index less than size/2 use helper method
        //start from last internal node and sift down each
        for(int i = size / 2; i > 0; i--) {
            siftDown(arr, i, size, isMinHeap, log, "Heapify");
        }
	}
	
    //sorts array in ascending order using max heap
	public static <T extends Comparable<T>> void heapSort
		(T[] arr, StringBuffer log) {
		//null StringBuffer should prevent logging
		heapify(arr, false, null);
	    int size = arr.length - 1;
	    for(int i = size; i > 1; i--) {
	        swap(arr, 1, i, log, "HeapSort");
	        siftDown(arr, 1, i - 1, false, log, "HeapSort");
	    }
    }
	
	public static <T extends Comparable<T>> void siftDown
		(T[] arr, int index, int size, boolean isMinHeap, StringBuffer log,
		String type) {
		while(2 * index <= size) {
            int left = 2 * index;
            int right = left + 1;
            int temp = left;
            if(right <= size && (arr[right] != null && arr[left] != null)) {
                int comp = arr[right].compareTo(arr[left]);
                //chooses which child would be better
                boolean r = isMinHeap ? (comp < 0) : (comp > 0);
                if(r) {
                	temp = right;
                }
            }
            if((temp < arr.length && temp > 1) && 
            		(index < arr.length && index > 0) &&
            		(arr[temp] == null || arr[index] == null)) {
                break;
            }
            int comp = arr[temp].compareTo(arr[index]);
            boolean swap = isMinHeap ? (comp < 0) : (comp > 0);
            if(swap) {
                swap(arr, index, temp, log, type);
                index = temp;
            } 
            else {
            	break;
            }
        }
	}
	
	//not needed in this class, but should be able to sift up
	public static <T extends Comparable<T>> void siftUp
		(T[] arr, int index, boolean isMinHeap, 
		StringBuffer log, String type) {
		while(index > 1) {
			int p = index / 2;
			if (arr[p] == null) {
				break;
			}
			int comp = arr[index].compareTo(arr[p]);
			boolean swap = isMinHeap ? (comp < 0) : (comp > 0);
			if(swap) {
				swap(arr, index, p, log, type);
				index = p;
			} 
			else {
				break;
			}
		}
	}
	
	//public swap method to simplify swapping nodes
	public static <T> void swap(T[] arr, int i, int j, StringBuffer log,
		String type) {
		//if there is a valid type then it logs with the type
		if ((type.equals("HeapSort") || type.equals("Heapify"))
			&& log != null) {
            log.append(type + " swap: Swapped index " + i + 
                " (" + arr[i] + ") with index " + j + 
                " (" + arr[j] + ")\n");
        }
		//else it just logs without specifying the type
		else if(log != null) {
			log.append("Swapped index " + i + " (" + arr[i] + ") with index "
					+ j + " (" + arr[j] + ")\n");
		}
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

