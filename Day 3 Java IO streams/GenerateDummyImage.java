import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class GenerateDummyImage {
    public static void main(String[] args) {
        int width = 200;
        int height = 200;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Fill with solid color (e.g., blue)
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, Color.BLUE.getRGB());
            }
        }

        try {
            ImageIO.write(image, "jpg", new File("source_image.jpg"));
            System.out.println("Dummy image 'source_image.jpg' created.");
        } catch (IOException e) {
            System.out.println("Failed to create image: " + e.getMessage());
        }
    }
}
