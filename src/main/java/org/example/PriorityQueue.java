package org.example;


/**
 * The priority Queue interface defines a contract for a prioirty queue that stores instances of the {@link Account} class
 */

public interface PriorityQueue {
    /**
     * Adds a object to the priority queue
     * @param a The Account to add to the priority queue
     */
    void add(Account a);

    /**
     * Retrieves and removes the account with the highest priority
     * @return the account with the highest priority
     */
    Account getMax();

    /**
     * Clears all the data from the queue
     */
    void clear();

    /**
     *
     * @return the Length of the queue
     */
    int getLength();

    /**
     * Checks if the queue is empty or not
     * @return {@code true} if the queue is empty
     */
    boolean isEmpty();
}

