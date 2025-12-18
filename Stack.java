interface StackADT {
    void push(int x);
    int pop();
    int peek();
    boolean isEmpty();
    boolean isFull();
    int size();
}

class ArrayStack implements StackADT {

    private int[] arr;
    private int top;
    private int capacity;

    public ArrayStack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (isFull())
            throw new RuntimeException("Stack Overflow");
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Stack Underflow");
        return arr[top--];
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Stack Empty");
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }
}

class Main {
    public static void main(String[] args) {
        StackADT s = new ArrayStack(5);

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Size: " + s.size());   // 3
        System.out.println("Is Full: " + s.isFull()); // false
        System.out.println("Popped: " + s.pop());  // 30
        System.out.println("Peek: " + s.peek());   // 20
    }
}
