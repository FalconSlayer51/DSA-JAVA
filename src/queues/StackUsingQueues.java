package queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int element) {
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        queue1.offer(element);
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
    }

    public int peek() {
        if (queue1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue1.peek();
    }

    public int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue1.poll();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        stack.peek();
    }
}
