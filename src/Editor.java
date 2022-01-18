import java.awt.Color;
import java.util.*;
public class Editor {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print("What picture would you like to edit? ");
        Scanner in = new Scanner(System.in);
        String file = in.next();
        Picture picture = new Picture(file);
        int choice = 0;
        while (choice != 6) {
            System.out.println("");
            System.out.println("Operations");
            System.out.println("1. Grow");
            System.out.println("2. Grayscale");
            System.out.println("3. Invert");
            System.out.println("4. Rotate Left");
            System.out.println("5. Display Image");
            System.out.println("6. Quit");
            System.out.print("Enter command: ");
            choice = in.nextInt();
            if (choice == 1) {
                picture = grow(picture);
            }
            else if (choice == 2) {
                picture = grayscale(picture);
            }
            else if (choice == 3) {
                picture = invert(picture);
            }
            else if (choice == 4) {
                picture = rotateLeft(picture);
            }
            else if (choice == 5) {
                picture.show();
            }
        }
    }

    public static Picture grow( Picture p ) {

        Picture growPicture = new Picture(p.width() * 2, p.height() * 2);


        for (int i = 0; i < growPicture.width(); i++) {
            for (int j = 0; j < growPicture.height(); j++) {
                Color pixel = p.get(i/2, j/2);
                growPicture.set(i, j, pixel);


            }

        }


        return growPicture;
    }


    public static Picture invert( Picture p ) {
        Picture invertPicture = new Picture(p.width(),p.height());
        for (int i = 0; i < p.width(); ++i) {
            for (int j = 0; j < p.height(); ++j) {
                Color pixel = p.get(i, j);
                Color newPixel = new Color(255 - pixel.getRed(),255 - pixel.getGreen(),255 - pixel.getBlue());
                invertPicture.set(i, j, newPixel);
            }
        }
        return invertPicture;
    }

    public static Picture grayscale( Picture p ) {
        Picture grayscalePicture = new Picture(p.width(),p.height());
        for (int i = 0; i < p.width(); ++i) {
            for (int j = 0; j < p.height(); ++j) {
                Color pixel = p.get(i, j);
                int greyscaleValue = (int)Math.round((.3 * pixel.getRed() + .59 * pixel.getGreen() + .11 * pixel.getBlue()));
                Color newPixel = new Color(greyscaleValue,greyscaleValue,greyscaleValue);
                grayscalePicture.set(i, j, newPixel);
            }
        }

        return grayscalePicture;
    }


    public static Picture rotateLeft( Picture p ) {
        Picture rotateLeftPicture = new Picture(p.height(),p.width());

        for (int i = 0; i < p.width(); ++i) {
            for (int j = 0; j < p.height(); ++j) {
                //Color pixel = p.get(i, j);
                rotateLeftPicture.set(p.height()-j-1,i, p.get(i, j));
            }
        }
        return rotateLeftPicture;
    }
    public static void sort( int[] values ) {

    }
}
