package queues;

import java.util.Stack;

// if the test cases have more enqueues prefer costly deque method and vice versa

public class QueuesUsingStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    void enqueue(int element) {
        if (stack1.isEmpty()) {
            stack1.push(element);
            return;
        }

        // move all elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(element);

        // move all elements from stack1 to stack2
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    int peek() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return stack1.peek();
    }

    int dequeue() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        System.out.println("Deque is successful");
        return stack1.pop();
    }


    public static void main(String[] args) {
        QueuesUsingStack queue = new QueuesUsingStack();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.peek());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.peek() + "peek after dequeue");
    }
}
