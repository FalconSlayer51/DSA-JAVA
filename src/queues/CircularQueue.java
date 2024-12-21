package queues;

import java.util.Arrays;

public class CircularQueue {
    int rear;
    int front;
    int size;
    int capacity;
    int[] queue;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        size = 0;
        front = rear = -1;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else if (rear == capacity - 1 && front != 0) {
            rear = 0;
        } else {
            rear ++;
        }
        size++;
        queue[rear] = element;
        System.out.println("Element is inserted");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int val = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == capacity-1) {
            front = 0;
        } else {
            front ++;
        }
        size--;
        return val;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == capacity -1) || (front!= 0 && rear == (front -1)%capacity);
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public void display() {
        int[] arr1 = Arrays.copyOfRange(queue,front,capacity);
        int[] arr2 = Arrays.copyOfRange(queue,0,rear+1);

        int[] combinedArray = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, combinedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, combinedArray, arr1.length, arr2.length);

        System.out.println(Arrays.toString(combinedArray));
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        System.out.println(queue.peek());
        queue.display();
        queue.enqueue(10);
    }
}
