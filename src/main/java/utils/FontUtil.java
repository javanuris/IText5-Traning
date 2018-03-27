package utils;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

import java.io.IOException;

public class FontUtil {

    public static Font ocrb(int size) {
        Font font = fontLoader(ClassLoader.getSystemResource("fonts/OCRB.TTF").toString());
        font.setSize(size);
        return font;
    }

    public static Font openSansLight(int size) {
        Font font = fontLoader(ClassLoader.getSystemResource("fonts/OpenSans-Light.ttf").toString());
        font.setSize(size);
        return font;
    }


    public static Font openSansBold(int size) {
        Font font = fontLoader(ClassLoader.getSystemResource("fonts/OpenSans-Bold.ttf").toString());
        font.setSize(size);
        return font;
    }

    public static Font openSansSemiBold(int size) {
        Font font = fontLoader(ClassLoader.getSystemResource("fonts/OpenSans-Semibold.ttf").toString());
        font.setSize(size);
        return font;
    }

    public static Font openSansRegular(int size) {
        Font font = fontLoader(ClassLoader.getSystemResource("fonts/OpenSans-Regular.ttf").toString());
        font.setSize(size);
        return font;
    }

    public static Font fre3of9x(float size) {
        Font font = fontLoader(ClassLoader.getSystemResource("fonts/fre3of9x.ttf").toString());
        font.setSize(size);
        return font;
    }

    public static Font courier(float size) {
        Font font = fontLoader(ClassLoader.getSystemResource("fonts/cour.ttf").toString());
        font.setSize(size);
        font.setStyle(Font.BOLD);
        return font;
    }


    public static Font helvetica(int size) {
        Font font = new Font(Font.FontFamily.HELVETICA);
        font.setSize(size);
        return font;
    }

    private static Font fontLoader(String fontPath) {

        BaseFont bf = null;
        try {
            bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font font = new Font(bf);

        return font;
    }

}
