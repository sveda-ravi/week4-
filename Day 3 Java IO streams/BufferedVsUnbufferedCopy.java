import java.io.*;

public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.dat";
        String destUnbuffered = "unbuffered_copy.dat";
        String destBuffered = "buffered_copy.dat";

        long timeUnbuffered = copyWithUnbufferedStreams(sourceFile, destUnbuffered);
        System.out.println("Unbuffered copy time: " + timeUnbuffered + " ns (" + (timeUnbuffered / 1_000_000) + " ms)");

        long timeBuffered = copyWithBufferedStreams(sourceFile, destBuffered);
        System.out.println("Buffered copy time: " + timeBuffered + " ns (" + (timeBuffered / 1_000_000) + " ms)");

        if (timeBuffered < timeUnbuffered) {
            System.out.println("Buffered streams were faster by " + (timeUnbuffered - timeBuffered) / 1_000_000 + " ms.");
        } else {
            System.out.println("Unbuffered streams were faster (unexpected!).");
        }
    }

    private static long copyWithUnbufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in unbuffered copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    private static long copyWithBufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
