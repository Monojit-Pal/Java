interface QueueADT {
    void enqueue(int x);
    int dequeue();
    int peek();
    boolean isEmpty();
    boolean isFull();
    int size();
}

class ArrayQueue implements QueueADT {

    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    public ArrayQueue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
    }

    public void enqueue(int x) {
        if (isFull())
            throw new RuntimeException("Queue Overflow");
        arr[++rear] = x;
    }

    public int dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue Underflow");
        return arr[front++];
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");
        return arr[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public int size() {
        return rear - front + 1;
    }
}

class Main {
    public static void main(String[] args) {
        QueueADT q = new ArrayQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Size: " + q.size());       // 3
        System.out.println("Is Full: " + q.isFull());  // false
        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Peek: " + q.peek());       // 20
    }
}
