import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.Test.None;

import java.util.LinkedList;
import java.util.ListIterator;

public class myQueue<T> implements QueueADT<T> {
    private Node start;
    private Node end;

    public myQueue() {
        start = null;
        end = null;
    }   
    
    /**
     * Add an item to the queue
     * @param item the data item to add (of type T)
     */
    public void enqueue(T item) {
        Node foo = new Node(item);
        
        if (start == null) {
            start = foo;
            end = foo;
            return;
        }

        end.next = foo;
        end = foo;
    }

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() throws NoSuchElementException {
        if (start == null)
            throw new NoSuchElementException();
        
            T item = start.data;
        start = start.next;
        return item;
    }

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T front() throws NoSuchElementException {
        if (start == null)
            throw new NoSuchElementException();
        return start.data;
    }

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public int size() {
        int x = 0;

        Node foo = start;
        while(foo != null){
            x++;
            foo = foo.next;
        }

        return x;
    }

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty() {
        if (start == null) return true;
        return false;
    }

    /**
     * Clear out the data structure
     */
    public void clear() {
        start = null;
        end = null;
    }


    // Node class
    private class Node {
        public T data; 
        public Node next;

        public Node(T x) {
            this.data = x;
            this.next = null;
        }
    }

}