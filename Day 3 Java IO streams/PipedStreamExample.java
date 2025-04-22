import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pipedOutputStream;

    public WriterThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        String dataToWrite = "Hello from Writer Thread!";
        try {
            System.out.println("Writer Thread: Writing data...");
            pipedOutputStream.write(dataToWrite.getBytes());
            pipedOutputStream.flush(); // Ensure the data is written immediately
            System.out.println("Writer Thread: Data written.");
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pipedInputStream;

    public ReaderThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        try {
            System.out.println("Reader Thread: Waiting to read data...");
            byte[] buffer = new byte[1024];
            int bytesRead = pipedInputStream.read(buffer);
            String dataReceived = new String(buffer, 0, bytesRead);
            System.out.println("Reader Thread: Data received: " + dataReceived);
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            // Create PipedOutputStream and PipedInputStream
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

            // Create and start the WriterThread
            WriterThread writerThread = new WriterThread(pipedOutputStream);
            writerThread.start();

            // Create and start the ReaderThread
            ReaderThread readerThread = new ReaderThread(pipedInputStream);
            readerThread.start();

            // Wait for both threads to finish
            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error in threads: " + e.getMessage());
        }
    }
}
