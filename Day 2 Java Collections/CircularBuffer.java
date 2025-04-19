public class CircularBuffer {
    private int[] buffer;
    private int head;  // Points to the oldest element
    private int tail;  // Points to the next insertion point
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            // Overwrite oldest → move head forward
            head = (head + 1) % capacity;
        }
    }

    public void printBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            System.out.print(buffer[index]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer();  // Output: [1, 2, 3]

        cb.insert(4);
        cb.printBuffer();  // Output: [2, 3, 4]

        cb.insert(5);
        cb.printBuffer();  // Output: [3, 4, 5]
    }
}
