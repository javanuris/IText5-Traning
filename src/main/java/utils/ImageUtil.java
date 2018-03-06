package utils;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

import java.io.IOException;

public class ImageUtil {
    public static Image getLogoHybrid() {
        Image image = null;
        try {
            image = Image.getInstance(ClassLoader.getSystemResource("images/logo_hybrid.png"));
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
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
