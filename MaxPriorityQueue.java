class Queue {
    protected int front;
    protected int rear;
    protected int size;
    protected int capacity;
    protected Object[] queue;

    public Queue(int capacity) {
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
        this.queue = new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(Object item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = item;
            size++;
        }
    }

    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        } else {
            Object removedItem = queue[front];
            front = (front + 1) % capacity;
            size--;
            return removedItem;
        }
    }
}

public class MaxPriorityQueue extends Queue {
    public MaxPriorityQueue(int capacity) {
        super(capacity);
    }

    public void enqueueWithPriority(Object item, int priority) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            int index = rear;
            while (index >= 0 && ((Comparable) queue[index]).compareTo(priority) < 0) {
                queue[(index + 1) % capacity] = queue[index];
                index--;
            }

            queue[(index + 1) % capacity] = item;
            rear = (rear + 1) % capacity;
            size++;
        }
    }
}
// Time complexity for Enqueue operation in Max Priority Queue: O(n) in the worst case
// (when the element needs to be inserted at the beginning of the queue)

// Time complexity for Dequeue operation in Max Priority Queue: O(1)

