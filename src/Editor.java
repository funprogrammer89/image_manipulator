import java.awt.Color;
import java.util.*;

public class Editor {
    public static void main(String[] args) {
        System.out.print("What picture would you like to edit? ");
        Scanner in = new Scanner(System.in);
        String file = in.next();
        Picture picture = new Picture(file);
        int choice = 0;
        while (choice != 8) {
            System.out.println("\nOperations");
            System.out.println("1. Shrink");
            System.out.println("2. Grow");
            System.out.println("3. Grayscale");
            System.out.println("4. Invert Colors");
            System.out.println("5. Rotate Right");
            System.out.println("6. Rotate Left");
            System.out.println("7. Display Image");
            System.out.println("8. Quit");
            System.out.print("\nEnter command: ");
            choice = in.nextInt();
            if (choice == 1) {
                picture = shrink(picture);
            } else if (choice == 2) {
                picture = grow(picture);
            } else if (choice == 3) {
                picture = grayscale(picture);
            } else if (choice == 4) {
                picture = invert(picture);
            } else if (choice == 5) {
                picture = rotateRight(picture);
            } else if (choice == 6) { // Three right rotations = left rotation
                picture = rotateRight(picture);
                picture = rotateRight(picture);
                picture = rotateRight(picture);
            } else if (choice == 7) {
                picture.show();
            }
        }

}
    public static Picture grow(Picture p) {
        Picture growPicture = new Picture(p.width() * 2, p.height() * 2);
        for (int i = 0; i < growPicture.width(); i++) {
            for (int j = 0; j < growPicture.height(); j++) {
                Color pixel = p.get(i / 2, j / 2);
                growPicture.set(i, j, pixel);
            }
        }
        return growPicture;
    }

    public static Picture shrink(Picture p) {
        Picture shrinkPicture = new Picture(p.width() / 2, p.height() / 2);
        for (int i = 0; i < shrinkPicture.width(); i++) {
            for (int j = 0; j < shrinkPicture.height(); j++) {
                Color pixel = p.get(i * 2, j * 2);
                shrinkPicture.set(i, j, pixel);
            }
        }
        return shrinkPicture;
    }

    public static Picture invert(Picture p) {
        Picture invertPicture = new Picture(p.width(), p.height());
        for (int i = 0; i < p.width(); ++i) {
            for (int j = 0; j < p.height(); ++j) {
                Color pixel = p.get(i, j);
                Color newPixel = new Color(255 - pixel.getRed(), 255 - pixel.getGreen(), 255 - pixel.getBlue());
                invertPicture.set(i, j, newPixel);
            }
        }
        return invertPicture;
    }

    public static Picture grayscale(Picture p) {
        Picture grayscalePicture = new Picture(p.width(), p.height());
        for (int i = 0; i < p.width(); ++i) {
            for (int j = 0; j < p.height(); ++j) {
                Color pixel = p.get(i, j);
                int greyscaleValue = (int) Math.round((.3 * pixel.getRed() + .59 * pixel.getGreen() + .11 * pixel.getBlue()));
                Color newPixel = new Color(greyscaleValue, greyscaleValue, greyscaleValue);
                grayscalePicture.set(i, j, newPixel);
            }
        }
        return grayscalePicture;
    }

    public static Picture rotateRight(Picture p) {
        Picture rotateRightPicture = new Picture(p.height(), p.width());

        for (int i = 0; i < p.width(); ++i) {
            for (int j = 0; j < p.height(); ++j) {
                rotateRightPicture.set(p.height() - j - 1, i, p.get(i, j));
            }
        }
        return rotateRightPicture;
    }
}