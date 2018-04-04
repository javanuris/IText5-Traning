package utils;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

import java.io.IOException;

public class ImageUtil {
    static Image logoImage = null;

    public static Image getLogoHybrid() {
        if (logoImage == null) {
            try {
                logoImage = Image.getInstance(ClassLoader.getSystemResource("images/logo_hybrid.png"));
            } catch (BadElementException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logoImage;
    }

    static Image sudImage = null;

    public static Image getLogoSud() {
        if (sudImage == null) {
            try {
                sudImage = Image.getInstance(ClassLoader.getSystemResource("images/logo_sud.png"));
            } catch (BadElementException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sudImage;
    }

    public static Image getF119Template() {
        Image image = null;
        try {
            image = Image.getInstance(ClassLoader.getSystemResource("images/f119_templateJpg.jpg"));
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
