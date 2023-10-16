package org.example;

import java.util.Arrays;

public class PQHeap implements PriorityQueue{

    private int size;
    private Account[] data;


    public PQHeap() {
        data = new Account[50];
        size = 0;
    }

    public int getParentIndex(int index){
        return Math.floorDiv(index - 1, 2);
    }

    public int getLeftChildIndex(int index){
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index){
        return 2 * index + 2;
    }

    public void swap(int index1, int index2) {
        //if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
        //    System.out.println("Invalid digits");
        //} else {
            Account temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
        //}
    }

    public void heapifyUp(int index) {
        int parentIndex = this.getParentIndex(index);
        while (parentIndex >= 0 && data[parentIndex].getBalance() > data[index].getBalance()) {
            swap(parentIndex, index);
            index = parentIndex;
            parentIndex = this.getParentIndex(index);
        }
    }

    public void heapifyDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int largest = index;

        if (leftChildIndex < size && data[leftChildIndex].getBalance() > data[largest].getBalance()) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < size && data[rightChildIndex].getBalance() > data[largest].getBalance()) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Copy constructor (for a deep copy)
    public PQHeap(PQHeap other) {
        this.size = other.size;
        this.data = Arrays.copyOf(other.data, other.data.length);
    }

    // Deep copy method
    public PQHeap deepCopy() {
        PQHeap copy = new PQHeap();
        copy.size = this.size;
        copy.data = Arrays.copyOf(this.data, this.data.length);
        return copy;
    }


    /**
     * Adds a object to the priority queue
     *
     * @param a The Account to add to the priority queue
     */
    @Override
    public void add(Account a) {
        if (size == data.length) {
            // Expand the data array if needed (you can adjust the expansion strategy)
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size] = a;
        heapifyUp(size);
        size++;
    }

    /**
     * Retrieves and removes the account with the highest priority
     *
     * @return the account with the highest priority
     */
    @Override
    public Account getMax() {
        if (size == 0) {
            // Handle the case where the queue is empty
            return null;
        }

        Account max = data[0]; // Get the element with the maximum balance (at the root)
        data[0] = data[size - 1]; // Replace the root with the last element
        size--;
        heapifyDown(0); // Reorganize the heap to maintain the max-heap property
        return max;
    }


    /**
     * Clears all the data from the queue
     */
    @Override
    public void clear() {
        size = 0;
        data = new Account[50];
    }

    /**
     * @return the Length of the queue
     */
    @Override
    public int getLength() {
        return size;
    }

    /**
     * Checks if the queue is empty or not
     *
     * @return {@code true} if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
