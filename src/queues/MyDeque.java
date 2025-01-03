package queues;

import java.util.Arrays;

public class MyDeque {
    int rear;
    int front;
    int size;
    int capacity;
    int[] deque;

    public MyDeque(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        size = 0;
        rear = front = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == capacity-1) || (front != 0 && rear == (front-1)%(capacity));
    }

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }

        return deque[front];
    }


    public int peekRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }

        return deque[rear];
    }

    public void enqueueRear(int val) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == capacity-1 && front != 0) {
            rear = 0;
        } else {
            rear ++;
        }
        size++;
        deque[rear] = val;
        System.out.println("Successfully inserted at rear");
    }

    public void enqueueFront(int val) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (front == 0 && rear != capacity-1) {
            front = capacity-1;
        } else {
            front --;
        }
        size++;
        deque[front] = val;
        System.out.println("Successfully inserted at rear");
    }

    public int dequeFront() {
        if (isEmpty()) {
            System.out.println("deque is empty");
            return -1;
        }

        int val = deque[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if(front == capacity-1) {
            front = 0;
        } else {
            front++;
        }
        size --;
        return val;
    }


    public int dequeRear() {
        if (isEmpty()) {
            System.out.println("deque is empty");
            return -1;
        }

        int val = deque[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if(rear == 0) {
            rear = capacity-1;
        } else {
            rear--;
        }
        size --;
        return val;
    }

    public void display() {
        int[] arr1 = Arrays.copyOfRange(deque,front,capacity);
        int[] arr2 = Arrays.copyOfRange(deque,0,rear+1);

        int[] combinedArray = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, combinedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, combinedArray, arr1.length, arr2.length);

        System.out.println(Arrays.toString(combinedArray));
    }

    public static void main(String[] args) {
        MyDeque deque = new MyDeque(5);
        deque.enqueueRear(20);
        deque.enqueueFront(10);
        System.out.println(deque.peekFront());
        deque.dequeFront();
        System.out.println(deque.peekFront());
        deque.enqueueRear(10);
        deque.dequeRear();
        deque.display();
    }
}
