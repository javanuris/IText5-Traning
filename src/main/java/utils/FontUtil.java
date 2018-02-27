package utils;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

import java.io.IOException;

public class FontUtil {

    private Font fontLoader(String fontPath) {

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
