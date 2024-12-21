package queues;


import java.util.Arrays;

interface MyQueueADT<T> {
    void enqueue(T element);
    T dequeue();

    int size();

    void display();

    T peek();

    boolean isEmpty();
}
public class MyQueue<T> implements MyQueueADT<T>{
    private T[] queue;
    private int capacity;
    public MyQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }


    int FRONT = -1;
    int REAR = -1;
    @Override
    public void enqueue(T element) {
        if (size() >= capacity) {
            System.out.println("Queue overflown");
            return;
        }
        if (isEmpty()) {
            FRONT = 0;
            REAR = 0;
        } else {
            REAR ++;
        }
        queue[REAR] = element;
        System.out.println("Element inserted");
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }
        T curretElement = queue[FRONT];
        if (FRONT == REAR) {
            FRONT = -1;
            REAR = -1;
        } else {
            FRONT++;
        }
        return curretElement;
    }

    @Override
    public int size() {
        return REAR - FRONT + 1;
    }

    @Override
    public void display() {
        T[] arr = Arrays.copyOfRange(queue,FRONT,REAR +1);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }
        return queue[FRONT];
    }

    @Override
    public boolean isEmpty() {
        return FRONT == -1;
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>(3);
        queue.enqueue("ramesh");
        queue.enqueue("suresh");
        queue.enqueue("ramya");
        queue.enqueue("damya");
        queue.display();
        System.out.println(queue.size());
        queue.dequeue();
        queue.display();
        System.out.println(queue.size());
        System.out.println(queue.peek());
    }
}


