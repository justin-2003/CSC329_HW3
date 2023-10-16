package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //the input path of the file
        String inputFile ="/Users/justinsam/Desktop/CSC329_HW3/src/main/java/org/example/accounts 2.txt";

        // Create an instance of the priority queue
        PQHeap priorityQueue = new PQHeap();
        PQHeap copyQueue = new PQHeap(priorityQueue); // Testing copy constructor
        PQHeap deepCopyQueue = priorityQueue.deepCopy();


        // Read the file and populate the priority queue
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            String name = null;
            double balance = 0.0;

            while ((line = br.readLine()) != null) {
                if (name == null) {
                    name = line.trim(); // Trim leading/trailing whitespace
                } else {
                    try {
                        balance = Double.parseDouble(line.trim()); // Trim leading/trailing whitespace
                        Account account = new Account(name, balance);
                        priorityQueue.add(account);
                        name = null;
                        balance = 0.0;
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping line due to parsing error: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        heapsort(priorityQueue);

        while (!copyQueue.isEmpty()) {
            Account account = deepCopyQueue.getMax();
            System.out.println("------------------------");
            System.out.println("Copy Queue - Account: " + account.getName() + ", Balance: " + account.getBalance());
        }

    }

    public static void heapsort(PQHeap priorityQueue) {
        PQHeap sortedQueue = new PQHeap(priorityQueue); // Create a sorted copy of the original queue
        while (!sortedQueue.isEmpty()) {
            Account maxAccount = sortedQueue.getMax();
            System.out.println("Account: " + maxAccount.getName() + ", Balance: " + maxAccount.getBalance());
        }
    }
}