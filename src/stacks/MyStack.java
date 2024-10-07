package stacks;

interface MyStackADT {
    void push(int element) throws Exception;
    int pop() throws Exception;
    int peek() throws Exception;
    boolean isEmpty();
    int size();
    void printStack();
}

public class MyStack implements MyStackADT{
    private final int size;
    private int top = -1;
    private final int[] stack;


    public MyStack(int size) {
        this.size = size;
        stack = new int[size];
    }


    @Override
    public void push(int element) throws Exception {
        if (top>=size-1) {
            throw new Exception("Stack Overflow");
        }

        top++;
        stack[top] = element;
        System.out.println("Element pushed");
    }

    @Override
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack Underflow");
        }

        int element = stack[top];
        top --;
        return element;
    }

    @Override
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack Underflow");
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public void printStack() {
        for (int i =0;i<=top;i++) {
            System.out.print(stack[i]);
            if(i!=top)
                System.out.print(",");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        int size = 5;
        MyStack stack = new MyStack(size);
        stack.push(5);
        stack.push(10);
        stack.printStack();
        System.out.println("Top element "+stack.peek());
        int poppedElement = stack.pop();
        System.out.println("Popped element "+poppedElement);
        System.out.println("Top element "+stack.peek());
        System.out.println("Size of stack "+stack.size());
    }
}
